import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;


public class SberTest {

    By searchField = By.name("q");
    By searchButton = By.name("btnK");
    By searchOption = By.xpath("//li[@role = \"presentation\"]");
    By firstResult = By.xpath("//h3[contains(text(), \"СберЛизинг — официальный сайт лизинговой компании\")]");
    By closeCallRequestWindow = By.xpath("//svg[@class=\"comagic-call-generator__close-btn__icon\"]");
    By closePromoWindow = By.xpath("//i[@class=\"popup-dialog__icon-close\"]");
    By closeCookiesWindow = By.xpath("//div[@class=\"container cookie-warning\"]//button");
    By carFilterButton = By.xpath("//div[@class=\"d-none d-xl-block text-right\"]");
    String city = "Москва";
    String manufacturer = "Volkswagen";
    String model = "Polo";
    By cityField = By.xpath("//span[contains(text(), \"Город\")]");
    By manufacturerField = By.xpath("//span[contains(text(), \"Марка\")]");
    By modelField = By.xpath("//span[contains(text(), \"Модель\")]");
    By cityFieldOption = By.xpath(String.format("//label[contains(text(), \"%s\")]", city));
    By manufacturerFieldOption = By.xpath(String.format("//label[contains(text(), \"%s\")]", manufacturer));
    By modelFieldOption = By.xpath(String.format("//label[contains(text(), \"%s\")]", model));
    By applyFilter = By.xpath("//a[contains(text(), \"Показать все предложения\")]");
    By applyFilter1 = By.linkText("Показать все предложения");
    By searchResults = By.xpath("//div[@class=\"fw-600 fs-16\"]");

    @Test
    public void searchSberLisingInGoogle() {
        System.setProperty("webdriver.chrome.driver","E:\\Drivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.findElement(searchField).sendKeys("СберЛизинг");
        driver.findElement(searchButton).click();
        driver.findElement(firstResult).click();
        //driver.findElement(closeCallRequestWindow).click();
        //driver.findElement(closePromoWindow);
        driver.findElement(carFilterButton).click();
        driver.findElement(cityField).click();
        driver.findElement(cityFieldOption).click();
        driver.findElement(manufacturerField).click();
        driver.findElement(manufacturerFieldOption).click();
        driver.findElement(modelField).click();
        driver.findElement(modelFieldOption).click();
        driver.findElement(closeCookiesWindow).click();
        driver.findElement(applyFilter1).click();

        //Сравнение результатов
        String firstResult = driver.findElement(searchResults).getText();

        Assert.assertEquals("Volkswagen Polo", firstResult);


        driver.quit();

    }

}
