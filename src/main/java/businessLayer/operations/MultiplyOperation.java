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

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import businessLayer.api.RomanNumericalCalculator;
@Component
public class MultiplyOperation extends RomanNumericalCalculator {

	@Override
	public boolean preCalculationValidation(final int num1, final int num2) {	
		if((num1*num2) > 3999){
			throw new ArithmeticException("multiplication error : result is greater than 3999.");
		}
		return true;	
	}

	@Override	
	public String calculate(final int num1, final int num2	) {
		return converter.toRomanNumeral(num1 * num2);		
	}

	/* (non-Javadoc)
	 * @see businessLayer.api.Calculation#supports(java.lang.String)
	 */
	@Override
	public boolean supports(String s) {
		return "*".equals(s);
	}
	
}
	