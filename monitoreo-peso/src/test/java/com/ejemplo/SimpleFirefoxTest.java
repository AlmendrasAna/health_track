package com.ejemplo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleFirefoxTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        
        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions();
        //options.addArguments("--headless"); 
        options.addArguments("--window-size=1920,1080");


        driver = new FirefoxDriver(options);
    }

    @Test
    public void testMozillaPageTitle() {
  
            // Vamos a probar con la página de Mozilla esta vez
            driver.get("https://www.mozilla.org");
            String pageTitle = driver.getTitle();
            System.out.println("El título de la página es: " + pageTitle);
            assertTrue(pageTitle.contains("Mozilla"));
   
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
