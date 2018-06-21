package domainLayer;

import org.springframework.stereotype.Component;

@Component
public class CalculationResult {
	
	String theResult;

	public String getTheResult() {
		return theResult;
	}

	public void setTheResult(String theResult) {
		this.theResult = theResult;
	}     
	
}
