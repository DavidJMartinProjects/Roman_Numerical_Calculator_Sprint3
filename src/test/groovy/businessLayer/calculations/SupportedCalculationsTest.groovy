package businessLayer.calculations;

import static org.junit.Assert.assertEquals

import org.junit.Test

import businessLayer.calculations.Addition
import businessLayer.calculations.Division
import businessLayer.calculations.Multiplication
import businessLayer.calculations.Subtraction
import businessLayer.calculations.SupportedCalculations
import spock.lang.Specification

class SupportedCalculationsTest extends Specification {
		
	@Test
	def 'verify that the getSupportedOperations method returns the expected results'() {		
		when : 'when two inputs are passed to the preCalculationValidation method'
		def result = SupportedCalculations.getSupportedOperations();
		then : 'the expected result is returned'
		assertEquals("+-/*%", result)
	}
	
}