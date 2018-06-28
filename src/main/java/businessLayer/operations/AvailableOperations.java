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

import org.springframework.stereotype.Component;

@Component
public enum AvailableOperations {

	PLUS("+"), MINUS("-"), DIVIDE("/"), MULTIPLY("*");

	private String symbol;

	AvailableOperations(String aSymbol) {
		this.symbol = aSymbol;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String[] getAvailableOperations() {
		String[] operations = new String[values().length];
		int index = 0;

		for (AvailableOperations state : values()) {
			operations[index++] = state.name();
		}

		return operations;
	}

}
