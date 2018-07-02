package webLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import businessLayer.OperationContext;
import businessLayer.OperationFactory;
import businessLayer.operations.SupportedOperations;
import businessLayer.OperationContext;
import businessLayer.OperationFactory;

@RestController
@RequestMapping(value = "/calc")
public class CalculatorWS {
	
	@Autowired
	OperationFactory operationFactory;
		
	@Autowired
	OperationContext context;

	@RequestMapping(value = "/status", method = RequestMethod.GET, produces = { "application/json" })
	public String greeting() {
		return "status : webService online";
	}

	@GetMapping
	public ResponseEntity<Object> calculate(@RequestParam("num1") final String num1, @RequestParam("num2") final String num2, 
			@RequestParam("operationType") final String operationType) {	
			context.setOperation(operationFactory.getOperation(operationType));
			String result = context.performOperation(num1, num2);
			return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/operations", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<Object> getSupportedOperations() {		
		return new ResponseEntity<>(SupportedOperations.getSupportedOperations(), HttpStatus.OK);
	}	

}
