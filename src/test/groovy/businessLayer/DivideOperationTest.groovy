package businessLayer;

import businessLayer.operations.DivideOperation
import businessLayer.operations.SubtractOperation

import static org.junit.Assert.assertEquals

import org.junit.Test
import spock.lang.Specification

class DivideOperationTest extends Specification {
	def input1, input2, expected
	def DivideOperation theDivideOperation
	
	@Test
	def 'the preCalculationValidation method returns the expected result when called with two valid inputs'() {
		given : 'the calculation is a DivideOperation'
		theDivideOperation = new DivideOperation();
		when : 'when two inputs are passed to the preCalculationValidation method'
		def result = theDivideOperation.preCalculationValidation(input1, input2)
		then : 'the expected result is returned'
		assertEquals(expected, result)
		noExceptionThrown()
		where :
		
		input1	| input2 | _
		 40		| 14	 | _
	}
	
	@Test
	def 'the preCalculationValidation method returns the expected exception message when called with invalid inputs'() {
		given : 'the calculation is a DivideOperation'
		theDivideOperation = new DivideOperation();
		when : 'when two inputs are passed to the preCalculationValidation method'
		def result = theDivideOperation.preCalculationValidation(input1, input2)
		then : 'the expected exception message is returned'
		ArithmeticException exception = thrown()
		exception.message == expected

		where:
		input1	| input2 || expected
		14		| 40 	 || "<b>division error :</b> numeral 1 is greater than numeral 2."
	}
	
	@Test
	def 'the calculate method returns the expected result when called with valid inputs'() {
		given : 'the calculation is a DivideOperation'
		theDivideOperation = new DivideOperation();
		when : 'when two inputs are passed to the preCalculationValidation method'
		def result = theDivideOperation.calculate(input1, input2)
		then : 'the expected result is returned'
		assertEquals(expected, result)

		where:
		input1	| input2 || expected
		40		| 14 	 || "II"
	}
	
}