package com.pmfby.utility;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class DataTable {

    public static String fileName = System.getProperty("user.dir")+"PMFBY.xlsx";
    public String path;
    public static String fileRoot = System.getProperty("user.dir")+"\\TestData\\";
    private FileInputStream fis;
    private FileOutputStream fos;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private XSSFRow row;
    private XSSFCell cell;
    private ArrayList<Object> dynamicData;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-YYYY");

    public DataTable(String filePath){
        this.path = fileRoot + filePath;
        try{
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            fis.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public int getRowCount(String sheetName){
        int index = workbook.getSheetIndex(sheetName);
        if(index == -1)
            return 0;
        else {
            workbook.getSheetAt(index);
            int number = sheet.getLastRowNum()+1;
            return number;
        }
    }


    public String getCellDataValue(String sheetName, String colName, int rowNum){
       try{
           if(rowNum<=0)
               return "";

           int index = workbook.getSheetIndex(sheetName);
           int col_num = -1;
           if(index==-1)
               return "";

           sheet = workbook.getSheetAt(index);
           row = sheet.getRow(0);
           for(int i =0; i < row.getLastCellNum(); i++){
               if(row.getCell(i).getStringCellValue().trim().equals(colName.trim())){
                   col_num = i;
               }
           }
           if(col_num == -1)
               return "";

           sheet = workbook.getSheetAt(index);
           row = sheet.getRow(rowNum - 1);
           if(row==null)
               return "";

           cell = row.getCell(col_num);
           if(cell==null)
               return "";

           if(cell.getCellType() == CellType.STRING)
               return cell.getStringCellValue();
           else if(cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA){
               String cellText = String.valueOf(cell.getNumericCellValue());
               if(HSSFDateUtil.isCellDateFormatted(cell)){
                   double d = cell.getNumericCellValue();

                   Calendar calendar = Calendar.getInstance();
                   calendar.setTime(HSSFDateUtil.getJavaDate(d));
                   cellText = (String.valueOf(calendar.get(Calendar.YEAR))).substring(2);
                   cellText = calendar.get(Calendar.DAY_OF_MONTH) + "/" + calendar.get(Calendar.MONTH) + 1 + "/" + cellText;
                   System.out.println(cellText);
               }
               return cellText;
           }
           else if(cell.getCellType() == CellType.BLANK)
               return "";
           else
               return String.valueOf(cell.getBooleanCellValue());
       }
       catch (Exception e){
           e.printStackTrace();
           return "Row " +rowNum+ " or Column " +colName+ " doesn't exist";
       }
    }


    public String getCellData(String sheetName, int rowNum, int colNum){
        try{
            if(rowNum <= 0)
                return "";
            workbook.getSheet(sheetName);
            int index = workbook.getSheetIndex(sheetName);
            if(index == -1)
                return "";

            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(rowNum - 1);
            if(row == null)
                return null;
            cell = row.getCell(colNum);
            if(cell == null)
                return "";

            if(cell.getCellType() == CellType.STRING)
                return cell.getStringCellValue();
            else if(cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA){
                String cellText = String.valueOf(cell.getNumericCellValue());
                if(HSSFDateUtil.isCellDateFormatted(cell)){
                    double d = cell.getNumericCellValue();

                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(HSSFDateUtil.getJavaDate(d));
                    cellText = (String.valueOf(calendar.get(Calendar.YEAR))).substring(2);
                    cellText = calendar.get(Calendar.DAY_OF_MONTH) + "/" + calendar.get(Calendar.MONTH) + 1 + "/" + cellText;
                }
                return cellText;
            }
            else if(cell.getCellType() == CellType.BLANK)
                return "";
            else
                return String.valueOf(cell.getBooleanCellValue());
        }
        catch (Exception e){
            e.printStackTrace();
            return "Row " + rowNum + " or column " + colNum + " doesn't exist";
        }
    }


    public List<Integer> getRowNums(String sheetName, String colName, String cellValue){
        List<Integer> noOfRows = new ArrayList<Integer>();
        for(int i=2; i<=getRowCount(sheetName); i++){
            if(getCellDataValue(sheetName, colName, i).equalsIgnoreCase(cellValue))
                noOfRows.add(i);
        }
        return noOfRows;
    }


    public int getCellRowNumber(String sheetName, String colName, String cellValue){
        for(int i=2; i<=getRowCount(sheetName); i++){
            if(getCellDataValue(sheetName, colName, i).equalsIgnoreCase(cellValue))
                return i;
        }
        return -1;
    }


    public ArrayList<Object> getRowData(String sheetName, String colName, String cellValue, int length){
        try{
            List<Integer> rowInfo = getRowNums(sheetName, colName, cellValue);
            dynamicData = new ArrayList<>();
            int rowNums = rowInfo.size();
            for(int i = 0; i < rowNums; i++){
                row = sheet.getRow(rowInfo.get(i) - 1);
                Object[] cellData = new Object[length];
                int cellCount = 0;
                if(row == null)
                    return null;
                Iterator<Cell> cellIterator = row.cellIterator();
                cellIterator.next();
                while(cellIterator.hasNext() && cellCount < length){
                    cell = (XSSFCell) cellIterator.next();
                    if(cell == null)
                        cellData[cellCount] = "";
                    if(cell.getCellType() == CellType.STRING)
                        cellData[cellCount] = cell.getStringCellValue();
                    if(cell.getCellType() == CellType.NUMERIC)
                        cellData[cellCount] = String.valueOf(cell.getNumericCellValue());
                    if(cell.getCellType() == CellType.FORMULA)
                        cellData[cellCount] = sdf.format(cell.getDateCellValue().toString());
                    if(cell.getCellType() == CellType.BLANK)
                        cellData[cellCount] = "";
                }
                dynamicData.add(cellData);
                cellData = null;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return dynamicData;
    }


    public boolean setCellData(String sheetName, String colName, int rowNum, String data){
        try{
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            if(rowNum < 1)
                return false;

            int index = workbook.getSheetIndex(sheetName);
            int colNum = -1;
            if(index ==  -1)
                return false;

            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(0);
            for(int i=0; i<row.getLastCellNum(); i++){
                if(row.getCell(i).getStringCellValue().trim().equals(colName))
                    colNum = i;
            }

            if(colNum == -1)
                return false;

            sheet.autoSizeColumn(colNum);
            row = sheet.getRow(rowNum-1);
            if(row == null)
                row = sheet.createRow(rowNum-1);

            cell = row.getCell(colNum);
            if(cell == null)
                cell = row.getCell(colNum);

            cell.setCellValue(data);
            fos = new FileOutputStream(path);
            workbook.write(fos);
            fos.flush();
            fos.close();
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean setCellData(String sheetName, String colName, int rowNum, String data, String url){
        try{
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);

            if(rowNum <= 0)
                return false;

            int index = workbook.getSheetIndex(sheetName);
            int colNum = -1;
            if(index == -1)
                return false;

            row = sheet.getRow(0);
            for(int i=0; i<row.getLastCellNum(); i++){
                if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName))
                    colNum = i;
            }

            if(colNum == -1)
                return false;
            sheet.autoSizeColumn(colNum);
            row = sheet.getRow(rowNum-1);
            if(row == null)
                row = sheet.createRow(rowNum-1);

            cell = row.getCell(colNum);
            if(cell == null)
                cell = row.getCell(colNum);

            cell.setCellValue(data);
            XSSFCreationHelper creationHelper = workbook.getCreationHelper();
            CellStyle hlink_style = workbook.createCellStyle();
            XSSFFont hlink_font = workbook.createFont();
            hlink_font.setUnderline(XSSFFont.U_SINGLE);
            hlink_font.setColor(IndexedColors.BLUE.getIndex());
            hlink_style.setFont(hlink_font);

            XSSFHyperlink link = creationHelper.createHyperlink(HyperlinkType.FILE);
            link.setAddress(url);
            cell.setHyperlink(link);
            cell.setCellStyle(hlink_style);

            fos = new FileOutputStream(path);
            workbook.write(fos);
            fos.flush();
            fos.close();
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean addSheet(String sheetName){
        FileOutputStream fileOut;
        try{
            workbook.createSheet(sheetName);
            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean removeSheet(String sheetName){
        int index = workbook.getSheetIndex(sheetName);
        if(index == -1)
            return false;

        FileOutputStream fileOut;
        try{
            workbook.removeSheetAt(index);
            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean addColumn(String sheetName, String colName){
        try{
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            int index = workbook.getSheetIndex(sheetName);
            if(index == -1)
                return false;

            XSSFCellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREY_40_PERCENT.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(0);
            if(row == null)
                row = sheet.createRow(0);

            if(row.getLastCellNum() == -1)
                cell = row.createCell(0);
            else
                cell = row.createCell(row.getLastCellNum());

            cell.setCellValue(colName);
            cell.setCellStyle(style);
            fos = new FileOutputStream(path);
            workbook.write(fos);
            fos.flush();
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }


    //vikas.dubey@proptiger.com


    public boolean isSheetExist(String sheetName){
        int index = workbook.getSheetIndex(sheetName);
        if(index == -1){
            index = workbook.getSheetIndex(sheetName.toUpperCase());
            if(index == -1)
                return false;
            else
                return true;
        }
        else
            return true;
    }


    public boolean removeColumn(String sheetName, int colNum){
        try{
            if(!isSheetExist(sheetName))
                return false;
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
            XSSFCellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREY_40_PERCENT.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            for(int i=0; i<getRowCount(sheetName); i++){
                row = sheet.getRow(i);
                if(row != null){
                    cell = row.getCell(colNum);
                    if(cell != null){
                        cell.setCellStyle(style);
                        row.removeCell(cell);
                    }
                }
            }

            fos = new FileOutputStream(path);
            workbook.write(fos);
            fos.flush();
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public int getColumnCount(String sheetName){
        if(!isSheetExist(sheetName))
            return -1;

        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(0);

        if(row == null)
            return -1;

        return row.getLastCellNum();
    }


    public int getCellRowNum(String sheetName, String colName, String cellValue){
        for(int i =2; i <= getRowCount(sheetName); i++){
            if(getCellDataValue(sheetName, colName, i).equalsIgnoreCase(cellValue)){
                return i;
            }
        }
        return -1;
    }
}
