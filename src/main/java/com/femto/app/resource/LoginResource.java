package com.femto.app.resource;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.femto.app.api.LoginAPI;
import com.femto.app.repository.LoginRepository;
import com.google.protobuf.Empty;
import com.mysql.cj.conf.PropertyDefinitions.ZeroDatetimeBehavior;
import com.mysql.jdbc.log.NullLogger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.Null;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

@Path("loginAPIs")

public class LoginResource {
	
	LoginRepository repo = new LoginRepository();
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	   public List<LoginAPI> getLoginAPIs()
	   {
 	   System.out.println("getLoginApI called...");
		    return repo.getLoginAPIs();
		   
	   }
    
    @GET
    @Path("loginapi/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	   public LoginAPI getLoginAPI(@PathParam("id") int id)
	   {
 	  return repo.getLoginAPI(id);
		   
	   }
    
    @POST
    @Path("loginapi")
    @Consumes(MediaType.APPLICATION_JSON)
    public LoginAPI createLoginAPI(LoginAPI v1)
    {
 	   System.out.println(v1);
 	   repo.create(v1);
 	   return v1;
    }
    
    @PUT
    @Path("loginapi")
    @Consumes(MediaType.APPLICATION_JSON)
    public LoginAPI updateLoginAPI(LoginAPI v1)
    {
 	   System.out.println(v1);
 //	  if (repo.getLoginAPI(v1.getPhonenumber()).getPhonenumber()==0) {
 		   
 		   
 	//	   repo.create(v1);
			
	//	}
 	//   else {
 		   
 		   repo.update(v1);
 	//   }
 	   
 	   return v1;
    }
    
    @DELETE
    @Path("loginapi/{id}")
    public LoginAPI deleteLoginAPI(@PathParam("id") int id)
    
    {
 	   LoginAPI v = repo.getLoginAPI(id);
 	   
 	   if(v.getId()!= 0) 
 		  
 	   repo.delete(id);
 	    
 	   return v;
 	   
    
    }

}
