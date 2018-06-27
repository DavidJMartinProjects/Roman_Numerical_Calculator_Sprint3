package webLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import businessLayer.ConverterController;
import businessLayer.IOperation;
import businessLayer.OperationContext;
import businessLayer.OperationFactory;
import businessLayer.Validator;
import domainLayer.CalculationResult;

@RestController
@RequestMapping(value = "/calc")
public class CalculatorWS {

	@Autowired
	ConverterController converterController;
	
	@Autowired
	CalculationResult result;
	
	@Autowired
	OperationFactory operationFactory;
	
	@Autowired
	Validator validator;
	
	@Autowired
	OperationContext context;

	@RequestMapping(value = "/status", method = RequestMethod.GET, produces = { "application/json" })
	public String greeting() {
		return "status : webService online";
	}

	@RequestMapping(value = "/addition", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<Object> calculate(@RequestParam("num1") final String num1, @RequestParam("num2") final String num2, 
			@RequestParam("operationType") final String operationType) {
		try {			
			context.setOperation(operationFactory.getOperation(operationType));
			result = context.executeOperation(num1, num2);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (IllegalArgumentException ex) {
			return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
