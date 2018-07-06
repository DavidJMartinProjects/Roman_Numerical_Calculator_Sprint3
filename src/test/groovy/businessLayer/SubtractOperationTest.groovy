package businessLayer;

import businessLayer.operations.SubtractOperation

import static org.junit.Assert.assertEquals

import org.junit.Test
import spock.lang.Specification

class SubtractOperationTest extends Specification {
	def input1, input2, expected
	def SubtractOperation theSubtractOperation
	
	@Test
	def 'the preCalculationValidation method returns the expected result when called with two valid inputs'() {
		given : 'the calculation is a SubtractOperation'
		theSubtractOperation = new SubtractOperation();
		when : 'when two inputs are passed to the preCalculationValidation method'
		def result = theSubtractOperation.preCalculationValidation(input1, input2)
		then : 'the expected result is returned'
		assertEquals(expected, result)
		noExceptionThrown()
		where :
		
		input1	| input2 | _
		 60		| 14	 | _
	}
	
	@Test
	def 'the preCalculationValidation method returns the expected exception message when called with invalid inputs'() {
		given : 'the calculation is a SubtractOperation'
		theSubtractOperation = new SubtractOperation();
		when : 'when two inputs are passed to the preCalculationValidation method'
		def result = theSubtractOperation.preCalculationValidation(input1, input2)
		then : 'the expected exception message is returned'
		ArithmeticException exception = thrown()
		exception.message == expected

		where:
		input1	| input2 || expected
		14		| 60 	 || "<b>subtraction error :</b> numeral 1 is greater than numeral 2"
		5		| 5 	 || "<b>subtraction error :</b> result was zero."
	}
	
	@Test
	def 'the calculate method returns the expected result when called with valid inputs'() {
		given : 'the calculation is a SubtractOperation'
		theSubtractOperation = new SubtractOperation();
		when : 'when two inputs are passed to the preCalculationValidation method'
		def result = theSubtractOperation.calculate(input1, input2)
		then : 'the expected result is returned'
		assertEquals(expected, result)

		where:
		input1	| input2 || expected
		60		| 14 	 || "XLVI"
	}
	
}