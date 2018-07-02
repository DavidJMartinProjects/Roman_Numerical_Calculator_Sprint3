package webLayer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.core.StringContains.containsString;
import org.junit.Test
import org.junit.runner.RunWith
import groovy.json.*;
import spock.lang.Specification;
import spock.lang.Unroll

@ContextConfiguration(classes= businessLayer.Application.class)
@WebMvcTest(controllers = webLayer.CalculatorWS.class)
class CalculatorWSTest extends Specification {

	@Autowired
	MockMvc mockMvc;

	def numericOne, numericTwo, expectedStatus, exceptionMessage, expectedResult, operationType

	def 'when a GET request is made to the /calc/status url the expected response message and a 200 OK status should be returned'() {

		when: 'a GET request is made to /calc/status'
		def response = mockMvc.perform(get("/calc/status").contentType(MediaType.APPLICATION_JSON))

		then: 'expected response code is OK'
		response
				.andExpect(status().isOk())
				.andExpect(content().string("status : webService online"));
	}

	@Test
	@Unroll
	def'when #numericOne and #numericTwo are passed as Strings #expectedResult is returned as a String along the appropriate http response code'() {

		when: 'when two roman numericals are passed as Strings'
		def response = mockMvc.perform(get("/calc").contentType(MediaType.APPLICATION_JSON)
				.param("num1", numericOne)
				.param("num2", numericTwo)
				.param("operationType", operationType))

		then: ' sum of both numericals is returned in roman numerical form as a String'
		response
				.andExpect(content().string(expectedResult))
				.andExpect(expectedStatus)

		where:
		numericOne	| numericTwo | operationType || expectedResult		|| expectedStatus
		"D"			| "D"		 | "add"		 || "M"					|| status().isOk()
		"CD"		| "D"		 | "add"		 || "CM"				|| status().isOk()
		"CCL"		| "CCL"		 | "add"		 || "D"					|| status().isOk()
		"CC"		| "CC"		 | "add"		 || "CD"				|| status().isOk()
		"L"			| "L"		 | "add"		 || "C"					|| status().isOk()
		"L"			| "XL"		 | "add"		 || "XC"				|| status().isOk()
		"XXV"		| "XXV"		 | "add"   		 || "L"					|| status().isOk()
		"XX"		| "XX"		 | "add"		 || "XL"				|| status().isOk()
		"V"			| "V"		 | "add"		 || "X"					|| status().isOk()
		"V"			| "IV"		 | "add"		 || "IX"				|| status().isOk()
		"IV"		| "I"		 | "add"		 || "V"					|| status().isOk()
		"II"		| "II"		 | "add"		 || "IV"				|| status().isOk()
		"I"			| "I"		 | "add"		 || "II"				|| status().isOk()
	}

	//	@Test
	//	def 'when an invalid String is passed as an input verify that the correct exception is thrown'() {
	//		when: 'when two roman numericals are passed as Strings'
	//		def response = mockMvc.perform(get("/calc/addition").contentType(MediaType.APPLICATION_JSON)
	//				.param("num1", numericOne)
	//				.param("num2", numericTwo)
	//				.param("operationType", operationType))
	//
	//		then: ' sum of both numericals is returned in roman numerical form as a String'
	//		response
	//				.andExpect(expectedStatus)
	//				.andExpect(content().string(containsString(exceptionMessage)));
	//
	//		where:
	//		numericOne	| numericTwo | operationType|| expectedStatus					|| exceptionMessage
	//		"MMMMM"		| "MMMMM"	 | "add"		|| status().isInternalServerError()	|| "Invalid Roman Numeral Entered."
	//	}
}
