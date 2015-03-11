package miniblog.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import miniblog.model.Comment;
import miniblog.modelform.CommentForm;
import miniblog.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Path("Comment")
@Controller
@Produces(MediaType.APPLICATION_JSON)
public class CommentController {

	@Autowired
	UserBlogController userController;
	@Autowired
	PostController postController;
	@Autowired
	CommentService commentServiceImpl;
	int statuscode;
	
	@POST
	@Path("CreateComment")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createNewComment(CommentForm data){
		return Response.status(statuscode).build();
	}
}
