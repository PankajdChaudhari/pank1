import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

;

public class Rest {

	@Test
	public void User() throws IOException, JSONException {
		Response response;
		RestAssured.baseURI="http://localhost:8080/infybank/api";
		RequestSpecification request=RestAssured.given();
		request.header("Content-Type","application/json");
		jsonObject requestParams=new jsonObject();
		String path="/root/Desktop/User_repo/To_Participant/AdditionalSuppliedFiles/register/xls";
		FileInputStream fis= new FileInputSream(path);
		HSSFWorkbook wb= new HSSFWorkbook(fis);
		HSSFSheet sheet= wb.getSheetAt(0);
		int rowNo=sheet.getLastRowNum()-sheet.getFirstRowNum();
		
		for (int i=1;i<=rowNo;i++) {
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
			response=request.post("/customers");
			int statusCode= response.getStatusCode();
			Assert.assertEquals(statusCode/*actualValue*/, 201);
			
			JSONPath JsonPathEvaluator= response.jsonPath();
			String customerId=JsonPathEvaluator.get("custId");
			int statusCode1=response.getStatusCode();
			Assert.assertEquals(statusCode1,200);
			
			response=RestAssured.get("http://localhost:8080/infybank/api/customers?customerId="+customerId);
			JSONPath jsonPathEvaluatorN=responce.jsonPath();
			String custName=jsonPathEvaluatorN.get("custName");
			
			int statusCode2= response.getStatusCode();
			Assert.assertEquals(statusCode2, 200);
			
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

}






