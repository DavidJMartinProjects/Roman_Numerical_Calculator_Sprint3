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
package domainLayer;

import java.util.LinkedHashMap;

import org.springframework.stereotype.Component;


/**
 * The Class RomanNumerics.
 */
@Component
public class RomanNumerics {
	
	/** LinkedHashMap containing Roman numerics. */
	private LinkedHashMap<Integer,String> romanNumerics=new LinkedHashMap<Integer,String>();  
	
	/**
	 * Instantiates a new RomanNumerics object.
	 */
	public RomanNumerics() {
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

	/**
	 * Gets the romanNumerics collection.
	 *
	 * @return the romanNumerics collection
	 */
	public LinkedHashMap<Integer, String> getRomanNumerics() {
		return romanNumerics;
	}

	/**
	 * Sets the romanNumerics collection.
	 *
	 * @param romanNumerics romanNumerics collection
	 */
	public void setRomanNumerics(LinkedHashMap<Integer, String> romanNumerics) {
		this.romanNumerics = romanNumerics;
	}	
	
}
