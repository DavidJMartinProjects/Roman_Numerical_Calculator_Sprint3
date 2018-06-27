package domainLayer

import static org.junit.Assert.assertEquals

import org.junit.Before
import org.mockito.internal.matchers.InstanceOf

import spock.lang.Specification

class CalculationResultTest extends Specification {

	def testValue = "XIV";

	def 'when a new CalculationResult object is created the getters should return the expected data and be of the type String'() {

		given : 'that a new CalculationResult object is created'
		CalculationResult calculationResult = new CalculationResult();

		when : 'theResult varable is explicitly set'
		calculationResult.setTheResult(testValue)

		then : 'the expected value should be returned when the theResult getter is called'
		assertEquals(testValue, calculationResult.getTheResult())
		assert calculationResult.getTheResult() instanceof String
	}
} 
