import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.common.excelreport.ExcelReportGenerator;
public class GenerateExcelReports {

public static void main(String[]args) throws ParserConfigurationException, IOException, SAXException
{
ExcelReportGenerator.generateExcelReport(System.getProperty("user.dir")+"//test-output//Default suite", "testdata.xlsx");

}}