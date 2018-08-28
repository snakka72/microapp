package com.git.gitapp;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/")

public class testController {
	
	@RequestMapping(value = "welcome", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getAllCustomers(){
		
/*		String strText = "[\"Name: 'ID1002', City: 'Zoom'\"]";
		//String strText1 = "\"This is a String\"";
		return ResponseEntity.ok(strText);*/
		
	    String json = "[\"Name: 'ID1001', City: 'Local'\"]";
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.setContentType(MediaType.APPLICATION_JSON);
	    return new ResponseEntity<String>(json, responseHeaders, HttpStatus.ACCEPTED);		
		
	}
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public ResponseEntity<String> unauthorized() {

	    String json = "[\"Name: 'ID1001', City: 'Local1'\"]";
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.setContentType(MediaType.APPLICATION_JSON);
	    return new ResponseEntity<String>(json, responseHeaders, HttpStatus.ACCEPTED);
	}
	

}
