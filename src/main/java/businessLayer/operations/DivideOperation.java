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

import domainLayer.CalculationResult;

public class DivideOperation extends RomanNumericalCalculator {

	@Override
	public boolean preCalculationValidation(final int num1, final int num2) {
		if(num1 > num2){
			throw new IllegalArgumentException("division error : numeral 1 is greater than numeral 2.");
		}
		return true;	
	}

	@Override	
	public CalculationResult calculate(final int num1, final int num2) {
		preCalculationValidation(num1, num2);
		return converter.toRomanNumeral(num1 / num2);		
	}
	
}
	