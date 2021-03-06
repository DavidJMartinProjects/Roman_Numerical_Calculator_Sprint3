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
package business.api;

import business.Converter;
import utils.Validator;

public abstract class RomanNumericalCalculator implements Calculator {
	
	protected final Converter converter = new Converter();
	private final Validator validator = new Validator();
	
	@Override
	public String doCalculation(final String romanNumeral1, final String romanNumeral2) {	
		validateRomanNumerals(romanNumeral1, romanNumeral2);
		preCalculationValidation(converter.toBaseTen(romanNumeral1), converter.toBaseTen(romanNumeral2));
		return calculate(converter.toBaseTen(romanNumeral1), converter.toBaseTen(romanNumeral2));			
	}
	
	public void validateRomanNumerals(final String numeral1, final String numeral2) {
		validator.validateRomanNumeral(numeral1);
		validator.validateRomanNumeral(numeral2);
	}
	
	public abstract void preCalculationValidation(final int num1, final int num2);	
	public abstract String calculate(final int num1, final int num2);
} 
 