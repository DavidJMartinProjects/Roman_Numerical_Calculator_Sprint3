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
package businessLayer.calculations;

import org.springframework.stereotype.Component;

import businessLayer.api.RomanNumericalCalculator;
@Component
public class Subtraction extends RomanNumericalCalculator { 		

	@Override
	public void preCalculationValidation(final int num1, final int num2) {		
		if(num2 > num1) {
			throw new ArithmeticException("<b>subtraction error :</b> numeral 1 is greater than numeral 2");
		} else if((num1-num2) == 0) {
			throw new ArithmeticException("<b>subtraction error :</b> result was zero.");
		}		
	}

	@Override		
	public String calculate(final int num1, final int num2) {	
		return converter.toRomanNumeral(num1 - num2);		
	}
	
	@Override
	public boolean supportsCalculation(final String operator) {	
		return "-".equals(operator);
	}

}
		