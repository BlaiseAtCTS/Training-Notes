# Automation Testing Notes
## Why AT?
Increased speed and efficiency.
improved accuracy and reliability.
broader test coverage.
cost and time savings.
enhanced quality.
24/7 test execution.
better use of resources.
regression testing efficiency.
support for CI/CD.
deeper testing capabilities.

## Selenium - Open Source:
Selenium Architecture.
A driver like JDBC driver.
To automate functional testing.
Test suite - will automatically run and test the product whenever there is a release. (Smoke test as a suite)
If 90% of test cases pass, they can release the build.
Can be used to automate things, like submit timesheet.
Multiple programming lang.
4 components: 
Idle
Webdriver
Grid (Distributed execution) Eg. running test cases parallely instead of running test cases one by one.

## Webdriver - Interface:
There is a driver for each browser.
ChromeDriver will have chrome packages.
WebDriver driver = new ChromeDriver();
driver.get("localhost")
sout > driver.getTitle()
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5))

## Locators: to select each element in a web page.
There are 7-8 locators.
By.id() -> this is a locator
Static and Dynamic selectors / Attribute and Property selectors.
findElements() -> select elements.
WebElement fullName = driver.findElement(By.cssSelector("#fullName")) -> full name is the id. (or) By.id("email")

WebElement submit = driver.findElement(By.cssSelector("input[type='submit']"))

fullName.sendKeys("Adam")
submit.click()

driver.quit() -> browser will close

## Testing Engine - in MVN Repository:
Advantages of using TestEngine over JUnit.

## Annotation:
@Test - to define a specific test case.
@BeforeTest - initialize WebDriver (void init()).
@AfterTest - (void tearDown()). Works like finally, driver.quit().

## Selenium Exceptions:
NoSuchElementException -> when wrong element id is given and selenium is unable to find it.
TimeOutException - if time runs out