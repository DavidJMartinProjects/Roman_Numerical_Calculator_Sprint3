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
 * @author eaamrvd
 *
 */
@Component
public class ConverterController {
    
	@Autowired
	public Converter converter;

	public CalculationResult performConversion(String input1, String input2) {
		int num1, num2;
		num1 = converter.toBaseTen(input1);
		num2 = converter.toBaseTen(input2);
		return converter.toRomanNumeral(num1 + num2);
	}

}
