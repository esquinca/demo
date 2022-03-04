package com.example.exercises;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.time.LocalDateTime;

public class LogDuration {

	public static void main(String[] args) {
		
		File f = new File("/Users/esquinca/Documents/log_exercisex.xlsx");
		
		List<String> dates= new ArrayList<>();
		InputStream inp;
		try {
			inp = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(inp);
			Sheet sh = wb.getSheetAt(0);
			int iRow = 1;
			Row row = sh.getRow(iRow);
			while (row != null) {
				Cell cell = row.getCell(2);
				// System.out.println(cell.getStringCellValue());
				// formatter6.parse(cell.getStringCellValue());
				dates.add(cell.getStringCellValue());
				iRow++;
				row = sh.getRow(iRow);
			}
	
			dates.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			.entrySet()
			.stream()
			.max(Map.Entry.comparingByValue())
			.ifPresent(x->System.out.println(x));
			
			



		} catch ( IOException e) {
			e.printStackTrace();
		}
	}

}
