package selenium;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.web.WebAppConfiguration;

import ultilities.DriverFactory;
import webLayer.CalculatorWS;

@SpringBootTest(classes = CalculatorWS.class)
@ComponentScan(basePackages = { "domainLayer", "businessLayer", "businessLayer.api", "businessLayer.operations",
		"webLayer", "utils" })
@WebAppConfiguration

public class SeleniumExceptionsTests {

	private final String browserType = "chrome";
	private final WebDriver driver = DriverFactory.open(browserType);

	@Autowired
	private WebDriver webDriver;

	@Before
	public void setUp() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// addition exception messages
	@Test
	public void additionCalculation_ResultIsGreaterThanMaximumValueMsgTest() throws Exception {
		driver.get("http://localhost:8080/");
		driver.findElement(By.id("numOneTf")).click();
		driver.findElement(By.id("numOneTf")).clear();
		driver.findElement(By.id("numOneTf")).sendKeys("MMM");
		driver.findElement(By.id("operationType")).click();
		new Select(driver.findElement(By.id("operationType"))).selectByVisibleText("+");
		driver.findElement(By.id("operationType")).click();
		driver.findElement(By.id("numTwoTf")).click();
		driver.findElement(By.id("numTwoTf")).clear();
		driver.findElement(By.id("numTwoTf")).sendKeys("MMM");
		driver.findElement(By.id("calcBtn")).click();

		assertEquals("addition error : result is greater than 3999.", driver.findElement(By.id("response")).getText());
		Thread.sleep(1000);
	}

	// subtraction exception messages
	@Test
	public void subtractionCalculation_NumeralOneIsGreaterThanNumeralTwoMsgTest() throws Exception {
		driver.get("http://localhost:8080/");
		driver.findElement(By.id("numOneTf")).click();
		driver.findElement(By.id("numOneTf")).clear();
		driver.findElement(By.id("numOneTf")).sendKeys("X");
		driver.findElement(By.id("operationType")).click();
		new Select(driver.findElement(By.id("operationType"))).selectByVisibleText("-");
		driver.findElement(By.id("operationType")).click();
		driver.findElement(By.id("numTwoTf")).click();
		driver.findElement(By.id("numTwoTf")).clear();
		driver.findElement(By.id("numTwoTf")).sendKeys("XI");
		driver.findElement(By.id("calcBtn")).click();

		assertEquals("subtraction error : numeral 1 is greater than numeral 2",
				driver.findElement(By.id("response")).getText());
		Thread.sleep(1000);
	}

	@Test
	public void subtractionCalculation_ResultIsZeroMsgTest() throws Exception {
		driver.get("http://localhost:8080/");
		driver.findElement(By.id("numOneTf")).click();
		driver.findElement(By.id("numOneTf")).clear();
		driver.findElement(By.id("numOneTf")).sendKeys("X");
		driver.findElement(By.id("operationType")).click();
		new Select(driver.findElement(By.id("operationType"))).selectByVisibleText("-");
		driver.findElement(By.id("operationType")).click();
		driver.findElement(By.id("numTwoTf")).click();
		driver.findElement(By.id("numTwoTf")).clear();
		driver.findElement(By.id("numTwoTf")).sendKeys("X");
		driver.findElement(By.id("calcBtn")).click();

		assertEquals("subtraction error : result was zero.", driver.findElement(By.id("response")).getText());
		Thread.sleep(1000);
	}

	// division exception messages
	@Test
	public void divisionCalculation_NumeralOneIsGreaterThanNumeralTwoMsgTest() throws Exception {
		driver.get("http://localhost:8080/");
		driver.findElement(By.id("numOneTf")).click();
		driver.findElement(By.id("numOneTf")).clear();
		driver.findElement(By.id("numOneTf")).sendKeys("X");
		driver.findElement(By.id("operationType")).click();
		new Select(driver.findElement(By.id("operationType"))).selectByVisibleText("/");
		driver.findElement(By.id("operationType")).click();
		driver.findElement(By.id("numTwoTf")).click();
		driver.findElement(By.id("numTwoTf")).clear();
		driver.findElement(By.id("numTwoTf")).sendKeys("XI");
		driver.findElement(By.id("calcBtn")).click();

		assertEquals("division error : numeral 1 is greater than numeral 2.",
				driver.findElement(By.id("response")).getText());
		Thread.sleep(1000);
	}

