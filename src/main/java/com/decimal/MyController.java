package com.decimal;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.decimal.service.PDFGeneratorService;
import com.lowagie.text.DocumentException;

@RestController
public class MyController {

	@Autowired
	RestTemplate template;
	
	
	private final PDFGeneratorService pdfGeneratorSerivce;
	
	
	public MyController(PDFGeneratorService pdfGeneratorSerivce) {
		this.pdfGeneratorSerivce = pdfGeneratorSerivce;
	}


	@GetMapping("/get")
	public void getData() throws IOException {
		Map<String, Object> response = new LinkedHashMap<>();
		
		String request = "{\"membershipId\":\"M731099814020211213060252317\"}";
		HttpHeaders headers = new HttpHeaders();
		headers.add("requestid", "1638778600");
		headers.add("orgid", "BTI-4THFB6QXXI");
		headers.add("appid", "BTI_APP-BF4WKQB3DW");
		headers.add("servicename", "TRANSACTION_DETAILS_FETCH");
		headers.add("clientsecret", "6143f97f-c614-4b3a-9906-c1d6e81438a9");
		headers.add("Content-Type", "application/json");
		HttpEntity<Object> entity = new HttpEntity<Object>(request,headers);
		Object obj =  template.postForObject("https://sandbox.vahanacloud.com/router/engine/v1/gatewayProcessor", entity, Object.class);
		System.out.println(obj.toString());
		response = (Map) obj;
		JSONObject json = new JSONObject(response);
		File file = new File("TransactionDetails.csv");
		JSONArray docs = json.getJSONObject("TRANSACTION_DETAILS_FETCH").getJSONArray("records").getJSONObject(0).getJSONArray("data");
		//System.out.println(docs);
		//String csv = CDL.toString(docs);
		//System.out.println();
		//FileUtils.writeStringToFile(file, csv);
		//System.out.println("written data in file");
		//ObjectMapper mapper = new ObjectMapper();
		//JsonNode node = mapper.readTree(json.toString());
		//System.out.println(node.toPrettyString());
	}
	
	
	@GetMapping("/users")
	public void exportToPDF(HttpServletResponse response1) throws DocumentException, IOException {
		  
		
		Map<String, Object> response = new LinkedHashMap<>();
		
		String request = "{\"membershipId\":\"M731099814020211213060252317\"}";
		HttpHeaders headers = new HttpHeaders();
		headers.add("requestid", "1638778600");
		headers.add("orgid", "BTI-4THFB6QXXI");
		headers.add("appid", "BTI_APP-BF4WKQB3DW");
		headers.add("servicename", "TRANSACTION_DETAILS_FETCH");
		headers.add("clientsecret", "6143f97f-c614-4b3a-9906-c1d6e81438a9");
		headers.add("Content-Type", "application/json");
		HttpEntity<Object> entity = new HttpEntity<Object>(request,headers);
		Object obj =  template.postForObject("https://sandbox.vahanacloud.com/router/engine/v1/gatewayProcessor", entity, Object.class);
		System.out.println(obj.toString());
		response = (Map) obj;
		JSONObject json = new JSONObject(response);
		File file = new File("TransactionDetails.csv");
		JSONArray docs = json.getJSONObject("TRANSACTION_DETAILS_FETCH").getJSONArray("records").getJSONObject(0).getJSONArray("data");
		
		
		
		response1.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
		response1.setHeader(headerKey, headerValue);

		//List<User> listUsers = service.listAll();
		User user = new User(null,null,null,null,null);
		User user1 = new User(null,null,null,null,null);
		User user2 = new User(null,null,null,null,null);
		User user3 = new User(null,null,null,null,null);
		User user4 = new User(null,null,null,null,null);
		User user5 = new User(null,null,null,null,null);
		User user6 = new User(null,null,null,null,null);
		User user7 = new User(null,null,null,null,null);
		User user8 = new User(null,null,null,null,null);
		User user9 = new User(null,null,null,null,null);
		User user10 = new User(null,null,null,null,null);
		User user11 = new User(null,null,null,null,null);
		User user12 = new User(null,null,null,null,null);
		User user13 = new User(null,null,null,null,null);
		User user14 = new User(null,null,null,null,null);
 		List<User> userList = new ArrayList<User>();
		userList.add(user);
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);
		userList.add(user6);
		userList.add(user7);
		userList.add(user8);
		userList.add(user9);
		userList.add(user10);
		userList.add(user11);
		userList.add(user12);
		userList.add(user13);
		userList.add(user14);
		
		PDFGeneratorService exporter = new PDFGeneratorService(userList);
		exporter.export(response1);

	}
	
	
}
