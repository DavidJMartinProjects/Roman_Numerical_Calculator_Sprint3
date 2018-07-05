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

public enum SupportedOperations {

	PLUS("+"), MINUS("-"), DIVIDE("/"), MULTIPLY("*"), MODULUS("%");

	private String symbol;

	SupportedOperations(final String aSymbol) {
		this.symbol = aSymbol;
	}

	public String getSymbol() {
		return symbol;
	}

	public static String getSupportedOperations() {
		StringBuilder operations = new StringBuilder();
		final SupportedOperations[] arr = SupportedOperations.values();
		for (final SupportedOperations op : arr) {
			operations.append(op.getSymbol());
		}
		return operations.toString();
	}

}
