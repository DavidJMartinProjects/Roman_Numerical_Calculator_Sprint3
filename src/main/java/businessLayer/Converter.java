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

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import domainLayer.CalculationResult;

@Component
public class Converter {

	CalculationResult calculationResult = new CalculationResult();
	
	private final Map<Integer, String> romanNumerics = new LinkedHashMap<Integer, String>();
	
	public Converter() {
		romanNumerics.put(1000, "M");
		romanNumerics.put(900, "CM");
		romanNumerics.put(500, "D");
		romanNumerics.put(400, "CD");
		romanNumerics.put(100, "C");
		romanNumerics.put(90, "XC");
		romanNumerics.put(50, "L");
		romanNumerics.put(40, "XL");
		romanNumerics.put(10, "X");
		romanNumerics.put(9, "IX");
		romanNumerics.put(5, "V");
		romanNumerics.put(4, "IV");
		romanNumerics.put(1, "I");
	}

	public int toBaseTen(final String input) {

		for (final Map.Entry<Integer, String> entry : romanNumerics.entrySet()) {
			if (input.startsWith(entry.getValue())) {
				return entry.getKey() + toBaseTen(input.replaceFirst(entry.getValue(), ""));
			}
		}
		return 0;
	}

	public CalculationResult toRomanNumeral(int input) {
		String result = "";
		for (final Map.Entry<Integer, String> entry : romanNumerics.entrySet()) {
			while (input >= entry.getKey()) {
				result += entry.getValue();
				input -= entry.getKey();
			}
		}
		calculationResult.setTheResult(result);
		return calculationResult;
	}

} 
  