import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class Chemical1 {

	@Before
	public void setUp() {
		System.setProperty("webdiver.gecko.driver","/home/user/Desktop/geckodriver");
		driver=new FirefoxDriver();
		driver.manage().timeouts().implecitlywait(7,TimeUnit.SECONDS);
		driver.get("http://localhost:8080/application/");
		
}
	
	@Test
	public void test() throws IOException {
		String title=driver.getTitle();
		log.info("Title of the page:"+title);
		
		List<webElement> link=driver.findElement(By.tagName("a"));
		log.info("Number of Hyperlinks:"+link.size);
		
		driver.findElement(By.xpath("/html/body/nav/div/dib[2]/ul/li[3]/a")).click();
		
		FileInputStream fis=new FileInputStream("/home/user/Desktop/user_repo/To_Paryicipant/AdditionalSupplies");
		  HSSFWokbook wb=new HSSFWorkbook(fis);
		  HSSFSheet sh= wb.getSheetAt("SignUp");
		  int rowCount = sh.getLastRowNum() - sh.getFirstRowNum();
			
			for (int i = 1; i <= rowCount; i++) {
				
			
		  
		  String typeOfUser=sh.getRow(1).getCell(0).getStringCellValue();
		  String employeeName=sh.getRow(1).getCell(1).getStringCellValue();
		  String empNo=sh.getRow(1).getCell(2).getStringCellValue();
		  String gen=sh.getRow(1).getCell(3).getStringCellValue();
		  String location=sh.getRow(1).getCell(4).getStringCellValue();
		  String email=sh.getRow(1).getCell(5).getStringCellValue();
		  String pwd=sh.getRow(1).getCell(6).getStringCellValue();
		  
		  webElement dd= driver.findEelment(By.id("sell"));
		  org.openqa.selenium.support.ui.Select type=new org.openqa.selenium.support.ui.Select();
		  type.seleniumByVisibleText(typeOfUser);
		  
			driver.findElement(By.id("ename")).sendKeys(employeeName);
			driver.findElement(By.id("empnum")).sendKeys(empNo);
			
			if(gen.equals("Male")) {
				driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/div/.."));
			}
			else {
				driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/div/.."));
			}
			
			String display=driver.findElement(By.id("Lstore")).sendKeys(location);
			driver.findElement(By.id("email")).sendKeys(email);
			driver.findElement(By.id("pwd")).sendKeys(pwd);
			
			driver.findElement(By.id("addc")).click();
			String.findElement(By.xpath("/html/body/div[2]/div/div/strong"));
			log.info(msg);
			
		  }
			
			
		
	}
	
	@Parameter({"Type","Name","ServiceNo","Quantity"})
	@Test
	public void test2(Sytring Type,String Name,String ServiceNo,String Quantity) throws IOException{
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a")).click();
		
		FileInputStream fis=new FileInputStream("/home/user/Desktop/user_repo/To_Paryicipant/AdditionalSupplies");
		  HSSFWokbook wb=new HSSFWorkbook(fis);
		  HSSFSheet sh= wb.getSheetAt("Login");
		  int rowCount = sh.getLastRowNum() - sh.getFirstRowNum();
			
			for (int i = 1; i <= rowCount; i++) {
				
				String user=sh.getRow(i).getCell(0).getStringCellValue();
				String pwd=sh.getRow(i).getCell(1).getStringCellValue();
				
				driver.findElement(By.id("uname")).sendKeys(user);
				driver.findElement(By.id("pass")).sendKeys(pwd);
				driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/form/div...")).sendKeys(email);
				driver.findElement(By.xpath("//*[@id=\"addc\"]")).click();
				driver.findElement(By.id("add")).click();
				
			}
			
			 webElement tc= driver.findEelment(By.id("tc"));
			  org.openqa.selenium.support.ui.Select type=new org.openqa.selenium.support.ui.Select();
			  type.seleniumByVisibleText(type);
			  driver.findElement(By.id("cname")).sendKeys(Name);
				driver.findElement(By.id("cno")).sendKeys(ServiceNo);
				driver.findElement(By.id("cqun")).sendKeys(Quantity);
				driver.findElement(By.id("addc")).click();
				driver.findElement(By.id("addmore")).click();
				driver.findElement(By.id("back2")).click();
				
				driver.findElement(By.id("view")).click();
				
				driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li/a")).click();
				driver.findElement(By.xpth("/html/body/nav/div/div[2]/ul/li/ul/li[2]/a")).click();
				
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	

}
