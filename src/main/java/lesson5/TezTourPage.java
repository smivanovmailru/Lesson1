package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class TezTourPage {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static By citySelect = By.id("cities");
    public static By countrySelect = By.id("countries");
    public static By startDate = By.xpath("//*[@id='dateRange-from']");
    public static By selectDays = By.id("nightsMin");

    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    static Actions actions = new Actions(driver);
    public static Set<String> windowHandles1;

    public static void openPage() {
        driver.get("https://www.teztour.by/");
        windowHandles1 = driver.getWindowHandles();
        System.out.println(windowHandles1);
        System.out.println("Название первой вкладки: " + driver.getTitle());
    }

    public static void selectVitebsk() {
        wait.until(ExpectedConditions.elementToBeClickable(citySelect)).click();
        new Select(driver.findElement(citySelect)).selectByValue("2548");
    }

    public static void selectTyrkey() {
        wait.until(ExpectedConditions.elementToBeClickable(countrySelect)).click();
        new Select(driver.findElement(countrySelect)).selectByValue("1104");
    }

    public static String tomorrowDate() {
        //вычисляем завтрашнюю дату
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return tomorrow.format(formatter);
    }

    public static void selectDate() {
        wait.until(ExpectedConditions.elementToBeClickable(startDate)).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(startDate)).clear();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(startDate)).sendKeys(tomorrowDate());
    }

    public static void days() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectDays));
        new Select(driver.findElement(selectDays)).selectByValue("10");
    }

    public static void Tourists() {
        WebElement quantityOfTourists = driver.findElement(By.id("tourSearchPassengers"));
        actions.click(quantityOfTourists).build().perform();
        WebElement addingTourist = driver.findElement(By.id("tourSearchAdults-plus"));
        actions.click(addingTourist).build().perform();
    }

    public static void clickingFindButton() {
        WebElement buttonFind = driver.findElement(By.id("ts-form-last-tr"));
        actions.click(buttonFind).build().perform();

        //тут нужен дескриптор окна. ОБРАТИ ВНИМАНИЕ НА ЭТО!!! ВОЗМОЖНО ТУТ РЕШЕНИЕ!
       /* System.out.println(driver.getWindowHandle() + "1");
        Set<String> windowHandles2 = driver.getWindowHandles();
        System.out.println(windowHandles2  + "2");//по идее должен получить 2 дескриптора*/
    }

    public static void switchToNewTab() {
        System.out.println(windowHandles1 + " - первый Set");
        Set<String> windowHandles2 = driver.getWindowHandles();
        System.out.println(windowHandles2 + " - второй Set");//здесь ошибка! здесь один дескриптор. должно быть два
        System.out.println("______");
        windowHandles2.removeAll(windowHandles1);
        System.out.println("______");
        String idOfSecondWindow = windowHandles2.iterator().next();//падает здесь!
        System.out.println("______");
        driver.switchTo().window(idOfSecondWindow);
        System.out.println("______");
        System.out.println("Текущее название вкладки: " + driver.getTitle());

        /*for (String windowHandle : windowHandles2) {
            if (!windowHandles1.equals(windowHandles2)) {
                driver.switchTo().window(windowHandle);
                break;*/
            }
        }








