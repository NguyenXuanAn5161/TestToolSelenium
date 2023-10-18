package org.example.test1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo01 {
//    dữ liệu đầu vào như thế nào? giống test case như bữa giờ mình làm ở tiết thực hành?
//    test case: đăng nhập bao nhiêu lần?
//    vậy khi test thì cần thông báo đăng nhập thành công hay không ở đâu? Hay có thể chụp hình hay là xuất
//    ra màn hình console hay file excel hay file text?
	static WebDriver driver;
	private static List<TienDien> listTienDiens;

	public static void main(String[] args) throws Exception {
    	
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.manage().window().maximize();

        driver.navigate().to("http://127.0.0.1:5500/index.html");

        //read file .xlsx
        final String excelPath = "excel\\testCaseTienDien.xlsx";
		listTienDiens = readExcelBaiTienDien.readExcel(excelPath);

		//thuc hien test
		for(TienDien td : listTienDiens) {
			functionTinhTienDien(td);
		}

//        Thread.sleep(5000);
        driver.quit();
        
//        for(TienDien td : listTienDiens) {
//			System.out.println(td);
//		}
        
        writeExcelBaiTienDien.writeExcel(listTienDiens, excelPath);
    }

	private static void functionTinhTienDien(TienDien td) throws Exception {
		WebElement chiSoCu = driver.findElement(By.id("chiSoCu"));
		chiSoCu.clear();
		chiSoCu.sendKeys(td.getChiSoCu() + "");

		WebElement chiSoMoi = driver.findElement(By.id("chiSoMoi"));
		chiSoMoi.clear();
		chiSoMoi.sendKeys(td.getChiSoMoi() + "");

		WebElement btnTinhTienDien = driver.findElement(By.id("tinhTienDien"));
		btnTinhTienDien.click();

		WebElement thanhTien = driver.findElement(By.id("thanhtien"));
		double thanhTienDouble = Double.parseDouble(thanhTien.getText());
		td.setThanhTien(thanhTienDouble);

//		Thread.sleep(1000);

	}
}
