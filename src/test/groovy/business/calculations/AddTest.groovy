package business.calculations;

import static org.junit.Assert.assertEquals

import org.junit.Test

import business.calculations.Addition
import business.calculations.Division
import business.calculations.Multiplication
import business.calculations.Subtraction
import spock.lang.Specification

class AddTest extends Specification {
	def input1, input2, expected
	def Addition theAddOperation
	
	@Test
	def 'the preCalculationValidation method returns the expected result when called with two valid inputs'() {
		given : 'the calculation is a AddOperation'
		theAddOperation = new Addition();
		
		when : 'when two inputs are passed to the preCalculationValidation method'
		def result = theAddOperation.preCalculationValidation(input1, input2)
		
		then : 'the expected result is returned'
		assertEquals(expected, result)
		noExceptionThrown()
		
		where :		
		input1	| input2 
		 60		| 14	 
	}
	
	@Test
	def 'the preCalculationValidation method returns the expected exception message when called with invalid inputs'() {
		given : 'the calculation is a AddOperation'
		theAddOperation = new Addition();
		
		when : 'when two inputs are passed to the preCalculationValidation method'
		def result = theAddOperation.preCalculationValidation(input1, input2)
		
		then : 'the expected exception message is returned'
		ArithmeticException exception = thrown()
		exception.message == expected

		where:
		input1	| input2 || expected
		3999	| 1 	 || "addition error : result is greater than 3999."
	}
	
	@Test
	def 'the calculate method returns the expected result when called with valid inputs'() {
		given : 'the calculation is a AddOperation'
		theAddOperation = new Addition();
		
		when : 'when two inputs are passed to the preCalculationValidation method'
		def result = theAddOperation.calculate(input1, input2)
		
		then : 'the expected result is returned'
		assertEquals(expected, result)

		where:
		input1	| input2 || expected
		60		| 14 	 || "LXXIV"
	}
	
}