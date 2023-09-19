package org.example.test1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class demo01 {
//    dữ liệu đầu vào như thế nào? giống test case như bữa giờ mình làm ở tiết thực hành?
//    test case: đăng nhập bao nhiêu lần?
//    vậy khi test thì cần thông báo đăng nhập thành công hay không ở đâu? Hay có thể chụp hình hay là xuất
//    ra màn hình console hay file excel hay file text?
    static WebDriver driver;
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.manage().window().maximize();

        driver.navigate().to("https://www.facebook.com/login/");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("100092972307998");

        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys("100077109912011");

        WebElement login = driver.findElement(By.id("loginbutton"));
        login.click();

//      thông báo khi đăng nhập công

        Thread.sleep(10000);
        driver.quit();
    }
}
