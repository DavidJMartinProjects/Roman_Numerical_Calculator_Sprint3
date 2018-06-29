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

import businessLayer.api.Calculator;
import businessLayer.operations.OperationAdd;
import businessLayer.operations.OperationDivide;
import businessLayer.operations.OperationMultiply;
import businessLayer.operations.OperationSubtract;

@Component	
public class OperationFactory { 

	public Calculator getOperation(final String operationType) {
		if("add".equals(operationType)) {
			return new OperationAdd();
		} else if("subtract".equals(operationType)) {
			return new OperationSubtract();		
		} else if("divide".equals(operationType)) {
			return new OperationDivide();
		} else if("multiply".equals(operationType)) {
			return new OperationMultiply();
		} 
		return null;
	}
	
}
