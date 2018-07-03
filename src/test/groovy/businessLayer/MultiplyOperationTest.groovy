package businessLayer;

import businessLayer.operations.DivideOperation
import businessLayer.operations.MultiplyOperation
import businessLayer.operations.SubtractOperation

import static org.junit.Assert.assertEquals

import org.junit.Test
import spock.lang.Specification

class MultiplyOperationTest extends Specification {
	def input1, input2, expected
	def MultiplyOperation theMultiplyOperation
	
	@Test
	def 'the preCalculationValidation method returns the expected result when called with two valid inputs'() {
		given : 'the calculation is a MultiplyOperation'
		theMultiplyOperation = new MultiplyOperation();
		when : 'when two inputs are passed to the preCalculationValidation method'
		def result = theMultiplyOperation.preCalculationValidation(input1, input2)
		then : 'the expected result is returned'
		assertEquals(expected, result)
		where :
		
		input1	| input2 | expected
		 60		| 14	 |	true
	}
	
	@Test
	def 'the preCalculationValidation method returns the expected exception message when called with invalid inputs'() {
		given : 'the calculation is a MultiplyOperation'
		theMultiplyOperation = new MultiplyOperation();
		when : 'when two inputs are passed to the preCalculationValidation method'
		def result = theMultiplyOperation.preCalculationValidation(input1, input2)
		then : 'the expected exception message is returned'
		ArithmeticException exception = thrown()
		exception.message == expected

		where:
		input1	| input2 || expected
		2000	| 3 	 || "multiplication error : result is greater than 3999."
	}
	
	@Test
	def 'the calculate method returns the expected result when called with valid inputs'() {
		given : 'the calculation is a MultiplyOperation'
		theMultiplyOperation = new MultiplyOperation();
		when : 'when two inputs are passed to the preCalculationValidation method'
		def result = theMultiplyOperation.calculate(input1, input2)
		then : 'the expected result is returned'
		assertEquals(expected, result)

		where:
		input1	| input2 || expected
		60		| 14 	 || "DCCCXL"
	}
	
}