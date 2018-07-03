package businessLayer;

import businessLayer.operations.SubtractOperation
import businessLayer.operations.SupportedOperations

import static org.junit.Assert.assertEquals

import org.junit.Test
import spock.lang.Specification

class SupportedOperationsTest extends Specification {
		
	@Test
	def 'the getSupportedOperations method returns the expected results'() {		
		when : 'when two inputs are passed to the preCalculationValidation method'
		def result = SupportedOperations.getSupportedOperations();
		then : 'the expected result is returned'
		assertEquals("+-/*", result)
	}
	
}