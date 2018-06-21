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
import org.springframework.stereotype.Service;

import domainLayer.CalculationResult;
import domainLayer.RomanNumerical;

/**
 * @author eaamrvd
 *
 */
@Service
public class Converter {

	@Autowired
	RomanNumerical numericals;     
	
	@Autowired
	CalculationResult calculationResult;

	public int toNumerical(String roman) {
		for (int i = 0; i < numericals.getTheSymbols().length; i++) {
			if (roman.startsWith(numericals.getTheSymbols()[i]))
				return numericals.getTheValues()[i]
						+ toNumerical(roman.replaceFirst(numericals.getTheSymbols()[i], ""));
		}
		return 0;
	}

	public CalculationResult toRoman(int num) {
		String roman = "";
		for (int i = 0; i < numericals.getTheValues().length; i++) {
			while (num >= numericals.getTheValues()[i]) {
				roman += numericals.getTheSymbols()[i];
				num -= numericals.getTheValues()[i];
			}
		}
		calculationResult.setTheResult(roman);
		return calculationResult;
	}

}
