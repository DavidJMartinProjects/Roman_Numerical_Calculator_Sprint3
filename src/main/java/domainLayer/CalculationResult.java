package domainLayer;

import org.springframework.stereotype.Component;

/**
 * The Class CalculationResult.
 */
@Component
public class CalculationResult {

	/** The result. */
	private String theResult;

	/**
	 * Gets theResult.
	 *
	 * @return theResult
	 */
	public String getTheResult() {
		return theResult;
	}

	/**
	 * Sets theResult.
	 *
	 * @param theResult
	 *            the new result value
	 */
	public void setTheResult(final String theResult) {
		this.theResult = theResult;
	}

	@Override
	public String toString() {
		return theResult;
	}

}
