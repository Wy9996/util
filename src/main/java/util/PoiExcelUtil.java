package util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pom.ExcelPeople;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//通过poi获取excel中的数据
public class PoiExcelUtil {
    public static void main(String[] args) throws IOException {
        //获取工作簿
        XSSFWorkbook workbook = new XSSFWorkbook("/Users/eillence/Downloads/工作簿3.xlsx");
        //获取工作表
        XSSFSheet sheet = workbook.getSheetAt(0);
        //第一种读取读取所有数据，实际中不需要
        //获取行
//        for (Row cells : sheet) {
//            //获取单元格
//            for (Cell cell : cells) {
//                //获取单元格中的内容
//                cell.setCellType(CellType.STRING);
//                System.out.println(cell.getStringCellValue());
//            }
//    }
        List<ExcelPeople> peopleList = new ArrayList<>();
        //普通for循环
        //开始索引0 结束索引
        int lastRowNum = sheet.getLastRowNum();
        System.out.println("最后一行："+lastRowNum);
        for (int i = 1; i < lastRowNum; i++) {
            //获取单元格
            XSSFRow row = sheet.getRow(i);
            if (row!=null){
                List<String> list = new ArrayList<>();
                for(Cell cell : row){
                    if (cell!=null && !"".equals(cell)){
                        //此处是吧单元格转换为String
                        cell.setCellType(CellType.STRING);
                        String cellValue = cell.getStringCellValue();
                        System.out.println("单元格数据："+cellValue);
                        list.add(cellValue);
                    }
                }
                if (list.size()>0){
                    ExcelPeople people = new ExcelPeople(list.get(0), list.get(1), list.get(2), list.get(3));
                    peopleList.add(people);
                }
            }
        }
        for (ExcelPeople people : peopleList){
            System.out.println(people);
        }
        //释放资源
        workbook.close();
    }
}
