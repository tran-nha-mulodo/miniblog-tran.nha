package miniblog.service.imp;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import miniblog.DAO.UserBlogDAO;
import miniblog.DAO.imp.UserBlogDAOImpl;
import miniblog.model.UserBlog;
import miniblog.service.UserBlogService;

public class UserBlogServiceImpl implements UserBlogService {

	UserBlogDAO userDAO;
	int statusNumber;

	public List<UserBlog> getAll() {
		
		return userDAO.getAll();
	}

	public boolean createNewUser(UserBlog user) {
		boolean valid = validateInput(user.getUsername(),user.getPassword(), user.getEmail(),
				user.getLastname(), user.getFirstname(), user.getBirthday(),
				user.getGender(), user.getCreate_date(), user.getModify_date());
		if (!valid) {
			this.statusNumber = 1001;
			return false;
		} 
		else if(!checkUserExist(user.getUsername())){
			userDAO.createNewUser(user);
			this.statusNumber = 200;
			return true;
		}
		else{
			this.statusNumber = 2001;
			return false;
			}
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

	public int getStatusNumber() {
		return this.statusNumber;
	}
	/*
	 * Private area 
	 */
	private boolean checkUserExist(String usernameinput) {
		return userDAO.check(usernameinput);
	}

	private boolean validateInput(String username, String password, String email,
			String lastname, String firstname, String birthday, String gender,
			Date createDate, Date modifyDate) {
		if (null == username || null == email || null == lastname
				|| null == firstname || null == birthday || null == gender
				|| null == createDate || null == modifyDate) {		
			return false;
		}
		if (!lastname.matches("^[ A-z]+") || firstname.matches("^[ A-z]+")
				|| lastname.length() > 40 || firstname.length() > 40) {
			return false;
		}
		if(!username.matches("^[A-z0-9]+$")|| username.length()>40){
			return false;
		}
		if(password.length()>40){
			return false;
		}
		if (!email
				.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$")
				|| email.length() > 50) {
			return false;
		}
		if(!gender.matches("[a-zA-Z]+")){
			return false;
		}
		if(!birthday.matches("(0?[1-9]|1[012])-([12][0-9]|3[01]|0?[1-9])-((?:19|20)\\d\\d)")){
			return false;
		}
		return true;
	}
}
