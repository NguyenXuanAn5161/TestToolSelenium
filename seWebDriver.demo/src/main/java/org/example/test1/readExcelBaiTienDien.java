package org.example.test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcelBaiTienDien {
//	public static void main(String[] args) throws IOException {
//		final String excelPath = "excel\\testCaseTienDien.xlsx";
//		final List<TienDien> listTienDiens = readExcel(excelPath);
//		for (TienDien td : listTienDiens) {
//			System.out.println(td);
//		}
//	}

	protected static List<TienDien> readExcel(String excelPath) throws IOException {
		List<TienDien> tienDiens = new ArrayList<>();

//		get file
		FileInputStream ipStream = new FileInputStream(new File(excelPath));

//		get workbook
		XSSFWorkbook wb = new XSSFWorkbook(ipStream);

//		get sheet theo ten
		XSSFSheet sheetBai08 = wb.getSheet("Bai08");

//		get all rows from row 19
		Iterator<Row> iterator = sheetBai08.iterator();
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			if (nextRow.getRowNum() < 18) {
				continue;
			}
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			TienDien tienDien = new TienDien();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				if (cell.getColumnIndex() >= 1 && cell.getColumnIndex() <= 3) {
					int celIndex = cell.getColumnIndex();
					switch (celIndex) {
					case 1:
						tienDien.setId((int) cell.getNumericCellValue());
						break;
					case 2:
						tienDien.setChiSoCu((int) cell.getNumericCellValue());
						break;
					default:
						tienDien.setChiSoMoi((int) cell.getNumericCellValue());
						break;
					}
				}
			}
			tienDiens.add(tienDien);
		}
		ipStream.close();
		return tienDiens;
	}

}
