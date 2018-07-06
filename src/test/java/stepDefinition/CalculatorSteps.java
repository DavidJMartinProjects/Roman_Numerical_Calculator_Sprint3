/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2014
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package stepDefinition;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ultilities.DriverFactory;

public class CalculatorSteps {
	
	private final static String browserType = "chrome";
	private final WebDriver driver = DriverFactory.open(browserType);	

	@Before	
	public void setUp() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Given("^The browser is on the homepage$")
	public void whenGiven() throws Throwable {	
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/");
	}
	
	@When("^The input fields are populated with roman numerals LX and XIV$")
	public void theInputFieldsArePopulated() throws Throwable {		
		driver.findElement(By.id("numOneTf")).click();
		driver.findElement(By.id("numOneTf")).clear();
		driver.findElement(By.id("numOneTf")).sendKeys("LX");	
		driver.findElement(By.id("numTwoTf")).click();
		driver.findElement(By.id("numTwoTf")).clear();
		driver.findElement(By.id("numTwoTf")).sendKeys("XIV");
	}
	
	@And("^The addition operation is selected$")
	public void theAddOperationIsSelected() throws Throwable {		
		driver.findElement(By.id("operationType")).click();
		new Select(driver.findElement(By.id("operationType"))).selectByVisibleText("+");
		driver.findElement(By.id("operationType")).click();
	}
	
	@And("^The subtract operation is selected$")
	public void theSubtractOperationIsSelected() throws Throwable {		
		driver.findElement(By.id("operationType")).click();
		new Select(driver.findElement(By.id("operationType"))).selectByVisibleText("-");
		driver.findElement(By.id("operationType")).click();
	}
	
	@And("^The divide operation is selected$")
	public void theDivideOperationIsSelected() throws Throwable {		
		driver.findElement(By.id("operationType")).click();
		new Select(driver.findElement(By.id("operationType"))).selectByVisibleText("/");
		driver.findElement(By.id("operationType")).click();
	}
	
	@And("^The multiply operation is selected$")
	public void theMultiplyOperationIsSelected() throws Throwable {		
		driver.findElement(By.id("operationType")).click();
		new Select(driver.findElement(By.id("operationType"))).selectByVisibleText("*");
		driver.findElement(By.id("operationType")).click();
	}
	
	@And("^The calculate button is clicked$")
	public void theCalculateButtonIsClicked() throws Throwable {		
		driver.findElement(By.id("calcBtn")).click();
		Thread.sleep(1000);	
	}
	
	@When("^Input field one is populated with roman numeral XX$")
	public void inputFieldOneIsPopulatedWithXX() throws Throwable {		
		driver.findElement(By.id("numOneTf")).click();
		driver.findElement(By.id("numOneTf")).clear();
		driver.findElement(By.id("numOneTf")).sendKeys("XX");	
	}
	
	@And("^Input field two is populated with roman numeral II$")
	public void inputFieldTwoIsPopulatedWithII() throws Throwable {		
		driver.findElement(By.id("numTwoTf")).click();
		driver.findElement(By.id("numTwoTf")).clear();
		driver.findElement(By.id("numTwoTf")).sendKeys("II");	
	}
	
	@When("^Input field one is populated with roman numeral III$")
	public void inputFieldOneIsPopulatedWithIII() throws Throwable {		
		driver.findElement(By.id("numOneTf")).click();
		driver.findElement(By.id("numOneTf")).clear();
		driver.findElement(By.id("numOneTf")).sendKeys("III");	
	}
	
	@When("^Input field one is populated with roman numeral II$")
	public void inputFieldOneIsPopulatedWithII() throws Throwable {		
		driver.findElement(By.id("numOneTf")).click();
		driver.findElement(By.id("numOneTf")).clear();
		driver.findElement(By.id("numOneTf")).sendKeys("II");	
	}
	
	@And("^Input field two is populated with roman numeral I$")
	public void inputFieldTwoIsPopulatedWithI() throws Throwable {		
		driver.findElement(By.id("numTwoTf")).click();
		driver.findElement(By.id("numTwoTf")).clear();
		driver.findElement(By.id("numTwoTf")).sendKeys("I");	
	}	
	
	@When("^Input field one is populated with roman numeral D$")
	public void inputFieldOneIsPopulatedWithD() throws Throwable {		
		driver.findElement(By.id("numOneTf")).click();
		driver.findElement(By.id("numOneTf")).clear();
		driver.findElement(By.id("numOneTf")).sendKeys("D");	
	}
	
	@And("^Input field two is populated with roman numeral D$")
	public void inputFieldTwoIsPopulatedWithD() throws Throwable {		
		driver.findElement(By.id("numTwoTf")).click();
		driver.findElement(By.id("numTwoTf")).clear();
		driver.findElement(By.id("numTwoTf")).sendKeys("D");	
	}
	
	@And("^Input field two is populated with roman numeral CD$")
	public void inputFieldTwoIsPopulatedWithID() throws Throwable {		
		driver.findElement(By.id("numTwoTf")).click();
		driver.findElement(By.id("numTwoTf")).clear();
		driver.findElement(By.id("numTwoTf")).sendKeys("CD");	
	}
	
	@And("^Input field two is populated with roman numeral XX$")
	public void inputFieldTwoIsPopulatedWithXX() throws Throwable {		
		driver.findElement(By.id("numTwoTf")).click();
		driver.findElement(By.id("numTwoTf")).clear();
		driver.findElement(By.id("numTwoTf")).sendKeys("XX");	
	}
	
