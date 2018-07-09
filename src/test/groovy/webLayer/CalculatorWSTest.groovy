package webLayer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException

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
		numericOne	| numericTwo | operationType || expectedResult	|| expectedStatus
		"LX"		| "XIV"		 | "+"			 || "LXXIV"			|| status().isOk()
		"LX"		| "XIV"		 | "-"	 		 || "XLVI"			|| status().isOk()
		"LX"		| "XIV"		 | "/"			 || "IV"			|| status().isOk()
		"LX"		| "XIV"		 | "*"	 	 	 || "DCCCXL"		|| status().isOk()
		"LX"		| "XIV"		 | "%"	 	 	 || "IV"			|| status().isOk()
	}

	@Test
	@Unroll
	def'when an unsupported operation is selected, an operator type not supported message is returned'() {

		when: 'when two roman numericals are passed as Strings'
		def response = mockMvc.perform(get("/calc").contentType(MediaType.APPLICATION_JSON)
				.param("num1", numericOne)
				.param("num2", numericTwo)
				.param("operationType", operationType))

		then: ' sum of both numericals is returned in roman numerical form as a String'
		NestedServletException exception = thrown()
		exception.getMessage() == "Request processing failed; nested exception is java.lang.ArithmeticException: calculator error : operator type not supported."

		where:
		numericOne	| numericTwo | operationType || expectedResult	|| expectedStatus
		"X"			| "X"		 | "^"			 || "X"				|| status().isOk()
	}

	@Test
	@Unroll
	def'when a GET request is made to calc/operations the expected operators are returned'() {

		when: 'when a GET request is made to calc/operations'
		def response = mockMvc.perform(get("/calc/operations").contentType(MediaType.APPLICATION_JSON))
		then: 'the expected operators are returned'
		response
				.andExpect(content().string(expectedResult))
				.andExpect(expectedStatus)

		where:
		expectedResult	|| expectedStatus
		"+-/*%"			|| status().isOk()
	}

	def 'when a GET request is made to the /calc/status url the expected response message and a 200 OK status should be returned'() {

		when: 'a GET request is made to /calc/status'
		def response = mockMvc.perform(get("/calc/status").contentType(MediaType.APPLICATION_JSON))

		then: 'expected response code is OK'
		response
				.andExpect(status().isOk())
				.andExpect(content().string("status : webService online"));
	}
}
