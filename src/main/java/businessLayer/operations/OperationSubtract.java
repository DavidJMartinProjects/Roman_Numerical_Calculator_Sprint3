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
package businessLayer.operations;

import businessLayer.Converter;
import domainLayer.CalculationResult;
import utils.Validator;

public class OperationSubtract  { 		

	Converter converter = new Converter();
	Validator validator = new Validator();	

	public CalculationResult calculate(String numeral1, String numeral2) {
		if (validate(numeral1, numeral2)) {
			final int num1 = converter.toBaseTen(numeral1);
			final int num2 = converter.toBaseTen(numeral2);
			return converter.toRomanNumeral(num1 - num2);
		} else {
			throw new IllegalArgumentException("Invalid Roman Numeral Entered.");
		}
	}

	public boolean validate(final String input1, final String input2) {
		return (validator.validateRomanNumeral(input1) && validator.validateRomanNumeral(input2));
	}

}
