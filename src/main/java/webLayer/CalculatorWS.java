package webLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import businessLayer.ConverterController;
import domainLayer.CalculationResult;

/**
 * The Class CalculatorWS.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/calc")
public class CalculatorWS {
	
	/** The converter controller. */
	@Autowired
	ConverterController converterController;
	
	/**
	 * Greeting.
	 *
	 * @return the web service status
	 */
	@RequestMapping( value="/status", method=RequestMethod.GET, produces={"application/json"})
	public String greeting() {
		return "status : webService online";         		
	}

	/**
	 * Calculate.
	 *
	 * @param num1 : Roman Numerical value as String
	 * @param num2 : Roman Numerical value as String
	 * @return the response entity
	 */
	@RequestMapping(value="/addition", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<Object> calculate(@RequestParam("num1") String num1, @RequestParam("num2") String num2) {
		CalculationResult result = converterController.performConversion(num1, num2);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
                      
}  


