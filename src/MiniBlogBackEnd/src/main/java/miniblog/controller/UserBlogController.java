package miniblog.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.Form;
import org.springframework.beans.factory.annotation.Autowired;

import miniblog.DAO.imp.UserBlogDAOImpl;
import miniblog.model.UserBlog;
import miniblog.service.UserBlogService;
@Path("UserBlog")
public class UserBlogController {
	@Autowired
	UserBlogService userService;
	
	//Register User
	@POST
	@Path("Register")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response register(@Form UserBlog data){
		int statuscode = 0;
		if(!userService.createNewUser(data)){
			statuscode =userService.getStatusNumber();
			switch (statuscode){
			 case 1001:	 
				 return Response.status(statuscode).entity("Validate Error!!!").build();
			 case 2001:
				 return Response.status(statuscode).entity("Username has already exist!!!").build();
			}
	}
		return Response.status(userService.getStatusNumber()).entity("New user has created!!!").build();
	}
}