	@When("^Input field one is populated with roman numeral CC$")
	public void inputFieldOneIsPopulatedWithCC() throws Throwable {		
		driver.findElement(By.id("numOneTf")).click();
		driver.findElement(By.id("numOneTf")).clear();
		driver.findElement(By.id("numOneTf")).sendKeys("CC");	
	}
	
	@And("^Input field two is populated with roman numeral CC$")
	public void inputFieldTwoIsPopulatedWithCC() throws Throwable {		
		driver.findElement(By.id("numTwoTf")).click();
		driver.findElement(By.id("numTwoTf")).clear();
		driver.findElement(By.id("numTwoTf")).sendKeys("CC");	
	}
	
	@When("^Input field one is populated with roman numeral V$")
	public void inputFieldOneIsPopulatedWithV() throws Throwable {		
		driver.findElement(By.id("numOneTf")).click();
		driver.findElement(By.id("numOneTf")).clear();
		driver.findElement(By.id("numOneTf")).sendKeys("V");	
	}
	
	@And("^Input field two is populated with roman numeral V$")
	public void inputFieldTwoIsPopulatedWithV() throws Throwable {		
		driver.findElement(By.id("numTwoTf")).click();
		driver.findElement(By.id("numTwoTf")).clear();
		driver.findElement(By.id("numTwoTf")).sendKeys("V");	
	}
	
	@When("^Input field one is populated with roman numeral L$")
	public void inputFieldOneIsPopulatedWithL() throws Throwable {		
		driver.findElement(By.id("numOneTf")).click();
		driver.findElement(By.id("numOneTf")).clear();
		driver.findElement(By.id("numOneTf")).sendKeys("L");	
	}
	
	@And("^Input field two is populated with roman numeral L$")
	public void inputFieldTwoIsPopulatedWithL() throws Throwable {		
		driver.findElement(By.id("numTwoTf")).click();
		driver.findElement(By.id("numTwoTf")).clear();
		driver.findElement(By.id("numTwoTf")).sendKeys("L");	
	}	
	
	@Then("^The correct result of the Addition calculation shall be displayed : LXXIV$")
	public void theExpectedResultOfTheAdditionOperationIsDisplayed() throws Throwable {		
		try {
			assertEquals("Result : LXXIV", driver.findElement(By.id("response")).getText());
		} finally {
			driver.quit();
		}
	}
	
	@Then("^The correct result of the Subtraction calculation shall be displayed : XLVI$")
	public void theExpectedResultOfTheSubtractionOperationIsDisplayed() throws Throwable {		
		try {
			assertEquals("Result : XLVI", driver.findElement(By.id("response")).getText());
		} finally {
			driver.quit();
		}
	}
	
	@Then("^The correct result of the Division calculation shall be displayed : IV$")
	public void theExpectedResultOfTheDivisionOperationIsDisplayed() throws Throwable {		
		try {
			assertEquals("Result : IV", driver.findElement(By.id("response")).getText());
		} finally {
			driver.quit();
		}
	}
	
	@Then("^The correct result of the Multiplication calculation shall be displayed : DCCCXL$")
	public void theExpectedResultOfTheMultiplicationOperationIsDisplayed() throws Throwable {		
		try {
			assertEquals("Result : DCCCXL", driver.findElement(By.id("response")).getText());
		} finally {
			driver.quit();
		}
	}
	
	@Then("^The correct result of the calculation shall be displayed : XXII$")
	public void theExpectedResultOfXXIIIsDisplayed() throws Throwable {		
		try {
			assertEquals("Result : XXII", driver.findElement(By.id("response")).getText());
		} finally {
			driver.quit();
		}
	}
	
	@Then("^The correct result of the calculation shall be displayed : IV$")
	public void theExpectedResultOfIVIsDisplayed() throws Throwable {		
		try {
			assertEquals("Result : IV", driver.findElement(By.id("response")).getText());
		} finally {
			driver.quit();
		}
	}
	
	@Then("^The correct result of the calculation shall be displayed : CM$")
	public void theExpectedResultOfCMIsDisplayed() throws Throwable {		
		try {
			assertEquals("Result : CM", driver.findElement(By.id("response")).getText());
		} finally {
			driver.quit();
		}
	}
	
	@Then("^The correct result of the calculation shall be displayed : XL$")
	public void theExpectedResultOfXLIsDisplayed() throws Throwable {		
		try {
			assertEquals("Result : XL", driver.findElement(By.id("response")).getText());
		} finally {
			driver.quit();
		}
	}
	
	@Then("^The correct result of the calculation shall be displayed : CD$")
	public void theExpectedResultOfCDIsDisplayed() throws Throwable {		
		try {
			assertEquals("Result : CD", driver.findElement(By.id("response")).getText());
		} finally {
			driver.quit();
		}
	}
	
	@Then("^The correct result of the calculation shall be displayed : X$")
	public void theExpectedResultOfXIsDisplayed() throws Throwable {		
		try {
			assertEquals("Result : X", driver.findElement(By.id("response")).getText());
		} finally {
			driver.quit();
		}
	}
	
	@Then("^The correct result of the calculation shall be displayed : C$")
	public void theExpectedResultOfCIsDisplayed() throws Throwable {		
		try {
			assertEquals("Result : C", driver.findElement(By.id("response")).getText());
		} finally {
			driver.quit();
		}
	}
	
	@Then("^The correct result of the calculation shall be displayed : M$")
	public void theExpectedResultOfMIsDisplayed() throws Throwable {		
		try {
			assertEquals("Result : M", driver.findElement(By.id("response")).getText());
		} finally {
			driver.quit();
		}
	}

}