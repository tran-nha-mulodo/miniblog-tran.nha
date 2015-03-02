package miniblog.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import miniblog.model.UserBlog;
import miniblog.service.UserBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Path("UserBlog")
@Controller
@Produces(MediaType.APPLICATION_JSON)
public class UserBlogController {
	@Autowired
	UserBlogService userBlogServiceImpl;
	
	//Register User
	@POST
	@Path("Register")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response register(UserBlog data){
		int statuscode = 0;
		if(!userBlogServiceImpl.createNewUser(data)){
			statuscode =userBlogServiceImpl.getStatusNumber();
			switch (statuscode){
			 case 1001:	 
				 return Response.status(statuscode).entity("Validate Error!!!").build();
			 case 2001:
				 return Response.status(statuscode).entity("Username has already exist!!!").build();
			}
	}
		return Response.status(userBlogServiceImpl.getStatusNumber()).entity("New user has created!!!").build();
	}
}
