package com.helmi.common.ws;

import static org.junit.Assert.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import com.helmi.common.entity.Customer;
import com.helmi.common.ws.helper.CustomerMessageBodyReader;
import com.helmi.common.ws.helper.CustomerMessageBodyWriter;

public class CustomerClientTest {

	private static final String SERVER = "http://localhost:8080/common/api/customers";
	 
    private WebTarget target;
 
    @Before
    public void setUp() {
        Client client = ClientBuilder.newClient();
        client.register(CustomerMessageBodyReader.class);
        client.register(CustomerMessageBodyWriter.class);
        this.target = client.target(SERVER);
    }
 
    @Test
    public void crud() {
    	long l = 3;
        Customer origin = new Customer(l, "Annabelle");
        Entity<Customer> entity = Entity.entity(origin, MediaType.APPLICATION_JSON);
 
        // create
        int i204 = 204;
        ///Response response = target.request(MediaType.APPLICATION_JSON).post(entity, Response.class);
        ///assertThat(response.getStatus(), equalTo(i204));
 
        // read
        Customer result = target.path(String.valueOf(origin.getCustomerId())).request(MediaType.APPLICATION_JSON).get(Customer.class);
        ///assertThat(result, equalTo(origin));
        System.out.println(result);
 
        // update
        entity.getEntity().setCustomerName("Annabelle");
        //target.request().put(entity);
 
        // delete
        //target.path(String.valueOf(origin.getCustomerId())).request(MediaType.APPLICATION_JSON).delete();
    }


	

}
