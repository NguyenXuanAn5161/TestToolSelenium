package org.example.test1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo01 {
	static WebDriver driver;
	private static List<TienDien> listTienDiens;

	public static void main(String[] args) throws Exception {
		// Setup and configure the WebDriver
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// Configure timeouts and maximize the window
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.manage().window().maximize();

		// Navigate to a specific URL
		driver.navigate().to("http://localhost:5500/giaoDien/");

		// Read data from an Excel file
		final String excelPath = "excel\\testCaseTienDien.xlsx";
		listTienDiens = readExcelBaiTienDien.readExcel(excelPath);

		// Perform a test for a list of electricity bills
		for (TienDien td : listTienDiens) {
			functionTinhTienDien(td);
		}

//        Thread.sleep(5000);
		
		// Quit the WebDriver
		driver.quit();

		// Write data to an Excel file
		writeExcelBaiTienDien.writeExcel(listTienDiens, excelPath);
	}

	private static void functionTinhTienDien(TienDien td) throws Exception {
		// Find and interact with web elements
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

		// Sleep for 1 second (commented out)
//		Thread.sleep(1000);

	}
}
