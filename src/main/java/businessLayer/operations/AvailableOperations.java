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

	public static String getAvailableOperations() {
		String operations = "";
		AvailableOperations arr[] = AvailableOperations.values();
		for(AvailableOperations op : arr) {
			if(op != null) {
				operations+= op.getSymbol();
			}
		}
		return operations;
	}	

}
