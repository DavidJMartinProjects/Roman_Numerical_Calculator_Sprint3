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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import businessLayer.api.Calculator;

@Component
public class CalculationFactory {

	@Autowired
	final List<Calculator> serviceList;

	@Autowired
	public CalculationFactory(final List<Calculator> serviceList) {
		this.serviceList = serviceList;
	}

	public Calculator getCalculation(final String operation) {   
		try {
        return serviceList
                .stream()
                .filter(calculator -> calculator.supportsCalculation(operation))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
		} catch(IllegalArgumentException ex) {
			throw new ArithmeticException("calculator error : operator type not supported.");
		} 
    }

}
