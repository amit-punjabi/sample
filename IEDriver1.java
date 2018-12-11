import org.openqa.selenium.By;
        import org.openqa.selenium.Platform;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.remote.DesiredCapabilities;
        import org.openqa.selenium.remote.RemoteWebDriver;

        import java.net.URL;

public class IEDriver1 {

    public static final String USERNAME = "USERNAME";
    public static final String AUTOMATE_KEY = "ACCESS_KEY";
    public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static void main(String[] args) throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "IE");
        caps.setCapability("build", "IEDriverCheck");
        caps.setCapability("browser_version", "11.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browserstack.selenium_version", "3.13.0");
        caps.setCapability("browserstack.ie.driver", "3.13.0");


        caps.setCapability("resolution", "1024x768");

        System.getProperties().put("http.proxyHost", "127.0.0.1");
        System.getProperties().put("http.proxyPort", "3128");

//        for(int i=0;i<10;i++) {
            WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
            driver.get("http://www.google.com");
            WebElement element = driver.findElement(By.name("q"));

            element.sendKeys("BrowserStack");
            element.submit();

            System.out.println(driver.getTitle());
            driver.quit();
//        }
    }
}