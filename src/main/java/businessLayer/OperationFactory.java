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

import org.springframework.stereotype.Component;

import businessLayer.api.CalculatorStrategy;
import businessLayer.operations.OperationAdd;
import businessLayer.operations.OperationDivide;
import businessLayer.operations.OperationMultiply;
import businessLayer.operations.OperationSubtract;

@Component	
public class OperationFactory { 

	public CalculatorStrategy getOperation(String operationType) {
		if(operationType.equals("add")) {
			return new OperationAdd();
		}		
		else if(operationType.equals("subtract")) {
			return new OperationSubtract();		
		} else if(operationType.equals("divide")) {
			return new OperationDivide();
		} else if(operationType.equals("multiply")) {
			return new OperationMultiply();
		} 
		return null;
	}
	
}
