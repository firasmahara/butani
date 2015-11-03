package com.helmi.common.ws;

import java.io.StringReader;
import java.net.URI;

import javax.json.Json;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class JaxRs20Client {

	 public static void main(String[] args){
		 System.out.println("Starting client....");
		 String url = "http://127.0.0.1:8080/common/api/customers";
		  URI uri = URI.create(url);

		  final Client client = ClientBuilder.newClient();
		  WebTarget webTarget = client.target(uri);

		  Response response = webTarget.request(MediaType.APPLICATION_JSON).get();

		  //Se Response.Status.OK;
		  if (response.getStatus() == 200) {
		     StringReader stringReader = new StringReader(webTarget.request(MediaType.APPLICATION_JSON).get(String.class));
		     try (JsonReader jsonReader = Json.createReader(stringReader)) {
		        //return 
		        		jsonReader.readObject();
		     }
		  }

	 
	 }

}
