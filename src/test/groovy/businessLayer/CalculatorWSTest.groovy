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

import groovy.json.*;
import spock.lang.Specification;

@WebMvcTest(controllers = CalculatorWS.class)
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
	
}
