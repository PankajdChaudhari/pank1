import static org.junit.Assert.*;

import java.io.FileOutputStream;

import org.junit.Test;

import junit.framework.Assert;

public class Rest {

	@Test
	public void User() throws IOException, JSONException {
		Responce responce;
		RestAssured.baseURI="http://localhost:8080/infybank/api";
		RequestSpecification Request=RestAssured.given();
		request.header("Content-Type","application/json");
		JSONObject requestParams=new JSONObject();
		String path="/root/Desktop/User_repo/To_Participant/AdditionalSuppliedFiles/register/xls";
		FileInputStream fis= new FileInputSream(path);
		HSSFWorkbook wb= new HSSFWorkbook(fis);
		HSSFSheet sheet= wb.getSheetAt(0);
		int rowNo=sheet.getLastRowNum()-sheet.getFirstRowNum();
		
		For (int=1;i<=rowNum;i++) {
			String CustNa=sheet.getRow(i).getCell(0).getStringCellValue();
			
			requestParams.put("CustName", sheet.getRow(i).getCell(0).getStringCellValue());
			requestParams.put("CustCurrentAdd", sheet.getRow(i).getCell(1).getStringCellValue());
			requestParams.put("CustCustPermanantAdd", sheet.getRow(i).getCell(2).getStringCellValue());
			requestParams.put("CustPhNo", sheet.getRow(i).getCell(3).getStringCellValue());
			requestParams.put("CustEmail", sheet.getRow(i).getCell(4).getStringCellValue());
			requestParams.put("AccountNo", sheet.getRow(i).getCell(5).getStringCellValue());
			requestParams.put("AccountType", sheet.getRow(i).getCell(6).getStringCellValue());
			requestParams.put("BalanceAmount", sheet.getRow(i).getCell(7).getStringCellValue());
			requestParams.put("Password", sheet.getRow(i).getCell(8).getStringCellValue());
			
			request.body(requestParams.toString());
			responce=request.post("/customers");
			int statusCode= responce.getStatusCode();
			Assert.assertEquals(statusCode/*actualValue*/, 201 /*expectedValue*/,"INCorrect status code");
			
			JsonPath JsonPathEvaluator= responce.jsonPath();
			String customerId=jsonPathEvaluator.get("custId");
			int statusCode1=responce.getStatusCode();
			Assert.assertEquals(statusCode1,200, INCorrect status);
			
			responce=RestAssured.get("http://localhost:8080/infybank/api/customers?customerId="+customerName);
			JSONPath jsonPathEvaluatorN=responce.jsonPath();
			String custName=jsonPathEvaluatorN.get("custName");
			
			int statusCode2= responce.getStatusCode();
			Assert.assertEquals(statusCode2, 200,"INCorrect status code");
			
			if(custNa.equals(custName))
			{
				Row newRow = sheet.getRow(i);
				Cell cell=newRow.createCell(9);
				cell.setCellValue(customerId);
				
			}
			
			}
		FileOutputStream fileOutputStream=new FileOutputStream("/root/Desktop/User_repo/To_Participant/AdditionalSuppliedFiles/register/xls");
		wb.write(fileOutputStream);
		wb.close();
		
	}






@After
public void tearDown() {
	driver.quit();
	
}

@DataProvider (name="Data")
public Object [][] getData(){
	return new object [][]
			{"Mushroom Pulao","Butter Paneer","7896564123"};
			{"Vegetable Tahiri","Bruseels Sprouts Curry","9874563210"};
			
}
}