	// modulus exception messages
	@Test
	public void modulusCalculation_NumeralOneIsGreaterThanNumeralTwoMsgTest() throws Exception {
		driver.get("http://localhost:8080/");
		driver.findElement(By.id("numOneTf")).click();
		driver.findElement(By.id("numOneTf")).clear();
		driver.findElement(By.id("numOneTf")).sendKeys("X");
		driver.findElement(By.id("operationType")).click();
		new Select(driver.findElement(By.id("operationType"))).selectByVisibleText("%");
		driver.findElement(By.id("operationType")).click();
		driver.findElement(By.id("numTwoTf")).click();
		driver.findElement(By.id("numTwoTf")).clear();
		driver.findElement(By.id("numTwoTf")).sendKeys("XI");
		driver.findElement(By.id("calcBtn")).click();

		assertEquals("modulus error : numeral 1 is greater than numeral 2",
				driver.findElement(By.id("response")).getText());
		Thread.sleep(1000);
	}

	@Test
	public void modulusCalculation_ResultIsZeroMsgTest() throws Exception {
		driver.get("http://localhost:8080/");
		driver.findElement(By.id("numOneTf")).click();
		driver.findElement(By.id("numOneTf")).clear();
		driver.findElement(By.id("numOneTf")).sendKeys("X");
		driver.findElement(By.id("operationType")).click();
		new Select(driver.findElement(By.id("operationType"))).selectByVisibleText("%");
		driver.findElement(By.id("operationType")).click();
		driver.findElement(By.id("numTwoTf")).click();
		driver.findElement(By.id("numTwoTf")).clear();
		driver.findElement(By.id("numTwoTf")).sendKeys("X");
		driver.findElement(By.id("calcBtn")).click();

		assertEquals("modulus error : result was zero.", driver.findElement(By.id("response")).getText());
		Thread.sleep(1000);
	}

	// multiplication exception messages
	@Test
	public void multiplicationCalculation_ResultIsGreaterThanMaximumValueMsgTest() throws Exception {
		driver.get("http://localhost:8080/");
		driver.findElement(By.id("numOneTf")).click();
		driver.findElement(By.id("numOneTf")).clear();
		driver.findElement(By.id("numOneTf")).sendKeys("MMM");
		driver.findElement(By.id("operationType")).click();
		new Select(driver.findElement(By.id("operationType"))).selectByVisibleText("*");
		driver.findElement(By.id("operationType")).click();
		driver.findElement(By.id("numTwoTf")).click();
		driver.findElement(By.id("numTwoTf")).clear();
		driver.findElement(By.id("numTwoTf")).sendKeys("MMM");
		driver.findElement(By.id("calcBtn")).click();

		assertEquals("multiplication error : result is greater than 3999.",
				driver.findElement(By.id("response")).getText());
		Thread.sleep(1000);
	}

	@Test
	public void userLeavesBothInputFieldsEmptyMsgTest() throws Exception {
		driver.get("http://localhost:8080/");
		driver.findElement(By.id("calcBtn")).click();

		assertEquals("error : please input a roman numeral.", driver.findElement(By.id("response")).getText());
		Thread.sleep(1000);
	}

	@Test
	public void userLeavesBothInputFieldOneEmptyMsgTest() throws Exception {
		driver.get("http://localhost:8080/");

		new Select(driver.findElement(By.id("operationType"))).selectByVisibleText("*");
		driver.findElement(By.id("operationType")).click();
		driver.findElement(By.id("numTwoTf")).click();
		driver.findElement(By.id("numTwoTf")).clear();
		driver.findElement(By.id("numTwoTf")).sendKeys("X");
		driver.findElement(By.id("calcBtn")).click();

		assertEquals("error : please input a roman numeral.", driver.findElement(By.id("response")).getText());
		Thread.sleep(1000);
	}

	@Test
	public void userLeavesBothInputFieldTwoEmptyMsgTest() throws Exception {
		driver.get("http://localhost:8080/");

		new Select(driver.findElement(By.id("operationType"))).selectByVisibleText("*");
		driver.findElement(By.id("operationType")).click();
		driver.findElement(By.id("numOneTf")).click();
		driver.findElement(By.id("numOneTf")).clear();
		driver.findElement(By.id("numOneTf")).sendKeys("X");
		driver.findElement(By.id("calcBtn")).click();

		assertEquals("error : please input a roman numeral.", driver.findElement(By.id("response")).getText());
		Thread.sleep(1000);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
