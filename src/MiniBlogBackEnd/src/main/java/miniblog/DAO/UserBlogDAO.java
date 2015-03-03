package miniblog.DAO;

import java.util.List;

import miniblog.model.UserBlog;

public interface UserBlogDAO {
	public void createNewUser(UserBlog user);

	public List<UserBlog> getAll();
	
	public UserBlog getInfo (int id);

	public void deleteUser(int userID);
	
	public void updateUserInfo(int userID, UserBlog newInfo);
	
	public void changePassword(int userID, String newpass);

	public boolean check(String username);
	
	public boolean check(int userID,String password);
	
}
