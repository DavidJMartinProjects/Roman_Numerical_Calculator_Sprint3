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
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import businessLayer.api.RomanNumericalCalculator;

@Primary
@Component
public class AddOperation extends RomanNumericalCalculator {

	@Override
	public boolean preCalculationValidation(final int num1, final int num2) {		
		if((num1+num2) > 3999){
			throw new ArithmeticException("addition error : result is greater than 3999.");
		}
		return true;	
	}

	@Override
	public String calculate(final int num1, final int num2) {
		return converter.toRomanNumeral(num1 + num2);		
	}

	@Override
	public boolean supports(String s) {
		return "+".equals(s);		
	}

}

		