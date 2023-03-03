package com.seleniumgrid.tests;

import com.seleniumgrid.pages.VyTrackDashBoardPage;
import com.seleniumgrid.utilities.ConfigurationReader;
import com.seleniumgrid.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class VyTrackLoginDDTTest {

    VyTrackDashBoardPage dashBoardPage = new VyTrackDashBoardPage();

    @Before
    public void setUo(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
    }

    @After
    public void tearDown(){
        Driver.closeDriver();
    }

    @Test
    public void loginDDTTest() throws IOException {

        String filePath = "Vytrack.xlsx";
        FileInputStream in = new FileInputStream(filePath);

        XSSFWorkbook workbook = new XSSFWorkbook(in);

        XSSFSheet sheet = workbook.getSheet("data");

        for (int i=1; i<=sheet.getLastRowNum(); i++){

            String username = sheet.getRow(i).getCell(0).toString();
            String password = sheet.getRow(i).getCell(1).toString();
            String firstName = sheet.getRow(i).getCell(2).toString();
            String lastName = sheet.getRow(i).getCell(3).toString();

            dashBoardPage.login(username,password);

            WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
            WebElement loaderMask = Driver.getDriver().findElement(By.cssSelector("div[class= 'loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));

            String actualFullName = dashBoardPage.fullName.getText().trim();

            XSSFCell resultCell = sheet.getRow(i).getCell(4);

            if (actualFullName.contains(firstName) && actualFullName.contains(lastName)){
                System.out.println("PASS");
                resultCell.setCellValue("PASS");
            } else {
                System.out.println("FAIL");
                resultCell.setCellValue("FAIL");
            }

            dashBoardPage.logout();
        }

        FileOutputStream out = new FileOutputStream(filePath);
        workbook.write(out);
        in.close();
        out.close();
        workbook.close();


    }

}
