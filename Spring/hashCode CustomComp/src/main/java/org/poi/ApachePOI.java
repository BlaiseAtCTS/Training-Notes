package org.poi;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ApachePOI {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/org/poi/excel.xlsx");
//        file.createNewFile();
        FileInputStream fis = new FileInputStream(file);
//        FileOutputStream fos = new FileOutputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        XSSFSheet sheet = workbook.createSheet("Sheet1");
//        XSSFRow headerRow = sheet.createRow(0);
//        headerRow.createCell(0).setCellValue("ID");
//        headerRow.createCell(1).setCellValue("NAME");
//        XSSFRow row = sheet.createRow(1);
//        row.createCell(0).setCellValue(1);
//        row.createCell(1).setCellValue("Adam");
//        workbook.write(fos);
//        fos.close();

        XSSFSheet sheet = workbook.getSheet("Sheet1");
        System.out.println(sheet.getLastRowNum());
        XSSFRow row = sheet.getRow(0);
        System.out.println(row.getLastCellNum());
        DataFormatter dataFormatter = new DataFormatter();
        for(int i=0; i<=sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            for(int j=0; j<row.getLastCellNum(); j++) {
                System.out.print(dataFormatter.formatCellValue(row.getCell(j))+" ");
            }
            System.out.println();
        }

        workbook.close();
        fis.close();
    }
}
