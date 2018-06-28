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

//	def expected, numericOne, numericTwo
//	def theRomanNumerics= Mock(RomanNumerics);
//	def theCalculationResult = Mock(CalculationResult);
//	def theConverter = Mock(Converter)
//	def theValidator = Mock(Validator)
//	def theConverterController = new ConverterController(converter:theConverter, validator:theValidator);
// 
//	@Test
//	@Unroll
//	def 'verify that if the numeral is I X or C you cannot have more than three in succession'() {
//		given:
//		theValidator.validateInput(_) >> true
//		theConverter.toRomanNumeral(_) >> new CalculationResult(theResult:expected)
//
//		when: 'when two roman numericals are passed as Strings'
//		def result = theConverterController.performConversion(numericOne, numericTwo);
//
//		then: 'if the numeral is I, X or C, you cannot have more than three in succession'
//		expected == result.theResult
//
//		where:
//		numericOne	| numericTwo || expected
//		"I"			| "III"		 || "IV"
//		"II"		| "II"		 || "IV"
//		"X	"		| "XXX"		 || "XL"
//		"XX"		| "XX"		 || "XL"
//		"C"			| "CCC"		 || "CD"
//		"CC"		| "CC"		 || "CD"
//	}
//
//	@Test
//	@Unroll
//	def 'verify that if the numeral is V L or D you cannot have more that one in succession'() {
//		given:
//		theValidator.validateInput(_) >> true
//		theConverter.toRomanNumeral(_) >> new CalculationResult(theResult:expected)
//
//		when: 'when two roman numericals are passed as Strings'
//		def result = theConverterController.performConversion(numericOne, numericTwo);
//
//		then: 'if the numeral is I, X or C, you cannot have more that one in succession'
//		expected == result.theResult
//
//		where:
//		numericOne	| numericTwo || expected
//		"V"			| "V"		 || "X"
//		"L"			| "L"		 || "C"
//		"D"			| "D"		 || "M"
//	}
//
//	@Test
//	@Unroll
//	def 'verify that calculations around roman single numeral boundaries are behaving as expected'() {
//		given:
//		theValidator.validateInput(_) >> true
//		theConverter.toRomanNumeral(_) >> new CalculationResult(theResult:expected)
//
//		when: 'when two roman numericals are passed as Strings'
//		def result = theConverterController.performConversion(numericOne, numericTwo);
//
//		then: 'verify that calculations around roman numeral boundaries are behaving as expected'
//		expected == result.theResult
//
//		where:
//		numericOne	| numericTwo || expected
//		"II"		| "II"		 || "IV"
//		"II"		| "III"		 || "V"
//		"V"			| "I"		 || "VI"
//		"V"			| "IV"		 || "IX"
//		"V"			| "V"		 || "X"
//		"X"			| "I"		 || "XI"
//		"XX"		| "XXIX"	 || "IL"
//		"XXV"		| "XXV"		 || "L"
//		"L"			| "I"		 || "LI"
//		"L"			| "IL"		 || "IC"
//		"L"			| "L"		 || "C"
//		"L"			| "LI"		 || "CI"
//		"CCL"		| "ICCL"	 || "ID"
//		"CCL"		| "CCL"		 || "D"
//		"CCL"		| "CCLI"	 || "DI"
//		"D"			| "ID"		 || "IM"
//		"D"			| "D"		 || "M"
//		"D"			| "DI"	 	 || "MI"
//	}
//
//	@Test
//	@Unroll
//	def 'verify that the expected method invocations are made when performConversion method is called'() {
//
//		given :
//		theValidator.validateInput(_) >> true
//		theConverter.toRomanNumeral(numericOne) >> new CalculationResult(theResult:expected)
//
//		when: 'when the performConversion method is called'
//		def result = theConverterController.performConversion(numericOne, numericTwo);
//
//		then: 'the toRomanNumeral and toBase10 are invocated the expected number of times'
//		1 * theConverter.toRomanNumeral(_);
//		2 * theConverter.toBaseTen(_);
//
//		where:
//		numericOne	| numericTwo || expected
//		"D"			| "D"		 || "M"
//		"CD"		| "D"		 || "CM"
//		"CCL"		| "CCL"		 || "D"
//		"CC"		| "CC"		 || "CD"
//		"L"			| "L"		 || "C"
//		"L"			| "XL"		 || "XC"
//		"XXV"		| "XXV"		 || "L"
//		"XX"		| "XX"		 || "XL"
//		"V"			| "V"		 || "X"
//		"V"			| "IV"		 || "IX"
//		"IV"		| "I"		 || "V"
//		"II"		| "II"		 || "IV"
//		"I"			| "I"		 || "II"
//		"XX"		| "II"		 || "XXII"
//		"I"			| "II"		 || "III"
//		"I"			| "III"		 || "IV"
//		"II"		| "III"		 || "V"
//		"III"		| "III"		 || "VI"
//	}
//
//	@Test
//	@Unroll
//	def 'test that performConversion throws an illegalArgumentException for calculations greater than 3999'() {
//		given :
//		theConverterController.validator.validateInput("MMMM") >> { throw new IllegalArgumentException("Invalid Roman Numeral Entered.") }
//
//		when: 'when the performConversion method is called'
//		def result = theConverterController.performConversion("MMMM", "MMMM");
//
//		then: 'an IllegalArgumentException is thrown'
//		def ex = thrown(IllegalArgumentException)
//		ex.message == "Invalid Roman Numeral Entered."
//	}
//
//	@Test
//	@Unroll
//	def'when valid inputs #numericOne and #numericTwo are passed as Strings #expected is returned'() {
//
//		given:
//		theValidator.validateInput(_) >> true
//		theConverter.toRomanNumeral(_) >> new CalculationResult(theResult:expected)
//
//		when: 'when two roman numericals are passed as Strings'
//		def result = theConverterController.performConversion(numericOne, numericTwo);
//
//		then: 'the sum of both numericals is returned in roman numerical form'
//		expected == result.theResult
//
//		where:
//		numericOne	| numericTwo || expected
//		"D"			| "D"		 || "M"
//		"CD"		| "D"		 || "CM"
//		"CCL"		| "CCL"		 || "D"
//		"CC"		| "CC"		 || "CD"
//		"L"			| "L"		 || "C"
//		"L"			| "XL"		 || "XC"
//		"XXV"		| "XXV"		 || "L"
//		"XX"		| "XX"		 || "XL"
//		"V"			| "V"		 || "X"
//		"V"			| "IV"		 || "IX"
//		"IV"		| "I"		 || "V"
//		"II"		| "II"		 || "IV"
//		"I"			| "I"		 || "II"
//		"XX"		| "II"		 || "XXII"
//		"I"			| "II"		 || "III"
//		"I"			| "III"		 || "IV"
//		"II"		| "III"		 || "V"
//		"III"		| "III"		 || "VI"
//	}
}
