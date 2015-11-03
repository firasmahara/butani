package com.helmi.common.ws;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.helmi.common.entity.Customer;
import com.helmi.common.service.CustomerService;

//@Stateless
@ApplicationScoped
@Path("customers")
public class CustomerResource {

	@Inject
    CustomerService service;
 
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Customer customer) {
        service.create(customer);
    }
 
    @GET
    @Path("{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer find(@PathParam("customerId") long customerId) {
    	System.out.println("GET customerId is called.");
        return service.find(customerId);
    }
 
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Customer customer) {
        service.update(customer);
    }
 
    @DELETE
    @Path("{customerId}")
    public void delete(@PathParam("customerId") long customerId) {
        service.remove(customerId);
    }

}
