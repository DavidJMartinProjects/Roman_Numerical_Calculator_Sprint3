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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

/**
 * The Class Validator.
 */
@Component
public class Validator {

	final static String THE_REGEX = "^(M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3}))$";

	/**
	 * Validate Input.
	 *
	 * @param input
	 *            the input
	 * @return true if validation passes, false is validation fails
	 */
	public boolean validateInput(final String input) {
		final Pattern pattern = Pattern.compile(THE_REGEX);
		final Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}
}
