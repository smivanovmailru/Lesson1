package lesson4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Guinness {
    @Test

    public void openningWebSite() {
        // Инициализация WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Создание экземпляра WebDriver
        WebDriver driver = new ChromeDriver();

        // Открытие веб-страницы
        driver.get("https://www.guinnessworldrecords.com/account/register?");
        Actions actions  = new Actions(driver);

        // Поиск поля Last Name
        WebElement lastName = driver.findElement(By.id(":r0:"));

        // Ввод Last Name в поле
        lastName.sendKeys("Ivanou");

        // Поиск поля First Name
        WebElement firstName = driver.findElement(By.id(":r1:"));

        // Ввод Last Name в поле
        firstName.sendKeys("Siarhei");

        //Поиск поля даты рождения
        WebElement dateOfBirth = driver.findElement(By.className("dob-picker"));
        actions.keyDown(Keys.TAB).build().perform();
        dateOfBirth.sendKeys("06/08/1986");
        actions.keyUp(Keys.TAB).build().perform();

        //Выбор страны из дропдауна
        WebElement elementCountries = driver.findElement(By.className("MuiSvgIcon-root"));
        actions.click(elementCountries).build().perform();
        WebElement belarus = driver.findElement(By.xpath("//*[@id=\":r3:\"]/li[26]")); //<------ переписать путь к стране!!Иногда выбирает не то, что требуется
        actions.click(belarus).build().perform();

        //Выбор округа/штата
        WebElement countyState = driver.findElement(By.name("countyState"));
        countyState.sendKeys("Vitebsk");

        //Ввод имейл
        WebElement email = driver.findElement(By.id(":r5:"));
        email.sendKeys("smivanov@mail.ru");

        //Дублируем имейд
        WebElement confirmEmail = driver.findElement(By.id(":r6:"));
        confirmEmail.sendKeys("smivanov@mail.ru");

        //Вставляем пароль
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Qwerty123");

        //Дублируем повторно с ошибкой
        WebElement confirmPassword = driver.findElement(By.name("confirmPassword"));
        confirmPassword.sendKeys("Ytrewq123");

        //Отметка на чекбоксе Имейл
        WebElement checkboxEmail = driver.findElement(By.className("MuiTypography-root"));
        actions.click(checkboxEmail).build().perform();
        WebElement fieldtncRegister = driver.findElement(By.name("tnc"));
        actions.click(fieldtncRegister).build().perform();

        //работа с iframe
      WebElement frame1 = driver.findElement(By.xpath("//*[@id=\"register\"]/div/div/div/form/div[6]/div/div/div/div/div/iframe"));
        driver.switchTo().frame(frame1);
        WebElement button = driver.findElement(By.className("rc-anchor-center-item"));
        actions.click(button).build().perform();
        driver.switchTo().defaultContent();

        //нажать на кнопку "создать акк"
        //WebElement createAcc = driver.findElement(By.xpath("//span[text()='Create your account']"));
        WebElement createAcc = driver.findElement(By.id(":r9:"));
        actions.click(createAcc).build().perform();
        System.out.println();

        }


              //  driver.quit();
        }



