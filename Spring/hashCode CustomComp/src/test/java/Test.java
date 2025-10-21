import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Test {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
//        driver.get("https://www.geeksforgeeks.org/java/java/");
        /*
        driver.get("https://webapps.tekstac.com/SeleniumApp1/TrainReservation/login.html");
        System.out.println("Parent: " + driver.getTitle());
        String parentWinHandle = driver.getWindowHandle();
        System.out.println(parentWinHandle);
        driver.findElement(By.xpath("//a[@id='gmailsignin']")).click();
        Set<String> allHandles = driver.getWindowHandles();
        System.out.println("All Handles: " + allHandles.toString());

        for (String windowHandle : allHandles) {
            if (!windowHandle.equals(parentWinHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        String childWinHandle = driver.getWindowHandle();
        System.out.println(childWinHandle);
        System.out.println("Child: " + driver.getTitle());
        */
        /*
        File file = new File("./image.png");
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenshot, file);
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String windowHandle = driver.getWindowHandle();
        String windowTitle = driver.getTitle();

        WebElement elem = driver.findElement(By.xpath("//iframe"));
        String link = elem.getAttribute("src");
        System.out.println(link);
        WebElement computer = driver.findElement(By.id("ComputerQuantity"));
        computer.sendKeys("2");

        driver.get("https://webapps.tekstac.com/SeleniumApp1/SmartUniversity/add_stud.html");
        driver.findElement(By.xpath("//div/input[@type='button']")).click();
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        WebElement fileNametxt = wait.until(driver1->{
            WebElement k = driver1.findElement(By.xpath("//div/span"));
            if(k.getText().trim().length() <= 0) {
                return null;
            }
            return k;
        });

        driver.get("https://webapps.tekstac.com/RentaCar/");
        driver.findElement(By.xpath("//input[contains(@placeholder, 'Enter the name')]")).sendKeys("Peter");
        driver.findElement(By.xpath("//input[@type='tel' and @id='number']")).sendKeys("9876543234");
        driver.findElement(By.xpath("//textarea[1]")).sendKeys("Texas");
        driver.findElement(By.xpath("//input[@type='date' or @id='traveldate']")).sendKeys("2024-02-02");
        WebElement carType = driver.findElement(By.xpath("//td[.='Car Type']/following-sibling::td/child::select"));
        Select select = new Select(carType);
        select.selectByVisibleText("SUV");
        driver.findElement(By.xpath("//input[starts-with(@id, 'du')]")).sendKeys("5");
        driver.findElement(By.xpath("//td[.='Payment Mode']/preceding::input[position() = 1]")).sendKeys("3224");
        driver.findElement(By.xpath("//td[.='Duration (in hours)']/following::input[position() = 3]")).click();
        driver.findElement(By.xpath("//button[text() = 'Confirm']")).click();
        WebElement msg = driver.findElement(By.xpath("//div[@id='result']"));
        System.out.println(msg.getText());
        String fName = driver.findElement(By.xpath("//div[@id='result']/ancestor::div")).getText();
        System.out.println("fName: " + fName);

        driver.get("https://webapps.tekstac.com/HotelApplication/booking.html");
        driver.findElement(By.xpath("//input[@id='fName']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@id='fName']/following::input")).sendKeys("Peter");
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        driver.get("https://webapps.tekstac.com/selenium/LOGIN_WEBPAGE/index.html");
        JavascriptExecutor exec = (JavascriptExecutor) driver;
        String email = "george@gmail";
        String password = "123";
        exec.executeScript("document.getElementById('email').value=arguments[0]", email);
        exec.executeScript("document.getElementById('pass').value=arguments[0]", password);
        exec.executeScript("document.querySelector('input[type='submit']').click()");
        System.out.println(driver.findElement(By.xpath("//div[starts-with(text(), 'Welcome')]")).getText());

        driver.get("https://webapps.tekstac.com/OnlineShopping/");
        Actions actions = new Actions(driver);
        WebElement from = driver.findElement(By.id("carrot"));
        WebElement to = driver.findElement(By.id("droppable"));
        Action action = actions.dragAndDrop(from, to).build();
        action.perform();

        Point source = driver.findElement(By.id("beetroot")).getLocation();
        Point target = driver.findElement(By.id("droppable")).getLocation();
        int sourceX = source.getX();
        int sourceY = source.getY();
        int targetX = target.getX();
        int targetY = target.getY();

        String name = "carrot";
        String quantity = "5";
        driver.get("https://webapps.tekstac.com/OnlineShopping/");
        WebElement from = driver.findElement(By.id(name));
        WebElement to = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(from, to).perform();
        WebElement slider = driver.findElement(By.id("myRange"));
        Point sliderLocation = slider.getLocation();
        int sliderX = sliderLocation.getX();
        int sliderY = sliderLocation.getY();
        int xOffset = 0;
        int yOffset = 0;
        if(quantity.equals("5")) {
            xOffset = -10;
        } else if(quantity.equals("4")) {
            xOffset = -20;
        } else if(quantity.equals("3")) {
            xOffset = -40;
        } else if(quantity.equals("6")) {
            xOffset = 10;
        } else if(quantity.equals("7")) {
            xOffset = 20;
        }
        actions.dragAndDropBy(slider, xOffset, yOffset).perform();
        WebElement selectEl = driver.findElement(By.id("Platform"));
        Select select = new Select(selectEl);
        select.selectByVisibleText("BigBasket.com");
        driver.findElement(By.id("quantityOK")).click();
        driver.findElement(By.id("showBill")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement billShow = driver.findElement(By.id("billShow"));
        wait.until(ExpectedConditions.visibilityOf(billShow));
        System.out.println(billShow.getText());
        */
        
        Thread.sleep(10000);
        driver.quit();
    }
}
