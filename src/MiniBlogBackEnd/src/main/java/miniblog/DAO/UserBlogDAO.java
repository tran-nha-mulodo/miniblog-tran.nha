package miniblog.DAO;

import java.util.List;

import miniblog.model.UserBlog;

public interface UserBlogDAO {
	public void createNewUser(UserBlog user);

	public List<UserBlog> getAll();

	public void deleteUser(int userID);

	public boolean check(String username);
}
