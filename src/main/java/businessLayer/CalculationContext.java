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

@Component
public class CalculationContext {
	
	@Autowired
	Calculator calculation;	
			
	public CalculationContext(final Calculator anOperation){
	    this.calculation = anOperation;
	}	
	
	public Calculator getCalculation() {
		return calculation;
	}	

	public void setCalculation(final Calculator operation) {
		this.calculation = operation;	
	}

	public String getCalculationResult(final String num1, final String num2) {
		return calculation.doCalculation(num1, num2);
	}
	 
}
