package business.calculations;

import static org.junit.Assert.assertEquals

import org.junit.Test

import business.calculations.Addition
import business.calculations.Division
import business.calculations.Modulus
import business.calculations.Multiplication
import business.calculations.Subtraction
import spock.lang.Specification

class ModulusTest extends Specification {
	def input1, input2, expected
	def Modulus theModulusOperation
	
	@Test
	def 'the preCalculationValidation method returns the expected result when called with two valid inputs'() {
		given : 'the calculation is a SubtractOperation'
		theModulusOperation = new Modulus();
		
		when : 'when two inputs are passed to the preCalculationValidation method'
		def result = theModulusOperation.preCalculationValidation(input1, input2)
		
		then : 'the expected result is returned'
		assertEquals(expected, result)
		noExceptionThrown()
		
		where :
		input1	| input2 
		 60		| 14	 
	}
	
	@Test
	def 'the preCalculationValidation method returns the expected exception message when called with invalid inputs'() {
		given : 'the calculation is a SubtractOperation'
		theModulusOperation = new Modulus();
		
		when : 'when two inputs are passed to the preCalculationValidation method'
		def result = theModulusOperation.preCalculationValidation(input1, input2)
		
		then : 'the expected exception message is returned'
		ArithmeticException exception = thrown()
		exception.message == expected

		where:
		input1	| input2 || expected
		14		| 60 	 || "modulus error : numeral 1 is greater than numeral 2"
		5		| 5 	 || "modulus error : result was zero."
	}
	
	@Test
	def 'the calculate method returns the expected result when called with valid inputs'() {
		given : 'the calculation is a SubtractOperation'
		theModulusOperation = new Modulus();
		
		when : 'when two inputs are passed to the preCalculationValidation method'
		def result = theModulusOperation.calculate(input1, input2)
		
		then : 'the expected result is returned'
		assertEquals(expected, result)

		where:
		input1	| input2 || expected
		60		| 14 	 || "IV"
	}
	
}