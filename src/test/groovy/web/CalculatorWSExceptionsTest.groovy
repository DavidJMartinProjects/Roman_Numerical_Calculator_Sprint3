package web

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

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import groovy.json.*;
import spock.lang.Specification;
import spock.lang.Unroll
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes= business.Application.class)
@WebMvcTest(controllers = web.CalculatorWS.class)
class CalculatorWSExceptionsTest extends Specification {

	@Autowired
	MockMvc mockMvc;

	def numericOne, numericTwo, expectedStatus, exceptionMessage, operationType, response
	def exceptionPrefix = "Request processing failed; nested exception is java.lang.ArithmeticException: "

	@Test
	@Unroll
	def'when invalid inputs #numericOne and #numericTwo are called using the Add Operation, an exception is thrown with an appropriate message'() {

		when: 'when two roman numericals are passed as Strings'
		def response = mockMvc.perform(get("/calc").contentType(MediaType.APPLICATION_JSON)
				.param("num1", numericOne)
				.param("num2", numericTwo)
				.param("operationType", operationType))
		
		then: ' sum of both numericals is returned in roman numerical form as a String'
	
		NestedServletException exception = thrown()
		exception.getMessage() == (exceptionPrefix + exceptionMessage)
		
		where:
		numericOne	| numericTwo | operationType	 || exceptionMessage
		"MM"		| "MM"		 | "+"				 || "addition error : result is greater than 3999."		
	}
	
	@Test
	@Unroll
	def'when invalid inputs #numericOne and #numericTwo are called using the Subtract Operation, an exception is thrown with an appropriate message'() {

		when: 'when two roman numericals are passed as Strings'
		def response = mockMvc.perform(get("/calc").contentType(MediaType.APPLICATION_JSON)
				.param("num1", numericOne)
				.param("num2", numericTwo)
				.param("operationType", operationType))
		
		then: ' sum of both numericals is returned in roman numerical form as a String'
	
		NestedServletException exception = thrown()
		exception.getMessage() == (exceptionPrefix + exceptionMessage)
		
		where:
		numericOne	| numericTwo | operationType	 || exceptionMessage
		"X"		| "XI"		 | "-"				 || "subtraction error : numeral 1 is greater than numeral 2"
		"X"		| "X"		 | "-"				 || "subtraction error : result was zero."
	}
	
	@Test
	@Unroll
	def'when invalid inputs #numericOne and #numericTwo are called using the Divide Operation, an exception is thrown with an appropriate message'() {

		when: 'when two roman numericals are passed as Strings'
		def response = mockMvc.perform(get("/calc").contentType(MediaType.APPLICATION_JSON)
				.param("num1", numericOne)
				.param("num2", numericTwo)
				.param("operationType", operationType))
		
		then: ' sum of both numericals is returned in roman numerical form as a String'
	
		NestedServletException exception = thrown()
		exception.getMessage() == (exceptionPrefix + exceptionMessage)
		
		where:
		numericOne	| numericTwo | operationType	 || exceptionMessage
			"X"		| "XI"		 | "/"				 || "division error : numeral 1 is greater than numeral 2."		
	}
	
	@Test
	@Unroll
	def'when invalid inputs #numericOne and #numericTwo are called using the Multiply Operation, an exception is thrown with an appropriate message'() {

		when: 'when two roman numericals are passed as Strings'
		def response = mockMvc.perform(get("/calc").contentType(MediaType.APPLICATION_JSON)
				.param("num1", numericOne)
				.param("num2", numericTwo)
				.param("operationType", operationType))
		
		then: ' sum of both numericals is returned in roman numerical form as a String'
	
		NestedServletException exception = thrown()
		exception.getMessage() == (exceptionPrefix + exceptionMessage)
		
		where:
		numericOne	| numericTwo | operationType	 || exceptionMessage
			"MM"	| "MM"		 | "*"				 || "multiplication error : result is greater than 3999."
	}
	
	@Test
	@Unroll
	def'when invalid inputs #numericOne and #numericTwo are called using the Modulus Operation, an exception is thrown with an appropriate message'() {

		when: 'when two roman numericals are passed as Strings'
		def response = mockMvc.perform(get("/calc").contentType(MediaType.APPLICATION_JSON)
				.param("num1", numericOne)
				.param("num2", numericTwo)
				.param("operationType", operationType))
		
		then: ' sum of both numericals is returned in roman numerical form as a String'
	
		NestedServletException exception = thrown()
		exception.getMessage() == (exceptionPrefix + exceptionMessage)
		
		where:
		numericOne	| numericTwo | operationType	 || exceptionMessage
				"X"	| "XI"		 | "%"				 || "modulus error : numeral 1 is greater than numeral 2"
				"X"	| "X"		 | "%"				 || "modulus error : result was zero."
	}
}
