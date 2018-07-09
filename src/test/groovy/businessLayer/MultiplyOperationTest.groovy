package businessLayer;

import static org.junit.Assert.assertEquals

import org.junit.Test

import businessLayer.calculations.Division
import businessLayer.calculations.Multiplication
import businessLayer.calculations.Subtraction
import spock.lang.Specification

class MultiplyOperationTest extends Specification {
	def input1, input2, expected
	def Multiplication theMultiplyOperation
	
	@Test
	def 'the preCalculationValidation method returns the expected result when called with two valid inputs'() {
		given : 'the calculation is a MultiplyOperation'
		theMultiplyOperation = new Multiplication();
		when : 'when two inputs are passed to the preCalculationValidation method'
		def result = theMultiplyOperation.preCalculationValidation(input1, input2)
		then : 'the expected result is returned'
		assertEquals(expected, result)
		noExceptionThrown()
		where :
		
		input1	| input2 | _
		 60		| 14	 | _
	}
	
	@Test
	def 'the preCalculationValidation method returns the expected exception message when called with invalid inputs'() {
		given : 'the calculation is a MultiplyOperation'
		theMultiplyOperation = new Multiplication();
		when : 'when two inputs are passed to the preCalculationValidation method'
		def result = theMultiplyOperation.preCalculationValidation(input1, input2)
		then : 'the expected exception message is returned'
		ArithmeticException exception = thrown()
		exception.message == expected

		where:
		input1	| input2 || expected
		2000	| 3 	 || "<b>multiplication error :</b> result is greater than 3999."
	}
	
	@Test
	def 'the calculate method returns the expected result when called with valid inputs'() {
		given : 'the calculation is a MultiplyOperation'
		theMultiplyOperation = new Multiplication();
		when : 'when two inputs are passed to the preCalculationValidation method'
		def result = theMultiplyOperation.calculate(input1, input2)
		then : 'the expected result is returned'
		assertEquals(expected, result)

		where:
		input1	| input2 || expected
		60		| 14 	 || "DCCCXL"
	}
	
}