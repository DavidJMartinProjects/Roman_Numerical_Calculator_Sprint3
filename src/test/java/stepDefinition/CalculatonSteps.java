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

public class CalculatonSteps {
	
	private final static String browserType = "chrome";
	private final WebDriver driver = DriverFactory.open(browserType);
	private final static StringBuffer verificationErrors = new StringBuffer();

	@Before	
	public void setUp() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Given("^The browser is on the homepage$")
	public void whenGiven() throws Throwable {		
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
	
	@Then("^The correct result of the Addition calculation shall be displayed : LXXIV$")
	public void theExpectedResultOfTheAdditionOperationIsDisplayed() throws Throwable {		
		try {
			assertEquals("Result : XIV + LX = LXXIV", driver.findElement(By.id("result")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		} finally {
			driver.quit();
		}
	}
	
	@Then("^The correct result of the Subtraction calculation shall be displayed : XLVI$")
	public void theExpectedResultOfTheSubtractionOperationIsDisplayed() throws Throwable {		
		try {
			assertEquals("Result : XIV + LX = XLVI", driver.findElement(By.id("result")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		} finally {
			driver.quit();
		}
	}
	
	@Then("^The correct result of the Division calculation shall be displayed : VI$")
	public void theExpectedResultOfTheDivisionOperationIsDisplayed() throws Throwable {		
		try {
			assertEquals("Result : XIV + LX = VI", driver.findElement(By.id("result")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		} finally {
			driver.quit();
		}
	}
	
	@Then("^The correct result of the Multiplication calculation shall be displayed : DCCCXL$")
	public void theExpectedResultOfTheMultiplicationOperationIsDisplayed() throws Throwable {		
		try {
			assertEquals("Result : XIV + LX = DCCCXL", driver.findElement(By.id("result")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		} finally {
			driver.quit();
		}
	}

}