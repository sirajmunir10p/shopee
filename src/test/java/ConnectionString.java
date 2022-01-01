
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ConnectionString {
    public WebDriver driver;
    public ChromeOptions options;


    @BeforeTest
    public void getChromeDriver() throws InterruptedException {

        try {
            WebDriverManager.chromedriver().setup();
            //Chrome Options
            options = new ChromeOptions();
            options.addArguments("start-maximized");
            //options.addArguments("headless");
            options.addArguments("--incognito");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-popup-blocking");
            driver = new ChromeDriver(options);

        } catch (Exception ex) {
            System.out.println("Cause is: " + ex.getCause());
            System.out.println("Message is: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @AfterTest
    public void TearDownTest() {
        try {
            driver.quit();
            System.out.println("Now Application Quit the Web Driver");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
