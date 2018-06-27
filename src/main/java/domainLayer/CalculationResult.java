package domainLayer;

import org.springframework.stereotype.Component;

@Component
public class CalculationResult {

	private String theResult;

	public String getTheResult() {
		return theResult;
	}

	public void setTheResult(final String theResult) {
		this.theResult = theResult;
	}

	@Override
	public String toString() {
		return theResult ;
	}
	
} 
  