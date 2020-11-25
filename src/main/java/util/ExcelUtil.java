package util;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

//仅支持.xls格式
public class ExcelUtil {

    @Test
    public void Excel(){
        try {
            //载入文件流
            jxl.Workbook workbook = null;
            InputStream is = new FileInputStream("/Users/eillence/Downloads/工作簿2.xls");
            workbook = Workbook.getWorkbook(is);

            int sheetSize = workbook.getNumberOfSheets();
            //通过索引或者名称获取Sheet
            Sheet sheet = workbook.getSheet(0);
            //通过行号获取Cell
            int row_total = sheet.getRows();
            for (int i = 0; i < row_total; i++) {
                if(i == 0){
                    Cell[] cells = sheet.getRow(i);
                    System.out.println(cells[0].getContents());
                    System.out.println(cells[1].getContents());
                    System.out.println(cells[2].getContents());
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }catch (BiffException e){
            e.printStackTrace();
        }
    }

}
