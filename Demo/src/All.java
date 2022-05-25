import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
package seleniumtest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class EDULogin {

class All{


		//Testng
			static WebDriver driver;
			
		  @Test
		  public void f() {
			  driver.findElement(By.name("loginName")).sendKeys("T7302");
			  driver.findElement(By.name("password")).sendKeys("T7302*abc");
			  driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button")).click();
		  }
		  @BeforeClass
		  public void beforeClass() {
			  System.setProperty("webdriver.chrome.driver", "D:\\SELENIUM\\ChromedriverNew\\chromedriver_win32\\chromedriver.exe");
			  driver=new ChromeDriver();
			  driver.get("http://10.82.180.36:8080/EDUBank/tellerLogin");
			  
			  
			  
			  
			  //Soft assert Object
			    SoftAssert softAssert=new SoftAssert();
			    softAssert.assertEquals("demoforHardAssertions", assertionString);
			    System.out.println("After Assert equals");
			    softAssert.assertTrue(assertionString.equals("demoforHardAssertions"));
			    System.out.println("After Assert true");
			    }
		  
		  
		  
		  
		  
		  
		  //Selenium basic
		  //table tagname tr
			WebDriver driver;
			String url = "http://localhost:8080/PackAndGo_v2/index.html";
		 
			@Before
			public void setUp() {
				//Set the key/value property according to the browser you are using.
				System.setProperty("webdriver.gecko.driver",driverPath+"geckodriver.exe"); 
						 
				//Open browser instance
				driver = new FirefoxDriver();
								
				//Open the AUT
				driver.get(url);
				
				//Declare an implicit wait which is bounded to WebDriver instance
				driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			}
		 
			@Test
			public void test() throws InterruptedException {
				
					
				//Click on Offers Link
				driver.findElement(By.linkText("Offers")).click();
				
				//Fetch the Account details table
				WebElement tblAccountDetails = driver.findElement(By.id("offersTable"));
				
				//Fetch all the rows inside the Account details table using the tr tag and store it in rows list
				List<WebElement> rows = tblAccountDetails.findElements(By.tagName("tr"));
				
				//Print the number of rows
				System.out.println("Number of rows: " + rows.size());
				
				//Iterate over all the rows
				for (WebElement row : rows) {
					//Find all the cols inside the particular row using the td tag
					List<WebElement> cols = row.findElements(By.tagName("td"));
					
					//Iterate over all the columns inside the particular row
					for (WebElement col : cols) {
						//Print the cell value
						System.out.print("Column value: " + col.getText());
					}
					
					
					
					
					//window handle
					
					WebElement sectyq = driver.findElement(By.id("secQId"));
					
					//Pass the reference variable for sectyq as a parameter for the Select class
					Select secqdd = new Select(sectyq);
					
					//Use the select reference variable for selecting any option using index/value/visible text approach
					secqdd.selectByValue("210002");
					
					//Enter the security answer
					driver.findElement(By.id("secAns")).sendKeys("Chicago");
					
					//Click on Add Customer
					driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/form/button[1]")).click();
					
					//Click on Download Customer Details
					driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[4]/a")).click();
					
					// Fetch the number of opened windows
					Set<String> windowHandles = driver.getWindowHandles();
					System.out.println("Number of opened windows: " + windowHandles.size());
					
					Integer temp=0;
					
					String msg=null;
					
					//Iterate through all the available windows
					for (String string : windowHandles) {
						//Switch between windows using the string reference variable
						driver.switchTo().window(string);
						
						//Fetch the url of the page post successful switch
						String title = driver.getTitle();
						
						//check whether the url post switch is the desired page
						if (!title.equals("Teller Home")) {
							temp = 1;
							msg="Window found.";
							break;
						} else {
							temp = 0;
						}
					}
			 
					if (temp == 1) {
						
						System.out.println(msg);
					
						//Find some element from the switched page to verify that the switch is successful
						WebElement Bankname = driver.findElement(By.xpath("/html/body/div/span[1]"));
						System.out.println(Bankname.getText()+" Bank");
					}
					else if (temp == 0) {
						System.out.println("Desired Window not found.");
					}
				}
				
				
				//pop up
				
				
				WebElement fromsrc = driver.findElement(By.id("fromDD"));
				
				//Pass the reference variable for fromsrc as a parameter for the Select class
				Select selectFrom = new Select(fromsrc);
				
				//Use the select reference variable for selecting any option using index/value/visible text approach
				selectFrom.selectByIndex(1);
				
				//Find the From dropdown list and store it as a WebElement
				WebElement toDest = driver.findElement(By.id("toDD"));
						
				//Pass the reference variable for toDest as a parameter for the Select class
				Select selectTo = new Select(toDest);
				
				//Use the select reference variable for selecting any option using index/value/visible text approach
				selectTo.selectByValue("Hyderabad");
				
				//click on Search Buses button
				driver.findElement(By.id("searchBus")).click();
				
				//Select the Radio button Search Bus corresponding to BNGHYD2200
				driver.findElement(By.id("radio3")).click();
		 
				//Select the Proceed to Booking button
				driver.findElement(By.id("book")).click();
				
				//Enter the No. of Passenger as 10
				driver.findElement(By.id("counter")).sendKeys("10");
				
				//Click on Calculate Total Bill
				driver.findElement(By.xpath("//*[@id=\"rowB6\"]/td/p/input")).click();
				
				 
				//clear the value from No of Passenger textbox
				driver.findElement(By.id("counter")).clear();
				
				//Enter the value of No of Passenger as 4
				driver.findElement(By.id("counter")).sendKeys("4");
				
				//Click on Calculate Total Bill
				driver.findElement(By.xpath("//*[@id=\"rowB6\"]/td/p/input")).click();
				
				//Click on ConfirmBooking
				driver.findElement(By.id("confirmBooking")).click();
				
				//Accept the alert box
				driver.switchTo().alert().accept();		
				
				Thread.sleep(2000);	
				
				//Click on logout link
				driver.findElement(By.linkText("LogOut")).click();
				}
			
			
			
			//drag and drop
			
			
			@Test
			public void test() throws InterruptedException {
				//Fetch the element property which should be dragged by using element locator
				WebElement fromElement = driver.findElement(By.id("draggable"));
				
				//Fetch the element property where the dragged element should get released by using element locator
				WebElement toElement = driver.findElement(By.id("droppable"));
				
				//Create a reference for Actions class
				Actions action = new Actions(driver);
				
				//Use dragAndDrop method and provide arguements as the from element and to element
				action.dragAndDrop(fromElement, toElement).perform();
				
				//Post drag fetch the status message and compare for successful verification
				String afterDragging = driver.findElement(By.xpath("html/body/form/div[4]/div/div[2]/div/p")).getText();
				
				if(afterDragging.equals("Dropped!"))
					System.out.println("Drag successful.");
				else
					System.out.println("Drag Unsuccessful.");
			}
		 
			
			
			
			//parameterise using excel sheet
			
			
			
			
			
			@Test
			public void test() throws Exception {
				//Path from where the excel file has to be read
				String filePath = System.getProperty("user.dir") + "\\Cred.xlsx";
				 
						//File input stream which needs the input as the file location
						FileInputStream fileStream = new FileInputStream(filePath);
						
						//Workbook reference of the excel file
						XSSFWorkbook workbook = new XSSFWorkbook(fileStream);
						
						//Sheet which needs to be accessed from within the workbook
						XSSFSheet sheet = workbook.getSheet("Sheet1");
				 
						//Count the number of rows
						int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
				 
						//Iterate the Username/Password/
						for (int i = 1; i <= rowCount; i++) {
							//Pass the row number and the cell number from where the value has to be fetched
							
							driver.findElement(By.xpath("//*[@id=\"myNavbar\"]/ul/li[4]/a")).click();		
							
							Thread.sleep(2000);
							
							driver.findElement(By.id("usernameLogin")).sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
							
							
							driver.findElement(By.id("passwordLogin")).sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
							
							
							driver.findElement(By.id("login")).click();
							
							String message = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[1]")).getText();
							System.out.println(message);
				 
							driver.findElement(By.linkText("LogOut")).click();
						}
			}
			
			
			
			//part2
			
			
			
			@Test
			public void test() throws InterruptedException, IOException {
				String filePath = System.getProperty("user.dir") + "\\Cred.xlsx";
				
				//FileInputStream
				//Access the workbook
				//Access the sheet
				for (int i = 1; i <= rowCount; i++) {
		          		//Login and fetch the welcome message	
			
		        		//Get the current row where the data has to be written
					Row newRow = getSheet.getRow(i);
					
					//Create a new cell with reference to the row
					Cell cell = newRow.createCell(2);
					
					//Set the value in the cell
					cell.setCellValue(DashboardMessage);
					
					//Logout from the application.
				}
				
				//Create an output stream with the location where the file has to be created
				FileOutputStream fileOutputStream = new FileOutputStream(filePath);
				
				//Write the workbook
				workbook.write(fileOutputStream);
				
				//Close the workbook
				workbook.close();
			}

			
			
			//Screenshot
			
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			//Using the FileUtils class copy the generated screenshot file to any location
			FileUtils.copyFile(scrFile, new File("C:\\Users\\some_user\\Desktop\\Image.png"));
	 
			//Click on logout link
			driver.findElement(By.linkText("LogOut")).click();
		}
		

//Handling exception


//Typecast the driver reference variable with TakesScreenshot for access the methods from TakesScreenshot interface
//getScreenshotAs method will take arguement for the output type of the file
File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

try{
	FileUtils.copyFile(scrFile, new File("C:\\Users\\some_user\\Desktop\\Image.png"));
} catch(IOException e){
	System.out.println("Exception Message: " + e.getMessage());
}		

//Click on logout link
driver.findElement(By.linkText("LogOut")).click();
}



			}
		  }
		  @AfterClass
		  public void afterClass() {
			  System.out.println(driver.getTitle());
			  driver.quit();
		  }
	}
}

