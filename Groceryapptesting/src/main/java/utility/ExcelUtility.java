package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;

public class ExcelUtility {

	public static String getStringdata(int rowIndex, int cellIndex, String sheetName) throws IOException {
		String filepath = Constant.TESTDATA;

		try (FileInputStream f = new FileInputStream(filepath); XSSFWorkbook wb = new XSSFWorkbook(f)) {

			XSSFSheet sh = wb.getSheet(sheetName);
			if (sh == null) {
				return "";
			}

			Row row = sh.getRow(rowIndex);
			if (row == null) {
				return "";
			}

			Cell cell = row.getCell(cellIndex);
			if (cell == null) {
				return "";
			}

			return cell.toString();
		}
	}

	public static String getIntegerdata(int rowIndex, int cellIndex, String sheetName) throws IOException {
		String filepath = Constant.TESTDATA;

		try (FileInputStream f = new FileInputStream(filepath); XSSFWorkbook wb = new XSSFWorkbook(f)) {

			XSSFSheet sh = wb.getSheet(sheetName);
			if (sh == null) {
				return "";
			}

			Row row = sh.getRow(rowIndex);
			if (row == null) {
				return "";
			}

			Cell cell = row.getCell(cellIndex);
			if (cell == null) {
				return "";
			}

			int value = (int) cell.getNumericCellValue();
			return String.valueOf(value);
		}
	}
}