import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class Curry {

	
//	public void Submit() {
		
		webDriver driver=null;
		
		//String url="http://localhost:8080/application/";
		@BeforeMethod
		
		

		@Before
		public void setUp() {
			System.setProperty("webdiver.gecko.driver","/home/user/Desktop/geckodriver");
			driver=new FirefoxDriver();
			driver.get("http://localhost:8080/application/");
			driver.manage().window().maximize();
	}
		
		@Test(dataProvider="Authentication")
		public void test01(String dish, String curry, String number) {
		
			String parent= driver.getWindowHandle();
			driver.findElement(By.linkText("Order Now")).click();
			
			Set<String> child = driver.getWindowHandles();
			Iterator<String> i1=child.iterator();
			
			while (i1.hasNext()) {
				String Childwindow= i1.next();
				
				if (!parent.equalsIngnoreCase(childwindow)) {
					String title= driver.getTitle();
					SoftAssert softAssertion=new softAssert();
					SoftAssertion.assertEquals("Bootstrap Example", title);
					driver.findElement(By.linkText("Take Away")).click();
					driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/","div[2]/form/div[1]/div/div[2]/div/lebel[1]/input")).click();
					Select dish1=new Select(driver.findElement(By.id("mainDish")));
					dish1.selectByVisibleText(dish);	
					
					Select curry1=new Select(driver.findElement(By.id("curry")));
					curry1.selectByVisibleText(curry);	
					
					driver.findElement(By.id("msg")).sendKeys(number);
					driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/form/button")).click();
					Alert alert = driver.switchTo().alert();
					System.out.println("Order Successful");
					alert.accept();
					
					driver.findElement(By.linkText("Weekend Offers")).click();
					WebElement table=driver.findElement(By.id("Upcoming Offers"));
					List<WebElement> row= table.findElement(By.tagName("tr"));
					for (int i=2; j<=rowsize(); i++)
						List<WebElement> col= table.findElements(By.tagName("td"));
					for (int j=1; j<=col.size(); j++)
						System.out.println("Date : "+col.get(j).getText());
					System.out.println("Coupon Code : "+col.get(j+1).getText());
					System.out.println("Offers : "+col.get(j+2).getText());
				}
			}
			
			driver.close();
			
		}

	
	}

	driver.switchTo().window(parent);
}


  @Test(priority=1)
  public void test02() throws IOException {
	  
	  String parent = driver.getWindowHandle();
	  driver.findElement(By.linkText("Order Now")).click();
	  
	  String child = driver.getWindowHandle();
	  String path="/root/Desktop/user_repo/To_Participant/AdditionalSuppliedFiles/Data/xls";
	  FileInputStream fis=new FileInputStream(path);
	  HSSFWokbook wb=new HSSFWorkbook(fis);
	  HSSFSheet sh= wb.getSheetAt(0);
	  int a=sh.getLastRowNum();
	  while (i1.hasNext()) {
		  String ChildWindow=i1.next();
		  if (!parent.equalsIgnoreCase(ChildWindow)) {
			  driver.findElement(By.linkText("Home Delivery")).click();
		  for(int i=1;i<a;i++) {
			  driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/","/div[2]/div/div[2]/form/div[1]/div/div[2]/div/label[1]/input")).click();
		  String b=sh.getRow(1).getCell(0).getStringCellValue();
		  String c=sh.getRow(1).getCell(1).getStringCellValue();
		  String d=sh.getRow(1).getCell(2).getStringCellValue();
		  String e=sh.getRow(1).getCell(3).getStringCellValue();
		  String f=sh.getRow(1).getCell(4).getStringCellValue();
		  String g=sh.getRow(1).getCell(5).getStringCellValue();
		  Select dish2=new select(driver.findElement(By.id("mainDish"))); 
		 dish2.selectByVisibleText(b);
		 Select curry2=new select(driver.findElement(By.id("curry")));
		 curry2.selecyByVisibleText(c);
		 driver.findElement(By.id("name")).sendKeys(d);
		 driver.findElement(By.id("address")).sendKeys(e); 
		 driver.findElement(By.id("mobile")).sendKeys(f);
		 driver.findElement(By.id("email")).sendKeys(g);
		 driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/"+"div[2]/div/div[2]/form/botton")).click();
		 
		  Alert al=driver.switchTo().alert();
		  al.accept();
		  sh.getRow(1).getCell(6).setCellValue(Order Successfull);
		  }
		  
		  FileOutputStream fos= new FileOutputStream(path);
		  wb.write (fos);
		  fos.close();
		  wb.close();
		  fis.close();
		  
		  driver.close();
		  	  
		  
		 }
	  }
  
  
  
  
	
