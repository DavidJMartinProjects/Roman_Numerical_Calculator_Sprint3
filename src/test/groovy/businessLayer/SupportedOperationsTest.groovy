package businessLayer;

import static org.junit.Assert.assertEquals

import org.junit.Test

import businessLayer.calculations.Subtraction
import businessLayer.calculations.SupportedCalculation
import spock.lang.Specification

class SupportedOperationsTest extends Specification {
		
	@Test
	def 'the getSupportedOperations method returns the expected results'() {		
		when : 'when two inputs are passed to the preCalculationValidation method'
		def result = SupportedCalculation.getSupportedOperations();
		then : 'the expected result is returned'
		assertEquals("+-/*%", result)
	}
	
}