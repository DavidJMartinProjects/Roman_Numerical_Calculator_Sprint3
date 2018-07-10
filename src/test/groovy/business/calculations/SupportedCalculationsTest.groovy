package business.calculations;

import static org.junit.Assert.assertEquals

import org.junit.Test

import business.calculations.Addition
import business.calculations.Division
import business.calculations.Multiplication
import business.calculations.Subtraction
import business.calculations.SupportedCalculations
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