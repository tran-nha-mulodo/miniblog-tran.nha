package miniblog.service.imp;

import java.util.Date;
import java.util.List;

import miniblog.DAO.imp.UserBlogDAOImpl;
import miniblog.model.UserBlog;
import miniblog.service.UserBlogService;

public class UserBlogServiceImpl implements UserBlogService {

	UserBlogDAOImpl userDAO;

	public List<UserBlog> getAll() {

		return null;
	}

	public boolean createNewUser(UserBlog user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteUser(int userID) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateUser(UserBlog user) {
		// TODO Auto-generated method stub
		return false;
	}

	public UserBlog findBy(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean checkUserExist(String usernameinput) {
		return userDAO.check(usernameinput);
	}

	private boolean validateInput(String username, String email,
			String lastname, String firstname, String birthday, String gender,
			Date createDate, Date modifyDate) {
		
		return true;
	}
}
