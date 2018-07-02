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

import businessLayer.api.Calculator;
import domainLayer.CalculationResult;

@Component
public class OperationContext {
	
	@Autowired
	Calculator operation;	
			
	public OperationContext(final Calculator anOperation){
	    this.operation = anOperation;
	}	
	
	public Calculator getOperation() {
		return operation;
	}	

	public void setOperation(final Calculator operation) {
		this.operation = operation;
	}

	public String executeOperation(final String num1, final String num2) {
		return operation.doCalculation(num1, num2);
	}
}
