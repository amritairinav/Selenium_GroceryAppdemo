package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;

public class ExcelUtility {

	static FileInputStream f;// in built class to read details from file
	static XSSFWorkbook wb;// in built class to read details from work book
	static XSSFSheet sh;// in built class to read details from sheet
	// all are static method and globally declared---return type parameters a=row
	// value,b=cellvalue

	public static String getStringdata(int a, int b, String sheet) throws IOException {
		String filepath = Constant.TESTDATA;
		f = new FileInputStream(filepath);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);// get details from sheet--->getsheet
		XSSFRow r = sh.getRow(a);// get details from row
		if (r == null) {
			return "";
		}
		XSSFCell c = r.getCell(b); // get details from cell
		if (c == null) {
			return "";
		}

		return c.getStringCellValue();// get details from cell--->string value
	}

	public static String getIntegerdata(int a, int b, String sheet) throws IOException {
		String filepath = Constant.TESTDATA;
		f = new FileInputStream(filepath);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		XSSFRow r = sh.getRow(a);
		XSSFCell c = r.getCell(b);
		int n = (int) c.getNumericCellValue();// to get numeric cell value(int)-->typecasting
		return String.valueOf(n);// to convert any data type to print--->type conversion

	}

}
