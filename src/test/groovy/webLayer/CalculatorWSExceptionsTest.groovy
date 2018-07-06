package webLayer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
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
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes= businessLayer.Application.class)
@WebMvcTest(controllers = webLayer.CalculatorWS.class)
class CalculatorWSExceptionsTest extends Specification {

	@Autowired
	MockMvc mockMvc;

	def numericOne, numericTwo, expectedStatus, exceptionMessage, operationType

//	@Test
//	@Unroll
//	def'when invalid inputs #numericOne and #numericTwo are called usign the AddOperation an expection is thrown with the appropriate message'() {
//
//		when: 'when two roman numericals are passed as Strings'
//		def response = mockMvc.perform(get("/calc").contentType(MediaType.APPLICATION_JSON)
//				.param("num1", numericOne)
//				.param("num2", numericTwo)
//				.param("operationType", operationType))
//
//		then: ' sum of both numericals is returned in roman numerical form as a String'
//		
//			NestedServletException exception = thrown()
//			print(exception)
//			exception.getCause()  == ArithmeticException
////			exception == exceptionMessage
//
//
//		where:
//		numericOne	| numericTwo | operationType	 || exceptionMessage											
//		"MMMCMXCIX"	| "I"		 | "+"				 || "java.lang.ArithmeticException:<b>addition error :</b> result is greater than 3999."		
//	}
	
}
