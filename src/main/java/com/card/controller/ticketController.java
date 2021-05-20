package com.card.controller;


import com.card.entity.Cardticket;
import com.card.service.TicketService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.List;

@Controller
public class ticketController {

    @Autowired
    private TicketService ticketService;


    @ResponseBody
//    @RequestMapping("/ticket")
    public Cardticket addTicket(Cardticket ticket){
        ticket.setTicketDescribe("会不会和乱码");
        System.out.println(ticket);
//        System.out.println(new String(tyticketpe.getBytes("8859_1"),"utf-8"));
        System.out.println("您栽柑硒鼓地要");
        return  ticket;
    }

    @ResponseBody
    @RequestMapping("/ticket")
    public void insert(Cardticket cardticket){
        ticketService.insert(cardticket);
        System.out.println("ticketController中的  :" + cardticket);
    }

    //读写EXCEL
    public static void main(String[] args) {
        //遍历map
        Map<String,String> map=new HashMap<>();
        map.put("name","小明");
        map.put("age","18");
        map.put("addr","广州");
        //取出对应的 key，value 键值对,容量大时推荐使用
        for (Map.Entry<String,String> entry:map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        //获取所有的 key，根据 key 取出对应的value
        for (String key : map.keySet()) {
            System.out.println("key:"+key+",value:"+map.get(key));
        }
        //获取map种所有的value：map.values()
        for (String value : map.values()) {
            System.out.println("value:" + value);
        }
        //通过 Map.entrySet使用iterator遍历 key 和 value
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }
        System.out.println("-------------------- map.forEach JDK1.8 新特性 ----------------------");
       // map.forEach JDK1.8 新特性
        map.forEach((key, value) -> {
            System.out.println("key=" + key + ",value=" + value);
        });
        //java新特性
        map.forEach((key,value)->{
            System.out.println(key);
        });

        System.out.println("+++++++++++++++++++++++++++++++++++测试excel++++++++++++++++++++++++++++");

        Workbook wb=null;
        Sheet sheet=null;
        Row row=null;
        List<Map<String,String>> list=null;
        String cellData=null;
//        String filePath = "D:\\test.xlsx";‪
        String filePath = "C:\\Users\\Administrator\\Desktop\\student.xlsx";
        //Excel第一行的标题
        String columns[] = {"name","age","address","tel"};
        wb = readExcel(filePath);
        if (wb!=null) {

            //获取第一个sheet
            //sheet = wb.getSheetAt(0);
//            sheet= wb.getSheet("学生表");
//            System.out.println("sheet是:"+sheet);
            int numberOfSheets = wb.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                //用来存放表中数据
                list=new ArrayList<Map<String,String>>();
                sheet=wb.getSheetAt(i);
                //获取最大行数
                int rowsNum = sheet.getPhysicalNumberOfRows();
                //获取第一行
                row=sheet.getRow(0);
                //获取最大列数
                int cloNum=row.getPhysicalNumberOfCells();
                for (int c = 1; c <rowsNum; c++) {
                    Map<String,String> map1=new LinkedHashMap<>();
                    row=sheet.getRow(c);
                    if (row != null) {
                        for (int j = 0; j < cloNum; j++) {
                            cellData = (String) getCellFormatValue(row.getCell(j));
                            map1.put(columns[j],cellData);
                        }
                    }else {
                        break;
                    }
                    list.add(map1);
                }
                System.out.println(sheet.getSheetName()+"表的数据");
                //遍历解析出来的list
                for (Map<String,String> map2 : list) {
                    for (Map.Entry<String,String> entry : map2.entrySet()) {
                        System.out.print(entry.getKey()+":"+entry.getValue()+",");
                    }
                    System.out.println();
                }
            }
        }
    }
    //获取表格中的数据
    private static Object getCellFormatValue(Cell cell) {
        Object cellValue = null;
        if (cell != null) {
            //判断cell类型
            switch (cell.getCellType()){
                case Cell.CELL_TYPE_NUMERIC:{
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    break;
                }
                case Cell.CELL_TYPE_FORMULA:{
                    //判断cell是否为日期格式
                    if(DateUtil.isCellDateFormatted(cell)){
                        //转换为日期格式YYYY-mm-dd
                        cellValue = cell.getDateCellValue();
                    }else{
                        //数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case Cell.CELL_TYPE_STRING:{
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default:
                    cellValue = "";
            }
        }else {
            cellValue="";
        }

        return cellValue;
    }

    //生成EXcel表
    private static Workbook readExcel(String filePath) {
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




}
