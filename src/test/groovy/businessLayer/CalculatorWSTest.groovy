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

		where:
		numericOne	| numericTwo || expected
		"D"			| "D"		 || "{'theResult':'M'}"
		"CD"		| "D"		 || "{'theResult':'CM'}"
		"CCL"		| "CCL"		 || "{'theResult':'D'}"
		"CC"		| "CC"		 || "{'theResult':'CD'}"
		"L"			| "L"		 || "{'theResult':'C'}"
		"L"			| "XL"		 || "{'theResult':'XC'}"
		"XXV"		| "XXV"		 || "{'theResult':'L'}"
		"XX"		| "XX"		 || "{'theResult':'XL'}"
		"V"			| "V"		 || "{'theResult':'X'}"
		"V"			| "IV"		 || "{'theResult':'IX'}"
		"IV"		| "I"		 || "{'theResult':'V'}"
		"II"		| "II"		 || "{'theResult':'IV'}"
		"I"			| "I"		 || "{'theResult':'II'}"
	}
	
}
