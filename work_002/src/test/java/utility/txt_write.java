package utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
//import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class txt_write extends Path{

	
	public static void txt_write_notepad(String name,String avai ,String details) throws Exception {
		
		//String path = "e:\\\\data.txt";				//notepad file path
		
		FileWriter fr=new FileWriter(notepad_path);
		BufferedWriter br=new BufferedWriter(fr);
		
		br.write("This is sample");
		br.newLine();
		
		br.write("\n Name : " + name + "\n Availability : " + avai + "\n Product Details : " + details);
		br.newLine();

		br.close();
	
		
	}
	
	
	public static void txt_write_excel(String name,String avai ,String details) throws Exception {
			
			//String path = "e:\\\\data.xlsx";				//excel file path
			String sheet_Name = "sheet1";						//name of the sheet
			
			File file = new File(excel_path);
			
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.createSheet(sheet_Name);
			
			sh.createRow(0).createCell(0).setCellValue("Product Name");
			sh.createRow(0).createCell(1).setCellValue("Product Details");
			sh.createRow(0).createCell(2).setCellValue("Product Availability");
		
			sh.createRow(1).createCell(0).setCellValue(name);
			sh.createRow(1).createCell(1).setCellValue(details);
			sh.createRow(1).createCell(2).setCellValue(avai);
			
			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);
			
			wb.close();
		}
	
	
}
