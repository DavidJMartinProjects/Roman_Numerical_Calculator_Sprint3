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
package utils


import org.hibernate.validator.internal.metadata.aggregated.ValidatableParametersMetaData
import org.junit.Test
import spock.lang.Specification
import spock.lang.Unroll
import utils.Validator

class ValidatorTest extends Specification  {
 
	def input
	def theValidator = new Validator();

	@Test
	@Unroll
	def 'verify that the expected validation result of #expected is returned when the valid Roman numeral #input is passed to the validateInput method'() {

		when: 'the validateInput method is called with a valid argument'
		def result = theValidator.validateRomanNumeral(input);

		then: 'verify that the validation passes and that no exception is thrown'
		noExceptionThrown()

		where:
		input	| _
		"M"		| _
		"CM"	| _
		"D"		| _
		"CD"	| _
		"C"		| _
		"XC"	| _
		"L"		| _
		"XL"	| _
		"X"		| _
		"IX"	| _
		"V"		| _
		"IV"	| _
		"I"		| _
	}

	@Test
	@Unroll
	def 'verify that the expected validation result of #expected is returned when the invalid Roman numeral #input is passed to the validateInput method'() {

		when: 'the validateInput method is called with an invalid argument'
		def result = theValidator.validateRomanNumeral(input);

		then: 'verify that the expected validation result is returned'
		ArithmeticException exception = thrown()
		exception.message == expected

		where:
		input	 || expected
		"IIII"	 || "<b>error :</b> invalid roman numerical entered"
		"XXXX"	 || "<b>error :</b> invalid roman numerical entered"
		"CCCC"	 || "<b>error :</b> invalid roman numerical entered"
		"VV"	 || "<b>error :</b> invalid roman numerical entered"
		"VVV"	 || "<b>error :</b> invalid roman numerical entered"
		"VVVV"	 || "<b>error :</b> invalid roman numerical entered"
		"LL"	 || "<b>error :</b> invalid roman numerical entered"
		"LLL"	 || "<b>error :</b> invalid roman numerical entered"
		"LLLL"	 || "<b>error :</b> invalid roman numerical entered"
		"DD"	 || "<b>error :</b> invalid roman numerical entered"
		"DDD"	 || "<b>error :</b> invalid roman numerical entered"
		"DDDD"	 || "<b>error :</b> invalid roman numerical entered"
		"MMMM"	 || "<b>error :</b> invalid roman numerical entered"
	}
}
