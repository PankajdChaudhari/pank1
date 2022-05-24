import static org.junit.Assert.*;

import org.junit.Test;

public class rest2git {

	@Test
	public void registerAndVerifyCustomer() throws IOException {

	RestAssured.baseURI = "http://localhost:8080/infybank/api/customers";
	RequestSpecification request = RestAssured.given();
	request.header("Content-Type","application/json");
	JSONObject r =new JSONObject();
	String path= "additional suuplies path here";
	FileInputStream fis = new FileInputStream(path);
	HSSFWorkbook wb = new HSSFWorkbook(fis);
	HSSFSheet sheet = wb.getSheetAt(0);
	int rowSize = sheet.getLastRowNum();
	for(int i=1;i<=rowSize;i++)
	{
	r.put("CustName", sheet.getRow(i).getCell(0).getStringCellValue());
	r.put("custCurrentAdd", sheet.getRow(i).getCell(1).getStringCellValue());
	r.put("custPermanentAdd", sheet.getRow(i).getCell(2).getStringCellValue());
	r.put("CustPhNo", sheet.getRow(i).getCell(3).getStringCellValue());
	r.put("CustEmail", sheet.getRow(i).getCell(4).getStringCellValue());
	r.put("account", sheet.getRow(i).getCell(5).getStringCellValue());
	r.put("password", sheet.getRow(i).getCell(8).getStringCellValue());

	request.body(r.toString());
	System.out.println(r.toString());
	Response response = request.post();

	int StatusCode = response.getStatusCode();
	Assert.assertEquals(StatusCode, 201);

	DataFormatter formatter = new DataFormatter();
	HSSFCell cell = sheet.getRow(i).getCell(4);
	String id = formatter.formatCellValue(cell);
	Response res = request.get("/login?mailid="+id);
	System.out.println(res);
	int StatusCodeMailID = res.getStatusCode();
	Assert.assertEquals(StatusCodeMailID, 200);

	JSONObject objRes = new JSONObject(res);
	String CustId = objRes.getString("customerId");
	Response resp0 = request.get("?customerId="+CustId);
	System.out.println(resp0);
	int Stat = resp0.getStatusCode();
	Assert.assertEquals(Stat, 200);

	JSONObject ob1 = new JSONObject(resp0);
	String CustName1 = ob1.getString("custName");
	String CustEmail1 = ob1.getString("custEmail");
	Assert.asserEquals(CustName1, sheet.getRow(i).getCell(0).getStringCellValue());
	Assert.asserEquals(CustEmail1, sheet.getRow(i).getCell(4).getStringCellValue());
	sheet.getRow(i).createCell(9).setCellValue(custId);
	FileOutputStream fileOut = new FileOutputStream(path);
	wb.write(fileOut);
	fileOut.close();
	}
		wb.close();
		
		}


