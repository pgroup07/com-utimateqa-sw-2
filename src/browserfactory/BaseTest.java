package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public void openBrowser(String baseUrl) {
        //Launch the Chrome Browser
        driver = new ChromeDriver();
        //Open the Url into the Browser
        driver.get(baseUrl);
        // MAximise Browser
        driver.manage().window().maximize();
        // We provide implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void closerBrowser() {
        driver.quit();
    }
}
