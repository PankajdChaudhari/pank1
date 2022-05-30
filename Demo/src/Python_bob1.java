import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.jupiter.api.Test;

public class Python_bob1 {

	webDriver driver=null;
	
	@DataProvider(name="cred")
	public Object[][] getdata(){
	 Object[][] data= new Object[2][2];
	
	data[0][0]="Selenium using python";
	data[0][1]="Educator";
	
	
	data[1][0]="Agile testing";
	data[1][1]="Co-Educator";
	return data;
	}

@BeforeClass
public void setup() {
	System.setProperty("webdiver.gecko.driver","/home/user/Desktop/geckodriver");
	driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlywait(5, TimeUnit.SECONDS);
	driver.get("http://localhost:8080/application/");
	driver.manage().window().maximize();
}

@Test(priority=1)
public void add_mem() throws Exception{
	
	driver.findElement(By.xpath("/html/body/div/div/div/div[2]/p[2]/a[1]")).click();
	Thread.sleep(1000);
	
	FileInputStream fis=new FileInputStream("/home/user/Desktop/user_repo/To_Paryicipant/AdditionalSupplies");
	  HSSFWokbook wb=new HSSFWorkbook(fis);
	  HSSFSheet sh= wb.getSheetAt("Sheet1");
	  
	  for(int i=1; i<=sheet.getLastRowNum();i++) {
		  HSSFRow row=sheet.getRow(i);
		  
		  String row=row.getCell(0).getStringCellValue();
		  String fname=row.getCell(1).getStringCellValue();
		  String lname=row.getCell(2).getStringCellValue();
		  String emaile=row.getCell(3).getStringCellValue();
		  String empno=row.getCell(4).getStringCellValue();
		  String stream=row.getCell(4).getStringCellValue();
		  
		  driver.findElement(By.xpath("/html/body/div[1]/form/input[1]")).SendKeys("fname");
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("/html/body/div[1]/form/input[2]")).SendKeys("lname");
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//*[@id=\"email_form\"]")).SendKeys("email");
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//*[@id=\\\"password_form\\\"]")).SendKeys("empno");
		  Thread.sleep(1000);
	  }
	  
	  @Test(Priority=2)
	  @Parameters({"type","pswd"})
	  public void already_mem(String type,String pswd) throws Exception{
		  driver.findElement(By.xpath("/html/body/div/div/div/div[2]/p[2]/a[2]")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.id("inputName")).click(type);
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).click(pswd);
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("/html/body/div/form/button")).click();
			Thread.sleep(1000);
			
			SoftAssert asrt=new SoftAssert();
			asrt.assertEquals("SignOut,sgout");
			
	  }
	  

	  @Test(dataProvider="cred",priority=3)
	  public void add_course(String course,String role) throws Exception {
		  webElement selectcourse=driver.findElement(By.id("course"));
		  Select select1=new Select(selectcourse);
		  select1.selectByVisibleText(course);
		  Thread.sleep(1000);
		  
		  webElement selectrole=driver.findElement(By.xpath("//*[@id=\"role\"]"));
		  Select select2=new Select(selectrole);
		  select2.selectByVisibleText(role);
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("/html/body/div[3]/form/button[1]")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li/a")).click();
			Thread.sleep(1000);
	  }


	@AfterClass
	public void teardown() {
		driver.quit();
	}

}