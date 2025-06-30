package com.ejemplo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleFirefoxTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Cambio aquí: Usamos WebDriverManager para Firefox (geckodriver)
        WebDriverManager.firefoxdriver().setup();

        // Cambio aquí: Configuramos las opciones para Firefox
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless"); // Argumento para modo headless en Firefox
        //options.addArguments("--window-size=1920,1080");

        // Cambio aquí: Instanciamos FirefoxDriver
        driver = new FirefoxDriver(options);
    }

    @Test
    public void testMozillaPageTitle() {

        // Vamos a probar con la página de Mozilla esta vez
        driver.get("https://www.google.com");
        WebElement busqueda = driver.findElement(By.name("q")); // Aquí deberías encontrar el elemento de búsqueda
        busqueda.sendKeys("Selenium");
        busqueda.submit(); // Enviamos el formulario de búsqueda
        WebElement resultadoWebElement = driver.findElement(By.name("q"));
        String valor = resultadoWebElement.getAttribute("value");
        assertFalse(valor.contains("Selenium"), "El valor del campo de búsqueda no contiene 'Selenium'");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
