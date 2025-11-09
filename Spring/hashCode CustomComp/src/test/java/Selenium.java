import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Selenium {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        /* Mock Interview
        driver.get("https://www.saucedemo.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='shopping_cart_link']/span")));
        driver.findElement(By.className("shopping_cart_link")).click();
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/cart.html"));
        driver.findElement(By.xpath("//button[.='Remove']")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[.='Remove']")));
        Assert.assertFalse(driver.findElement(By.xpath("//button[.='Remove']")).isDisplayed());

        // Exercise 1
        driver.get("https://demoqa.com/menu");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a[.='Main Item 2']"))).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='SUB SUB LIST »']")));
        actions.moveToElement(driver.findElement(By.xpath("//a[.='SUB SUB LIST »']"))).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Sub Sub Item 1']")));
        actions.moveToElement(driver.findElement(By.xpath("//a[.='Sub Sub Item 1']"))).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Sub Sub Item 2']")));
        actions.moveToElement(driver.findElement(By.xpath("//a[.='Sub Sub Item 2']"))).click().perform();
        Assert.assertEquals("https://demoqa.com/menu#", driver.getCurrentUrl());
        Thread.sleep(Duration.ofSeconds(5));
        // Exercise 2
        driver.get("https://demoqa.com/droppable");
        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).perform();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='simpleDropContainer']/div[@id='droppable']/p")).getText().equalsIgnoreCase("Dropped!"));
        Assert.assertEquals("drop-box ui-droppable ui-state-highlight", driver.findElement(By.xpath("//div[@id='simpleDropContainer']/div[@id='droppable']")).getAttribute("class"));
        // Exercise 3
        driver.get("https://demoqa.com/buttons");
        Actions actions = new Actions(driver);
        Action doubleClick = actions.doubleClick(driver.findElement(By.id("doubleClickBtn"))).build();
        Action rightClick = actions.contextClick(driver.findElement(By.id("rightClickBtn"))).build();
        Action leftClick = actions.click(driver.findElement(By.xpath("//button[normalize-space(.)='Click Me']"))).build();
        doubleClick.perform();
        Assert.assertEquals("You have done a double click", driver.findElement(By.id("doubleClickMessage")).getText());
        rightClick.perform();
        Assert.assertEquals("You have done a right click", driver.findElement(By.id("rightClickMessage")).getText());
        leftClick.perform();
        Assert.assertEquals("You have done a dynamic click", driver.findElement(By.id("dynamicClickMessage")).getText());
        // Exercise 4
        driver.get("https://demoqa.com/links");
        String linksHandle = driver.getWindowHandle();
        System.out.println(linksHandle);
        driver.findElement(By.id("simpleLink")).click();
        Set<String> handles = driver.getWindowHandles();
        handles.forEach((String handle) -> {
            if(!handle.equals(linksHandle)) {
                driver.switchTo().window(handle);
            }
        });
        Thread.sleep(Duration.ofSeconds(5));
        String homeHandle = driver.getWindowHandle();
        System.out.println(homeHandle);
        driver.switchTo().window(linksHandle);
        // Exercise 5
        driver.get("https://demoqa.com/browser-windows");
        String homeHandle = driver.getWindowHandle();
        driver.findElement(By.id("windowButton")).click();
        driver.findElement(By.id("messageWindowButton")).click();
        Set<String> handles = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<>();
        handles.forEach(handle -> {
            if(!handle.equals(homeHandle)) {
                driver.switchTo().window(handle);
                handlesList.add(driver.getWindowHandle());
            }
        });
        for (String s : handlesList) {
            driver.switchTo().window(s);
            System.out.println(s);
            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getPageSource());
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[contains(., '')]")));
            System.out.println("Wait Over");
            System.out.println(driver.getTitle());
            System.out.println(driver.findElement(By.xpath("//body[contains(., '')]")).getText());
            System.out.println("found element");
        }
        // Exercise 7
        driver.get("https://demoqa.com/frames");
        String homeHandle = driver.getWindowHandle();
        driver.switchTo().frame(driver.findElement(By.id("frame1")));
        String textInFrame1 = driver.findElement(By.id("sampleHeading")).getText();
        String FontInFrame1 = driver.findElement(By.id("sampleHeading")).getCssValue("font-size");
        System.out.println("Text: "+ textInFrame1 +" Font Size: "+ FontInFrame1);
        driver.switchTo().window(homeHandle);
        driver.switchTo().frame(driver.findElement(By.id("frame2")));
        String textInFrame2 = driver.findElement(By.id("sampleHeading")).getText();
        String FontInFrame2 = driver.findElement(By.id("sampleHeading")).getCssValue("font-size");
        System.out.println("Text: "+ textInFrame2 +" Font Size: "+FontInFrame2);
        Assert.assertEquals(textInFrame1, textInFrame2);
        Assert.assertTrue(Integer.valueOf( FontInFrame1.substring(0, 2)) > Integer.valueOf(FontInFrame2.substring(0, 2)));
        */
        // Exercise 8
//        driver.get("https://demoqa.com/webtables");
//        WebElement table = driver.findElement(By.className("rt-tbody"));
//        List<WebElement> rows = table.findElements(By.className("rt-tr-group"));
//        for(WebElement row : rows) {
//            System.out.println(row.getText());
//            List<WebElement> cells = row.findElements(By.className("rt-td"));
//            cells.stream()
//                    .forEach(cell -> System.out.print(cell.getText() + " "));
//            System.out.println();
//        }
//        Alert alert = driver.switchTo().alert();
        Point point = driver.findElement(By.id("id")).getLocation();
        point.getX();

        Thread.sleep(Duration.ofSeconds(5));
        driver.quit();
    }
}
