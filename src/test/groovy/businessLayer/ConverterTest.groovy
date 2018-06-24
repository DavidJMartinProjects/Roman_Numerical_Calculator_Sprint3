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

import org.junit.Test

import domainLayer.CalculationResult
import domainLayer.RomanNumerics
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author eaamrvd
 *
 */
class ConverterTest extends Specification {

	def input, expected
	def calculationResult = new CalculationResult()
	def romanNumerics = Mock(RomanNumerics.class)
	def theConverter= new Converter(romanNumerics:romanNumerics, calculationResult:calculationResult);

	@Test
	@Unroll
	def 'test that the toBaseTen method returns the expected result when passed a roman numerical string'() {
		given:
		romanNumerics.getRomanNumerics() >> new RomanNumerics().getRomanNumerics();

		when: 'when the toBaseTen method is called'
		def result = theConverter.toBaseTen(input);

		then: 'the expected base10 value of the Roman numeral is returned'
		expected == result

		where:
		input	 || expected
		"M"		 || 1000
		"CM"	 || 900
		"D"		 || 500
		"CD"	 || 400
		"C"		 || 100
		"XC"	 || 90
		"L"		 || 50
		"XL"	 || 40
		"X"		 || 10
		"IX"	 || 9
		"V"		 || 5
		"IV"	 || 4
		"I"		 || 1
	}

	@Test
	@Unroll
	def 'test that the toRomanNumeral method returns the expected result when passed an integer value'() {
		given:
		romanNumerics.getRomanNumerics() >> new RomanNumerics().getRomanNumerics();

		when: 'when the toRomanNumeral method is called'
		def result = theConverter.toRomanNumeral(input);

		then: 'the expected roman numeral representation of the integer value is returned'
		expected == result.theResult

		where:
		input   ||expected
		1000 	||  "M"
		900		||  "CM"
		500		||  "D"
		400		||  "CD"
		100		||  "C"
		90		||  "XC"
		50		||  "L"
		40		||  "XL"
		10		||  "X"
		9		||  "IX"
		5		||  "V"
		4		||  "IV"
		1		||  "I"
	}
}
