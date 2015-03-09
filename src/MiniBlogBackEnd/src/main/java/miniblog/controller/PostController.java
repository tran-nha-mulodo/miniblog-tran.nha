package miniblog.controller;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import miniblog.model.Post;
import miniblog.modelform.PostForm;
import miniblog.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Path("Post")
@Controller
@Produces(MediaType.APPLICATION_JSON)
public class PostController {
	
	@Autowired
	UserBlogController userController;
	@Autowired
	PostService postServiceImpl;
	int statuscode = 200;
	Post post;

	@POST
	@Path("CreatePost")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createNewPost(PostForm data) {
		Post post = new Post();
		post.setAuthor(userController.getUser());
		post.setTitle(data.getTitle());
		post.setContent(data.getContent());
		post.setCreate_date(new Date());
		post.setModify_date(new Date());
		post.setStatus("Available");
		if (!postServiceImpl.createNewPost(post)) {
			statuscode = postServiceImpl.getStatusNumber();
			return Response.status(statuscode).entity("Validate Error!!!")
					.build();
		}
		return Response.status(statuscode).entity("New Post has created!!!")
				.build();
	}
	
	@PUT
	@Path("ChangeStatus")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response changeStatus(@FormParam("PostID")int postID){
		if(!postServiceImpl.changeStatus(postID)){
			statuscode =postServiceImpl.getStatusNumber();
			return Response.status(statuscode).entity("This Post is not exist!!!").build();
		}
		return Response.status(statuscode).entity("Status has changed!!!").build();
	}
	
	@PUT
	@Path("Edit")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response editPost(@FormParam("PostID")int postID, PostForm data){
		Post post = new Post();
		post.setTitle(data.getTitle());
		post.setContent(data.getContent());
		if(!postServiceImpl.updatePost(postID, post)){
			statuscode = postServiceImpl.getStatusNumber();
			return Response.status(statuscode).entity("Validate Error!!!").build();
		}
		return Response.status(statuscode).entity("Post is updated!!!").build();
	}
	
	@POST
	@Path("Delete")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response deletePost(@FormParam("PostID")int postID){
		if(!postServiceImpl.deletePost(postID)){
			statuscode = postServiceImpl.getStatusNumber();
			switch (statuscode){
			case 3001:
				return Response.status(postID).entity("This Post is not exist!!!").build();
			case 3002:
				return Response.status(postID).entity("This Post must be Delete status!!!").build();
			} 
		}
		return Response.status(statuscode).entity("Post is delete!!!").build();
	}
	
	@GET
	@Path("All")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPosts(){
		return Response.status(statuscode).entity(postServiceImpl.getAll()).build();
	}
	
	@GET
	@Path("{userID}/Posts")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPostsForUser(@PathParam("userID")int userID){
		if(null == postServiceImpl.getPostForUser(userID)){
			statuscode = postServiceImpl.getStatusNumber();
			return Response.status(statuscode).entity("No results have found!!!").build();
		}
		return Response.status(statuscode).entity(postServiceImpl.getPostForUser(userID)).build();
	}
	
	@GET
	@Path("Post/{postid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPost(@PathParam("postid")int postID){
		if(null == postServiceImpl.getPost(postID)){
			statuscode = postServiceImpl.getStatusNumber();
			return Response.status(statuscode).entity("Post is not exist!!!").build();
		}
		return Response.status(statuscode).entity(postServiceImpl.getPost(postID)).build();
	}
}
