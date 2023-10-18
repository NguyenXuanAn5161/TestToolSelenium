package org.example.test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writeExcelBaiTienDien {
//	public static void main(String[] args) throws IOException {
//		final String excelPath = "excel\\testCaseTienDien.xlsx";
//		final List<TienDien> listTienDiens = readExcel(excelPath);
//		for (TienDien td : listTienDiens) {
//			System.out.println(td);
//		}
//	}

	protected static void writeExcel(List<TienDien> tienDiens, String excelPath) throws IOException {
//		get file
		FileInputStream ipStream = new FileInputStream(new File(excelPath));

//		get workbook
		XSSFWorkbook wb = new XSSFWorkbook(ipStream);

//		get sheet theo ten
		XSSFSheet sheetBai08 = wb.getSheet("Bai08");

		int rowIndex = 18;
		// Write data
		for (TienDien td : tienDiens) {
			XSSFRow row = sheetBai08.getRow(rowIndex);
			if (row == null)
				row = sheetBai08.createRow(rowIndex);
			writeTienDien(td, row);
			rowIndex++;
		}

		// Save the changes to the Excel file
		FileOutputStream fos = new FileOutputStream(new File(excelPath));
		wb.write(fos);
		fos.close();
	}

	private static void writeTienDien(TienDien td, XSSFRow row) {
		XSSFCell cell = row.createCell(6);
		cell.setCellValue(td.getThanhTien());
	}

}
