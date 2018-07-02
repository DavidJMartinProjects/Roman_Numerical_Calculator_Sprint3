package businessLayer;


import org.springframework.beans.factory.annotation.Autowired

import businessLayer.api.Calculator
import businessLayer.operations.AddOperation

/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2014
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.hibernate.validator.internal.metadata.aggregated.ValidatableParametersMetaData
import org.junit.Before
import org.junit.Test

import groovy.json.*
import spock.lang.Specification
import spock.lang.Unroll
import utils.Validator

class OperationContextTest extends Specification {

	def expected, numericOne, numericTwo
	def theConverter = new Converter()
	def theValidator = new Validator()
	def theOperation = new AddOperation()
	def theOperationContext = new OperationContext();
	
	
	@Test
	@Unroll
	def 'verify that if the numeral is I X or C you cannot have more than three in succession'() {
		given:
		theOperationContext.setOperation(theOperation)

		when: 'when two roman numericals are passed as Strings'
		def result = theOperationContext.performOperation(numericOne,numericTwo)

		then: 'if the numeral is I, X or C, you cannot have more than three in succession'
		expected == result

		where:
		numericOne	| numericTwo || expected
		"I"			| "III"		 || "IV"
		"II"		| "II"		 || "IV"
		"X"			| "XXX"		 || "XL"
		"XX"		| "XX"		 || "XL"
		"C"			| "CCC"		 || "CD"
		"CC"		| "CC"		 || "CD"
	}

	@Test
	@Unroll
	def 'verify that if the numeral is V L or D you cannot have more that one in succession'() {
		given:
		theOperationContext.setOperation(theOperation)

		when: 'when two roman numericals are passed as Strings'
		def result = theOperationContext.performOperation(numericOne,numericTwo)

		then: 'if the numeral is I, X or C, you cannot have more that one in succession'
		expected == result

		where:
		numericOne	| numericTwo || expected
		"V"			| "V"		 || "X"
		"L"			| "L"		 || "C"
		"D"			| "D"		 || "M"
	}

	@Test
	@Unroll
	def 'verify that calculations around roman single numeral boundaries are behaving as expected'() {
		given:
		theOperationContext.setOperation(theOperation)

		when: 'when two roman numericals are passed as Strings'
		def result = theOperationContext.performOperation(numericOne,numericTwo)

		then: 'verify that calculations around roman numeral boundaries are behaving as expected'
		expected == result

		where:
		numericOne	| numericTwo || expected
		"II"		| "II"		 || "IV"
		"II"		| "III"		 || "V"
		"V"			| "I"		 || "VI"
		"V"			| "IV"		 || "IX"
		"V"			| "V"		 || "X"
		"X"			| "I"		 || "XI"
		"XXV"		| "XXV"		 || "L"
		"L"			| "I"		 || "LI"
		"L"			| "L"		 || "C"
		"L"			| "LI"		 || "CI"
		"CCL"		| "CCL"		 || "D"
		"CCL"		| "CCLI"	 || "DI"
		"D"			| "D"		 || "M"
		"D"			| "DI"	 	 || "MI"
	}

	@Test
	@Unroll
	def'when valid inputs #numericOne and #numericTwo are passed as Strings #expected is returned'() {

		given:
		theOperationContext.setOperation(theOperation)

		when: 'when two roman numericals are passed as Strings'
		def result = theOperationContext.performOperation(numericOne,numericTwo)

		then: 'the sum of both numericals is returned in roman numerical form'
		expected == result

		where:
		numericOne	| numericTwo || expected
		"D"			| "D"		 || "M"
		"CD"		| "D"		 || "CM"
		"CCL"		| "CCL"		 || "D"
		"CC"		| "CC"		 || "CD"
		"L"			| "L"		 || "C"
		"L"			| "XL"		 || "XC"
		"XXV"		| "XXV"		 || "L"
		"XX"		| "XX"		 || "XL"
		"V"			| "V"		 || "X"
		"V"			| "IV"		 || "IX"
		"IV"		| "I"		 || "V"
		"II"		| "II"		 || "IV"
		"I"			| "I"		 || "II"
		"XX"		| "II"		 || "XXII"
		"I"			| "II"		 || "III"
		"I"			| "III"		 || "IV"
		"II"		| "III"		 || "V"
		"III"		| "III"		 || "VI"
	}
}
