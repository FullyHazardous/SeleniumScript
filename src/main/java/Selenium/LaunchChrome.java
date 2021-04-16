package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class LaunchChrome {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.worknet.am/hy/");
        System.out.println(driver.getTitle());
        //get number of users using xpath
        String NumOfUsers = driver.findElement(By .xpath("/html[1]/body[1]/main[1]/section[1]/div[1]/div[1]/div[1]/p[1]")).getAttribute("data-count");
        System.out.println("Օգտատեր: "+NumOfUsers);
        //get number of companies using css selector
        String NumOfCompanies = driver.findElement(By .cssSelector("body.greey:nth-child(2) main.main:nth-child(1) section.content.content--full div.content__inner.content__inner--sm div.row.count-box:nth-child(2) div.col-3:nth-child(2) > p.counter:nth-child(1)")).getAttribute("data-count");
        System.out.println("Ընկերություն: "+NumOfCompanies);
        // find search button using xpath
        WebElement searcher = driver.findElement(By .xpath("/html/body/main/header/div/ul/li[1]/a/i"));
        //click search button
        searcher.click();
        //find the input box for searching
        WebElement p = driver.findElement(By .xpath("//header/div[1]/form[1]/div[1]/input[1]"));
        WebDriverWait w = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //type search word "Java"
        p.sendKeys("Java");
        //search!
        p.submit();
        // a while loop prints top 4 jobs matching keyword java!
        int i = 1;
        System.out.println("Թոփ Հայտարարություններ: ");
        while(i<5){
            String j = "/html[1]/body[1]/main[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[" + i + "]/div[1]/div[1]/div[1]/a[1]";
            i++;
            String ListOjJobs = driver.findElement(By .xpath(j)).getText();
            System.out.println(ListOjJobs);
        }
        //terminate the WebDriver
        driver.close();
    }
}
