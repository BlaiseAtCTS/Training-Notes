package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Test {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://github.com/BlaiseAtCTS?tab=repositories");
        System.out.println(driver.getCurrentUrl());
        WebElement newRepo = driver.findElement(By.cssSelector("a[href='/new']"));
        newRepo.click();
        WebElement repoName = driver.findElement(By.id("repository-name-input"));
        repoName.sendKeys("New Repo");
        WebElement repoPrivacy = driver.findElement(By.id("visibility-anchor-button"));
        repoPrivacy.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.quit();
    }
}
