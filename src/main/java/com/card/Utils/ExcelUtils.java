package com.card.Utils;


import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Administrator\\Desktop\\student.xlsx";
        Workbook workbook= null;
        workbook=getWorkbook(filePath);
        List<Sheet> sheets = getSheets(workbook);
        for (Sheet sheet:sheets) {
            List<List<String>> excelValues = getExcelValues(sheet, -1, -1);
            for (List<String> listStr:excelValues) {
                for (String string:listStr){
                    System.out.print(string+" ");
                }
                System.out.println();
            }
        }
//        XSSFSheet sheet=null;
//        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {//获取每个Sheet表
//            sheet=workbook.getSheetAt(i);
//            for (int j = 0; j <sheet.getLastRowNum(); j++) {//获取每行
//                XSSFRow row=sheet.getRow(j);
//                if(null==row){
//                    System.out.println("空行");
//                }else {
//                    for (int k = 0; k < row.getLastCellNum(); k++) {//获取每个单元格
//                        System.out.print(row.getCell(k)+"\t");
//                    }
//                }
//                System.out.println("---Sheet表"+i+"处理完毕---");
//            }
//            System.out.println("rownum:"+sheet.getLastRowNum());
//        }
//        Sheet sheet = getSheet(workbook, "学生表");
//        System.out.println(sheet.getSheetName());
//        List<Sheet> sheets = getSheets(workbook);
//        for (Sheet sheet1:sheets) {
//            System.out.println(sheet1);
//        }

    }



    /**
     * 生成EXcel表
     * @param filePath
     * @return
     */
    private static Workbook getWorkbook(String filePath) {
        Workbook wb = null;
        if (filePath==null)return null;
        String fileString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is=null;
        try {
            is=new FileInputStream(filePath);
            if(".xls".equals(fileString)){
                return wb=new HSSFWorkbook(is);
            }else if(".xlsx".equals(fileString)){
                return wb=new XSSFWorkbook(is);
            }else{
                return wb = null;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }
    /**
     * 根据表的名字获取表
     * @param wb
     * @param sheetName
     * @return
     */
    public static Sheet getSheet(Workbook wb, String sheetName) {
        if (wb == null) {
            throw new RuntimeException("工作簿对象为空");
        }
        int sheetSize = wb.getNumberOfSheets();
        int count=0;
        for (int i = 0; i <sheetSize ; i++) {
            if(sheetName.equals(wb.getSheetAt(i).getSheetName())){
                count++;
            }
        }
        if (count==0) {
            throw new RuntimeException("工作表获取错误");
        }
        return wb.getSheet(sheetName);
    }
    /**
     * 获取所有的sheet
     * @param wb
     * @return
     */
    public static List<Sheet> getSheets(Workbook wb){
        List<Sheet> sheets=new ArrayList<>();
        if (wb == null) {
            throw new RuntimeException("工作簿对象为空");
        }
        int numberOfSheets = wb.getNumberOfSheets();
        for (int i = 0; i < numberOfSheets; i++) {
            sheets.add(wb.getSheetAt(i));
        }
        return sheets;
    }
    //获取所有的row，cell的数据
    public static List<List<String>> getExcelValues(Sheet sheet, int startLine, int endLine) {
        List<List<String>> list = new ArrayList<List<String>>();
        // 如果开始行号和结束行号都是-1的话，则全表读取
        if (startLine == -1)
            startLine = 0;
        if (endLine == -1) {
            endLine = sheet.getLastRowNum() + 1;
        } else {
            endLine += 1;
        }
        for (int i = startLine; i < endLine; i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
//                System.out.println("该行为空，直接跳过");
                continue;
            }
            int lastCellNum = row.getLastCellNum();
            List<String> rowList = new ArrayList<String>();
            for (int j = 0; j < lastCellNum; j++) {
                Cell cell = row.getCell(j);
                String temp = getCellValue(cell);
                rowList.add(temp);
            }
            list.add(rowList);
        }
        return list;
    }

    /**
     * 取单元格各类型值，返回字符串类型
     * @param cell
     * @return
     */
    public static String getCellValue(Cell cell){
    //判断是否为null或空串
    if (cell==null || cell.toString().trim().equals("")) {
        return "";
    }
    String cellValue = "";
    int cellType=cell.getCellType();
    switch (cellType) {
        case Cell.CELL_TYPE_NUMERIC: // 数字
            short format = cell.getCellStyle().getDataFormat();
            if (DateUtil.isCellDateFormatted(cell)) {
                SimpleDateFormat sdf = null;
                //System.out.println("cell.getCellStyle().getDataFormat()="+cell.getCellStyle().getDataFormat());
                if (format == 20 || format == 32) {
                    sdf = new SimpleDateFormat("HH:mm");
                } else if (format == 14 || format == 31 || format == 57 || format == 58) {
                    // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
                    sdf = new SimpleDateFormat("yyyy/MM/dd");
                    double value = cell.getNumericCellValue();
                    Date date = org.apache.poi.ss.usermodel.DateUtil
                            .getJavaDate(value);
                    cellValue = sdf.format(date);
                }else {// 日期
                    sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                }
                try {
                    cellValue = sdf.format(cell.getDateCellValue());// 日期
                } catch (Exception e) {
                    try {
                        throw new Exception("exception on get date data !".concat(e.toString()));
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }finally{
                    sdf = null;
                }
            }  else {
                BigDecimal bd = new BigDecimal(cell.getNumericCellValue());
                bd.setScale(2,BigDecimal.ROUND_HALF_UP);
                cellValue = bd.toPlainString();// 数值 这种用BigDecimal包装再获取plainString，可以防止获取到科学计数值
            }
            break;
        case Cell.CELL_TYPE_STRING: // 字符串
            cellValue = cell.getStringCellValue();
            break;
        case Cell.CELL_TYPE_BOOLEAN: // Boolean
            cellValue = cell.getBooleanCellValue()+"";;
            break;
        case Cell.CELL_TYPE_FORMULA: // 公式
            cellValue = cell.getCellFormula();
            break;
        case Cell.CELL_TYPE_BLANK: // 空值
            cellValue = "";
            break;
        case Cell.CELL_TYPE_ERROR: // 故障
            cellValue = "ERROR VALUE";
            break;
        default:
            cellValue = "UNKNOW VALUE";
            break;
    }
    return cellValue;
}


}
