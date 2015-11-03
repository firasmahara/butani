package com.helmi.common.ws.helper;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.ObjectMapper;

import com.helmi.common.entity.Customer;
@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerMessageBodyReader implements MessageBodyReader<Customer> {
	@Override 
	     public boolean isReadable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) { 
	         return true; 
	     } 
	 
	 
	     @Override 
	     public Customer readFrom(Class<Customer> customerClass, Type type, Annotation[] annotations, MediaType mediaType, 
	                              MultivaluedMap<String, String> stringStringMultivaluedMap, InputStream inputStream) throws IOException, WebApplicationException { 
	         if (mediaType.getType().equals("application") && mediaType.getSubtype().equals("json")) { 
	             ObjectMapper mapper = new ObjectMapper(); 
	             return mapper.readValue(inputStream, Customer.class); 
	         } 
	         throw new UnsupportedOperationException("Not supported MediaType: " + mediaType); 
	     } 

}
