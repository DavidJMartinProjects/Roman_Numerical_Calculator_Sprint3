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

@Component
public class Converter {		
	
	@Autowired
	static final Map<Integer, String> ROMAN_NUMERICS = new LinkedHashMap<>();
	
	public Converter() { 
		ROMAN_NUMERICS.put(1000, "M");
		ROMAN_NUMERICS.put(900, "CM");
		ROMAN_NUMERICS.put(500, "D");
		ROMAN_NUMERICS.put(400, "CD");	
		ROMAN_NUMERICS.put(100, "C");
		ROMAN_NUMERICS.put(90, "XC");
		ROMAN_NUMERICS.put(50, "L");
		ROMAN_NUMERICS.put(40, "XL");
		ROMAN_NUMERICS.put(10, "X");	
		ROMAN_NUMERICS.put(9, "IX");
		ROMAN_NUMERICS.put(5, "V");
		ROMAN_NUMERICS.put(4, "IV");
		ROMAN_NUMERICS.put(1, "I");
	}

	public int toBaseTen(final String input) {
		for (final Map.Entry<Integer, String> entry : ROMAN_NUMERICS.entrySet()) {
			if (input.startsWith(entry.getValue())) {
				return entry.getKey() + toBaseTen(input.replaceFirst(entry.getValue(), ""));
			}
		}
		return 0;
	}

	public String toRomanNumeral(int input) {
		final  StringBuilder result = new StringBuilder();
		for (final Map.Entry<Integer, String> entry : ROMAN_NUMERICS.entrySet()) {
			while (input >= entry.getKey()) {
				result.append(entry.getValue());
				input -= entry.getKey();
			}
		}
		return result.toString();
	}

} 
  