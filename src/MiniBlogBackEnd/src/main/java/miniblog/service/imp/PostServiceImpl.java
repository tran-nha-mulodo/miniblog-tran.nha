package miniblog.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import miniblog.DAO.PostDAO;
import miniblog.model.Post;
import miniblog.service.PostService;

public class PostServiceImpl implements PostService {

	@Autowired
	PostDAO postDAOImpl;
	int statusNumber = 200;

	public List<Post> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Post> getPostForUser(int authorID) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Post> searchPost(String searchString) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean createNewPost(Post post) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updatePost(int postID, Post post) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deletePost(int postID) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean changeStatus(int postID) {
		// TODO Auto-generated method stub
		return false;
	}

	public Post getPost(int postID) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getStatusNumber() {
		return this.statusNumber;
	}

	/*
	 * Private Area
	 */
	private boolean validateInput(int authorID, String title, String content,
			String status) {
		if (authorID == 0 || null == title || null == content || null == status) {
			return false;
		}
		if (title.length() > 100) {
			return false;
		}
		if (content.length() > 2000) {
			return false;
		}
		if (!status.equals("Available") || !status.equals("Delete")){
			return false;
		}
		return true;
	}
	
	private boolean checkIsDelete(int postID){
		return postDAOImpl.isDelete(postID);
	}
}
