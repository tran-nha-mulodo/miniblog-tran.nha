package frontend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import frontend.model.Post;
import frontend.service.PostService;

@Controller
@RequestMapping(value="Post")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@RequestMapping(value="AllPostsUser",method = RequestMethod.POST)
	public String allpostsuser(@RequestParam("userid")int userid, Model model){
		List<Post> posts = postService.getPostForUser(userid);
		model.addAttribute("Posts", posts);
		return "allpostuser";
	}
	/*---------------------------
	 --------Return page---------
	 ---------------------------*/
	@RequestMapping(value="EditPost",method=RequestMethod.POST)
	public String editpost(@RequestParam("postid")int postid,Model model){
		Post post = postService.getPostInfo(postid);
		model.addAttribute("Post", post);
		return "editpost";
	}
	
}
