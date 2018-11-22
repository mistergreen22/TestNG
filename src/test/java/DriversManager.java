import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public enum DriversManager {


    CHROME {
        public WebDriver create(){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//resources/chromedriver.exe");
            return  new ChromeDriver();
        }
    },
    FIREFOX {
        public WebDriver create(){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//resources/geckodriver.exe");
            return  new FirefoxDriver();
        }
    },
    EDGE {
        public WebDriver create(){
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "//resources/MicrosoftWebDriver.exe");
            return  new EdgeDriver();
        }
    };
    public WebDriver create(){
        return null;
    }


    @BeforeTest
    public static EventFiringWebDriver getConfiguredDriver() {

        EventFiringWebDriver driver = new EventFiringWebDriver(DriversManager.CHROME.create());
        driver.register(new EventHandler());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }



}

