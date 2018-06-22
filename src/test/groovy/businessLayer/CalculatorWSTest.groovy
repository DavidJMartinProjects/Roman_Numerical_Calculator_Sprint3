package businessLayer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test

import groovy.json.*;
import spock.lang.Specification;
import spock.lang.Unroll

@WebMvcTest(controllers = businessLayer.CalculatorWS.class)
class CalculatorWSTest extends Specification {
	
	@Autowired
	MockMvc mockMvc;
	
	def 'when a GET request is made to the /calc/status url a 200 OK status should be returned'() {
		when: 'a GET request is made to /calc/status'
		def response = mockMvc.perform(get("/calc/status").contentType(MediaType.APPLICATION_JSON))
		then: 'expected response code is OK'
		response.
				andExpect(status().isOk())
	}


	def 'when a GET request is made to the /calc/status url the JSON response should contain the expected JSON content'() {
		when: 'a GET request is made to /calc/status'
		def response = mockMvc.perform(get("/calc/status").contentType(MediaType.APPLICATION_JSON))
		then: 'the JSON response should contain the text content\':\'Status : Online'
		response
				.andExpect(content().string("status : webService online"));
	}	
	
	@Test
	@Unroll
	def'when #numericOne and #numericTwo are passed as Strings #expected is returned as a String'() {

		given:
		// insert mocks here

		when: 'when two roman numericals are passed as Strings'
			def response = mockMvc.perform(get("/calc/addition").contentType(MediaType.APPLICATION_JSON)
				.param("num1", numericOne)
				.param("num2", numericTwo))

		then: ' sum of both numericals is returned in roman numerical form as a String'
			response
				.andExpect(content().json(expected))
				.andExpect(expectedStatus)			

		where:
		numericOne	| numericTwo || expected				|| expectedStatus
		"D"			| "D"		 || "{'theResult':'M'}"		|| status().isOk()
		"CD"		| "D"		 || "{'theResult':'CM'}"	|| status().isOk()
		"CCL"		| "CCL"		 || "{'theResult':'D'}"		|| status().isOk()
		"CC"		| "CC"		 || "{'theResult':'CD'}"	|| status().isOk()
		"L"			| "L"		 || "{'theResult':'C'}"		|| status().isOk()
		"L"			| "XL"		 || "{'theResult':'XC'}"	|| status().isOk()
		"XXV"		| "XXV"		 || "{'theResult':'L'}"		|| status().isOk()
		"XX"		| "XX"		 || "{'theResult':'XL'}"	|| status().isOk()
		"V"			| "V"		 || "{'theResult':'X'}"		|| status().isOk()
		"V"			| "IV"		 || "{'theResult':'IX'}"	|| status().isOk()
		"IV"		| "I"		 || "{'theResult':'V'}"		|| status().isOk()
		"II"		| "II"		 || "{'theResult':'IV'}"	|| status().isOk()
		"I"			| "I"		 || "{'theResult':'II'}"	|| status().isOk()
	}
	
}
