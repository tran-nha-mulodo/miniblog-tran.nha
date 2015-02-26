package miniblog.service;

import java.util.List;

import miniblog.model.UserBlog;

public interface UserBlogService {
	public List<UserBlog> getAll();

	public boolean createNewUser(UserBlog user);

	public boolean deleteUser(int userID);

	public boolean updateUser(UserBlog user);

	public UserBlog findBy(int id);
}
