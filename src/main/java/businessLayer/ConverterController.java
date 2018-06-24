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
package businessLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import domainLayer.CalculationResult;

/**
 * The Class ConverterController.
 */
@Component
public class ConverterController {

	@Autowired
	Validator validator;

	/** The converter. */
	@Autowired
	Converter converter;

	/**
	 * Perform conversion.
	 *
	 * @param input1
	 *            : Roman numerical one
	 * @param input2
	 *            : Roman numerical two
	 * @return the sum of both inputs in roman numeral form
	 */
	public CalculationResult performConversion(final String input1, final String input2) {
		if (validate(input1, input2)) {
			final int num1 = converter.toBaseTen(input1);
			final int num2 = converter.toBaseTen(input2);
			return converter.toRomanNumeral(num1 + num2);
		} else {
			throw new IllegalArgumentException("Invalid Roman Numeral Entered.");
		}

	}

	public boolean validate(final String input1, final String input2) {
		return (validator.validateInput(input1) && validator.validateInput(input2));
	}

}
