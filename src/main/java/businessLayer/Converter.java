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

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domainLayer.CalculationResult;
import domainLayer.RomanNumerics;

/**
 * @author eaamrvd
 *
 */
@Service
public class Converter {

    @Autowired
    RomanNumerics romanNumerics;
	
	@Autowired
	CalculationResult calculationResult;
	
	public int toBaseTen(String input) { // Change to Stringbuilder

		for (Map.Entry<Integer, String> entry : romanNumerics.getRomanNumerics().entrySet()) {
			if(input.startsWith(entry.getValue())) {
				return entry.getKey()
					+ toBaseTen(input.replaceFirst(entry.getValue(), ""));
			}
		}
		return 0;
	}

	public CalculationResult toRomanNumeral(int input) {		
		String roman = "";
		for (Map.Entry<Integer, String> entry : romanNumerics.getRomanNumerics().entrySet()) {
			while (input >= entry.getKey()) {
				roman += entry.getValue();
				input -= entry.getKey();
			}
		}
		calculationResult.setTheResult(roman);
		return calculationResult;
	}

}
