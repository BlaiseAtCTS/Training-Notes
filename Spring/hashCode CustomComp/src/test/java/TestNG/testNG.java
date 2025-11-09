package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class testNG {
    WebDriver driver;
    @Test(priority = 0, groups = { "smoke" })
    public void OpenBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().setSize(new Dimension(640, 480));
        driver.get("https://the-internet.herokuapp.com/");
        System.out.println("Hello from TestNG");
    }

    @Test(priority = 1)
    public void commands1() throws InterruptedException {
        String window1 = driver.getWindowHandle();
        System.out.println(window1);
        Actions actions = new Actions(driver);
        Action action = actions.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).build();
        action.perform();
        driver.findElement(By.xpath("//a[contains(., 'Drag and Drop')]")).click();
        String window2 = driver.getWindowHandle();
        System.out.println(window2);
        Thread.sleep(Duration.ofSeconds(10));
        driver.navigate().back();
        Thread.sleep(Duration.ofSeconds(5));
        System.out.println("World from TestNG");
    }

    @Parameters("quitOrNot")
    @AfterClass
    public void tearDown(String arg0) {
        if(arg0.equalsIgnoreCase("true")) {
            System.out.println("Quit from TestNG: true");
            driver.quit();
        } else {
            System.out.println("Quit from TestNG: false");
            driver.quit();
        }
    }
}
