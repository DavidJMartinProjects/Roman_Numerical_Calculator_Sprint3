package domainLayer

import java.util.LinkedHashMap
import org.junit.Before
import spock.lang.Specification

class RomanNumericsTest extends Specification {

	private LinkedHashMap<Integer,String> expectedMap;

	def setup() {
		expectedMap = new LinkedHashMap<Integer,String>();
		expectedMap.put(1000, "M");
		expectedMap.put(900, "CM");
		expectedMap.put(500, "D");
		expectedMap.put(400, "CD");
		expectedMap.put(100, "C");
		expectedMap.put(90, "XC");
		expectedMap.put(50, "L");
		expectedMap.put(40, "XL");
		expectedMap.put(10, "X");
		expectedMap.put(9, "IX");
		expectedMap.put(5, "V");
		expectedMap.put(4, "IV");
		expectedMap.put(1, "I");
	}

	def 'when a new RomanNumerics object is created the getter should return the expected object and be of type LinkedHashMap'() {

		when : 'a new CalculationResult object is created'
		RomanNumerics romanNumerics = new RomanNumerics();

		then : 'the object should return a LinkedHashMap with the expected values'
		romanNumerics.getRomanNumerics() == expectedMap
		romanNumerics.getRomanNumerics().size() == expectedMap.size()
		romanNumerics.getRomanNumerics() instanceof LinkedHashMap
	}
}
