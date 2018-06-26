package com.selenium.demo;

import org.junit.Test;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes= Application.class)
public class seleniumTest {
	
	@Test
	public void myTest() {
		
	}
//	private final String browserType = "chrome";
//	private final WebDriver driver = DriverFactory.open(browserType);
//	private boolean acceptNextAlert = true;
//	private final StringBuffer verificationErrors = new StringBuffer();
//
//    @Autowired
//    private WebDriver webDriver;
//    
//	@Before
//	public void setUp() throws Exception {
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//	}
//
//	@Test
//	public void verifyThatTheCorrectCalculationResultIsDisplayed() throws Exception {
//		driver.get("http://localhost:8080/");
//		driver.findElement(By.id("numOneTf")).click();
//		driver.findElement(By.id("numOneTf")).clear();
//		driver.findElement(By.id("numOneTf")).sendKeys("XX");
//		driver.findElement(By.id("numTwoTf")).click();
//		driver.findElement(By.id("numTwoTf")).clear();
//		driver.findElement(By.id("numTwoTf")).sendKeys("X");
//		driver.findElement(By.id("calcButton")).click();
//		try {
//			assertEquals("Result : XX + X = XXX", driver.findElement(By.id("result")).getText());
//		} catch (Error e) {
//			verificationErrors.append(e.toString());
//		}
//	}
//
//	@Test
//	public void testVerifyErrorMessage() throws Exception {
//		driver.get("http://localhost:8080/");
//		driver.findElement(By.id("calcButton")).click();
//		try {
//			assertEquals("Please Input a Roman Numeral.", driver.findElement(By.id("validationMessage")).getText());
//		} catch (Error e) {
//			verificationErrors.append(e.toString());
//		}
//	}
//
//	@Test
//	public void testVerifyInvalidInputMsg() throws Exception {
//		driver.get("http://localhost:8080/");
//		driver.findElement(By.id("numOneTf")).click();
//		driver.findElement(By.id("numOneTf")).clear();
//		driver.findElement(By.id("numOneTf")).sendKeys("23");
//		driver.findElement(By.id("numTwoTf")).click();
//		driver.findElement(By.id("numTwoTf")).clear();
//		driver.findElement(By.id("numTwoTf")).sendKeys("23");
//		driver.findElement(By.id("calcButton")).click();
//		try {
//			assertEquals("Invalid Roman Numerical Format.", driver.findElement(By.id("validationMessage")).getText());
//		} catch (Error e) {
//			verificationErrors.append(e.toString());
//		}
//	}
//
//	@After
//	public void tearDown() throws Exception {
//		driver.quit();
//		String verificationErrorString = verificationErrors.toString();
//		if (!"".equals(verificationErrorString)) {
//			fail(verificationErrorString);
//		}
//	}
//
//	private boolean isElementPresent(By by) {
//		try {
//			driver.findElement(by);
//			return true;
//		} catch (NoSuchElementException e) {
//			return false;
//		}
//	}
//
//	private boolean isAlertPresent() {
//		try {
//			driver.switchTo().alert();
//			return true;
//		} catch (NoAlertPresentException e) {
//			return false;
//		}
//	}
//
//	private String closeAlertAndGetItsText() {
//		try {
//			Alert alert = driver.switchTo().alert();
//			String alertText = alert.getText();
//			if (acceptNextAlert) {
//				alert.accept();
//			} else {
//				alert.dismiss();
//			}
//			return alertText;
//		} finally {
//			acceptNextAlert = true;
//		}
//	}
}
