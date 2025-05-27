package Flight.Utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelFileReader {
    public String excel(String key, int k,int v) throws IOException {
        FileInputStream fis = new FileInputStream("C://Users//lgesh//Downloads//test.xlsx");
        XSSFWorkbook xssfWorkbook =new XSSFWorkbook(fis);
        XSSFSheet sheet=xssfWorkbook.getSheet(key);
        Row row =sheet.getRow(k);
        Cell cell=row.getCell(v);
        String value=cell.getStringCellValue();
        xssfWorkbook.close();
        return value;
    }
}
