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

import org.springframework.stereotype.Component;

import businessLayer.Converter;
import businessLayer.api.CalculatorStrategy;
import domainLayer.CalculationResult;
import utils.Validator;

@Component
public abstract class RomanNumericalCalculator implements CalculatorStrategy {
	
	Converter converter = new Converter();
	Validator validator = new Validator();
	
	@Override
	public CalculationResult doCalculation(String romanNumeral1, String romanNumeral2) {
		System.out.println("inside RomanNumericalCalculator.doCalculation()");
		if(validateRomanNumerals(romanNumeral1, romanNumeral2) && validateOperation(converter.toBaseTen(romanNumeral1), converter.toBaseTen(romanNumeral2))) {
			return calculate(converter.toBaseTen(romanNumeral1), converter.toBaseTen(romanNumeral2));			
		}		
		return null;		
	}
	
	public boolean validateRomanNumerals(final String numeral1, final String numeral2) {
		return (validator.validateRomanNumeral(numeral1) && validator.validateRomanNumeral(numeral2));
	}
	
	public abstract boolean validateOperation(final int numeral1, final int numeral2);
	public abstract CalculationResult calculate(int num1, int num2);
}
