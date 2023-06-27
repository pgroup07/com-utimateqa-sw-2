package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        // click on the ‘Sign In’ link
        driver.findElement(By.xpath("//a[contains(text(),'Sign ')]")).click();

        String actualMessage = "Welcome Back!";
        String expectedMessage = driver.findElement(By.xpath("//h2[contains(text(),'Welcome ')]")).getText();
        Assert.assertEquals("Error Message is not Displayed", expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheErrorMessage() {
        // click on the ‘Sign In’ link
        driver.findElement(By.xpath("//a[contains(text(),'Sign ')]")).click();
        //  Enter invalid username
        driver.findElement(By.xpath("//input[@id='user[email]']")).sendKeys("vmhv54@gmail.com");
        // Enter invalid password
        driver.findElement(By.xpath("//input[@id='user[password]']")).sendKeys("khvx56");
        //  Click on Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String actualMsg = "Invalid email or password.";
        String expectedMsg = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals("Error Message is not Displayed", expectedMsg, actualMsg);
    }


    @After
    public void tearDown() {
       closerBrowser();
    }
}
