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


import org.hibernate.validator.internal.metadata.aggregated.ValidatableParametersMetaData
import org.junit.Test
import spock.lang.Specification
import spock.lang.Unroll
import utils.Validator

class ValidatorTest extends Specification  {
 
	def theValidator = new Validator();

	@Test
	@Unroll
	def 'verify that the expected validation result of #expected is returned when the valid Roman numeral #input is passed to the validateInput method'() {

		when: 'the validateInput method is called with a valid argument'
		def result = theValidator.validateRomanNumeral(input);

		then: 'verify that the expected validation result is returned'
		result == expected

		where:
		input	 || expected
		"M"		 || true
		"CM"	 || true
		"D"		 || true
		"CD"	 || true
		"C"		 || true
		"XC"	 || true
		"L"		 || true
		"XL"	 || true
		"X"		 || true
		"IX"	 || true
		"V"		 || true
		"IV"	 || true
		"I"		 || true
	}

	@Test
	@Unroll
	def 'verify that the expected validation result of #expected is returned when the invalid Roman numeral #input is passed to the validateInput method'() {

		when: 'the validateInput method is called with an invalid argument'
		def result = theValidator.validateRomanNumeral(input);

		then: 'verify that the expected validation result is returned'
		IllegalArgumentException exception = thrown()
		exception.message == expected

		where:
		input	 || expected
		"IIII"	 || "error : invalid roman rumerical entered"
		"XXXX"	 || "error : invalid roman rumerical entered"
		"CCCC"	 || "error : invalid roman rumerical entered"
		"VV"	 || "error : invalid roman rumerical entered"
		"VVV"	 || "error : invalid roman rumerical entered"
		"VVVV"	 || "error : invalid roman rumerical entered"
		"LL"	 || "error : invalid roman rumerical entered"
		"LLL"	 || "error : invalid roman rumerical entered"
		"LLLL"	 || "error : invalid roman rumerical entered"
		"DD"	 || "error : invalid roman rumerical entered"
		"DDD"	 || "error : invalid roman rumerical entered"
		"DDDD"	 || "error : invalid roman rumerical entered"
		"MMMM"	 || "error : invalid roman rumerical entered"
	}
}
