package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testNG2 {
    WebDriver driver;
    @Test(priority = 1)
    public void OpenBrowser() {
        driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().setSize(new Dimension(640, 480));
        System.out.println("Hello from TestNG2");
    }

    @Test(dependsOnMethods = "OpenBrowser", priority = 0)
    public void commands1() {
        String window1 = driver.getWindowHandle();
        System.out.println(window1);
        driver.findElement(By.xpath("//a[contains(., 'Drag and Drop')]")).click();
        String window2 = driver.getWindowHandle();
        System.out.println(window2);
        driver.navigate().back();
        System.out.println("World from TestNG2");
    }

    @Parameters("quitOrNot")
    @AfterClass
    public void tearDown(String arg0) {
        if(arg0.equalsIgnoreCase("true")) {
            System.out.println("Quit from TestNG");
            driver.quit();
        }
    }
}
