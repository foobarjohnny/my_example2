package org.daragon.miscellany.excel;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LeaveSingle {
	public static void main(String[] args) throws BiffException, IOException {
		Workbook workbook = Workbook.getWorkbook(new File("myfile.xls"));
		Sheet sheet = workbook.getSheet(0);
		
	}
}
