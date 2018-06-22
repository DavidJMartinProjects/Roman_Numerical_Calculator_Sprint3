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

import org.junit.Test

import domainLayer.CalculationResult
import domainLayer.RomanNumerics
import groovy.json.*;
import spock.lang.Specification
import spock.lang.Unroll

class ConverterControllerTest extends Specification {
	
	def theRomanNumerics= Mock(RomanNumerics);
	def theCalculationResult = Mock(CalculationResult);
	def theConverter = Mock(Converter)	
	def theConverterController = new ConverterController(converter:theConverter);
	
	@Test
	@Unroll
	def'when #numericOne and #numericTwo are passed as Strings #expected is returned as a String'() {
				
		given:
		theConverter.toRomanNumeral(_) >> new CalculationResult(theResult:expected)
		
		when: 'when two roman numericals are passed as Strings'
		def result = theConverterController.performConversion(numericOne, numericTwo);

		then: ' sum of both numericals is returned in roman numerical form as a String'
		assertEquals(expected, result.theResult)

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
