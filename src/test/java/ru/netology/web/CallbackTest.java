package ru.netology;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CallbackTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:9999");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void TestV1SeleniumCorrectForm1() {
        WebElement form = driver.findElement(By.cssSelector("[class= App_appContainer__3jRx1]"));
        form.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Василий Крепышев");
        form.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79270000000");
        form.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        form.findElement(By.cssSelector("[class= button__text]")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.!";
        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();
    }

    @Test
    void TestV2SeleniumCorrectForm2() {
        WebElement form = driver.findElement(By.cssSelector("[class= App_appContainer__3jRx1]"));
        form.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Крепышев-Турчинский Василий");
        form.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79270000000");
        form.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        form.findElement(By.cssSelector("[class= button__text]")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.!";
        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();
    }

   @Test
    void TestV2SeleniumCorrectForm3() {
        WebElement form = driver.findElement(By.cssSelector("[class= App_appContainer__3jRx1]"));
        form.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Крепышев Турчинский Василий");
        form.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79270000000");
        form.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        form.findElement(By.cssSelector("[class= button__text]")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.!";
        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();
    }
    @Test
    void TestV2SeleniumCorrectForm4() {
        WebElement form = driver.findElement(By.cssSelector("[class= App_appContainer__3jRx1]"));
        form.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Крепышев Василий-Иосиф");
        form.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79270000004");
        form.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        form.findElement(By.cssSelector("[class= button__text]")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.!";
        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();
    }
}