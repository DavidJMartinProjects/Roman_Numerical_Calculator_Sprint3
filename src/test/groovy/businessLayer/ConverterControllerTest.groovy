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
package businessLayer

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.hibernate.validator.internal.metadata.aggregated.ValidatableParametersMetaData
import org.junit.Before
import org.junit.Test

import domainLayer.CalculationResult
import domainLayer.RomanNumerics
import groovy.json.*;
import spock.lang.Specification
import spock.lang.Unroll

class ConverterControllerTest extends Specification {

	def expected, numericOne, numericTwo
	def theRomanNumerics= Mock(RomanNumerics);
	def theCalculationResult = Mock(CalculationResult);
	def theConverter = Mock(Converter)
	def theValidator = Mock(Validator)
	def theConverterController = new ConverterController(converter:theConverter, validator:theValidator);

	@Test
	@Unroll
	def'when #numericOne and #numericTwo are passed as Strings #expected is returned as a String'() {

		given:
		theValidator.validateInput(_) >> true
		theConverter.toRomanNumeral(_) >> new CalculationResult(theResult:expected)

		when: 'when two roman numericals are passed as Strings'
		def result = theConverterController.performConversion(numericOne, numericTwo);

		then: ' sum of both numericals is returned in roman numerical form as a String'
		expected == result.theResult

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
	}

	@Test
	def 'verifying expected method invocations when performConversion method is called'() {

		given :
		theValidator.validateInput(_) >> true
		theConverter.toRomanNumeral(numericOne) >> new CalculationResult(theResult:expected)

		when: 'when the performConversion method is called'
		def result = theConverterController.performConversion(numericOne, numericTwo);

		then: 'the toRomanNumeral and toBase10 are invocated the expected number of times'
		1 * theConverter.toRomanNumeral(_);
		2 * theConverter.toBaseTen(_);

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
	}
}
