import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class FetchAllLinks extends ConnectionString {

    @Test
    public void fetchPageURLs() throws IOException {
        int c = 0;
        File file = new File(("D:\\output.xlsx"));

        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sh = wb.createSheet();

        driver.get("https://bbc.com");
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        XSSFRow row1 = sh.createRow( 1 );

        for (WebElement link : allLinks) {
            for ( int cellIndex = 0; cellIndex < 2; cellIndex++ ) {
                String url = link.getAttribute("href");
                System.out.println(url);

                XSSFCell cell = row1.createCell( cellIndex );
                cell.setCellValue(url);
            }
            try {
                FileOutputStream fos = new FileOutputStream(file);
                wb.write(fos);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

       /* for (WebElement link : allLinks) {
            System.out.println(link.getText() + " - " + link.getAttribute("href"));
        }*/
    }

    /*@Test
    public void testFunc() {
        File file = new File(("D:\\output.xlsx"));

        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sh = wb.createSheet();

        sh.createRow(0).createCell(0).setCellValue("age");

        try {
            FileOutputStream fos = new FileOutputStream(file);
            wb.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
