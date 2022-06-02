import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

public class OnlineCource_Basic {

	webDriver driver;
	
	@BeforeClass
	
	public void setUp() {
		System.setProperty("webdiver.gecko.driver","/home/user/Desktop/geckodriver");
		driver=new FirefoxDriver();
		driver.get("http://localhost:8080/application/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlywait(13,TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	
		
	@Test(prioriry=0)
	public void Browse() throws InterruptedException,IOException{
		driver.findElement(By.linkText("BROWSE CATALOG")).click();
		Thread.sleep(1000);
		
		
		//Hyperlinks
		
		List<webElement> links= driver.findElement(By.tagName("a"));
		int linksize=links.size();
		System.out.println("The number of Hypeerlinks are:"+link.size());
		for(WebElement li:links) {
			System.out.println("Hyperlinks:"+li.getText());
			
		}
	}
	
	@Test(priority=1)
	public void webelement() throws IOException,InterruptedException {
		
		//Excel data
		File file=new File("C://Users//harshita.m10//Desktop//m76190hc//To_Trainees//Artifacts//Data/xlsx");
		 FileInputStream fis=new FileInputStream(file);
		  HSSFWokbook wb=new HSSFWorkbook(fis);
		  HSSFSheet sh= wb.getSheetAt("Data");
		  
		  
		  int lastrow=sheet.getLastRowNum();
		  WebElement element= driver.findElement(By.xpath("//*[@id=\"catalpgTable\"]"));
		  List<WebElement> rows= element.findElement(By.tagName("tr"));
		  
		  System.out.println(lastrow);
		  for(int i=1;i<=lastrow;i++) {
			  String CourseName=sheet.getRow(i).getCell(0).getStringCellValue();
			  String University=sheet.getRow(i).getCell(1).getStringCellValue();
			  String Cost=sheet.getRow(i).getCell(2).getRawValue();
			  
			  List<WebElement> cols=rows.get(i).findElement(By.(tagName("td"));
			  Row currentRow=sheet.getRow(i);
			  Cell currentCell=currentRow.createCell(3);
			  
			  if(cols.get(0).getText().equals(CourseName)&&cols.get(4).getText().equals(University)&& cols.get(5).getText().equals(Cost)) {
				  currentCell.setCellValue("ok");
			  }
			  else
			  {
				  currentCell.setCellValue("Not Matching");
				  Thread.sleep(1000);
				  
			  }
			  
			  FileOutputStream fout=new FileOutputStream(file);
			  book.write(fout);
			  book.close();
			  
			  
			  driver.findElement(By.xpath("//*[@id=\"btn8\"]")).click();
			  Thread.sleep(1000);
			  
			  driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("John");
			  driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("john@gamil.com");
			  driver.findElement(By.id("stuRadio")).click();
			  Thread.sleep(1000);
			  
			  
			  Select select1=new Select(diver.findElement(By.xpath("//*[@id=\"pSelect1\"]")));
			  select1.selectByIndex(1);
			  Thread.sleep(500);
			  
			  Select select2=new Select(diver.findElement(By.xpath("//*[@id=\"pSelect1\"]")));
			  select2.selectByIndex(2);
			  Thread.sleep(500);
			  driver.findElement(By.id("eRadio3")).click();
			  Thread.sleep(1000);

			  String cost=driver.findElement(By.xpath("//*[@id=\"courseCost\"]")).getText();
			  System.out.println(cost);
			  String success=driver.findElement(By.xpath("//*[@id=\"successForm\"]")).getText();
			  System.out.println(success);
			  
			  diver.findElement(By.xpath("//*[@id=\"payNow\"]")).click();
			  Thread.sleep(1000);
			  
			  
			  //ScreenShot
			  
			  File img=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(img,new File("Desktop\\Reference.jpeg));
					  
					  
			  
		  }
		
	}
}
