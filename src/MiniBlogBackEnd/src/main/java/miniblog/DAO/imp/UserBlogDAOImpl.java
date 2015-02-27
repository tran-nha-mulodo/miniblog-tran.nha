package miniblog.DAO.imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import miniblog.DAO.UserBlogDAO;
import miniblog.model.UserBlog;;

public class UserBlogDAOImpl implements UserBlogDAO {

		private SessionFactory sessionFactory;
		
		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}

		public void createNewUser(UserBlog user) {
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		}

		public List<UserBlog> getAll() {
			Session session = this.sessionFactory.openSession();
			List<UserBlog> listUser = session.createQuery("from UserBlog").list();
			return listUser;
		}

		public void deleteUser(int userID) {
				Session session = sessionFactory.getCurrentSession();
				Transaction tx = session.beginTransaction();
				UserBlog user = (UserBlog) session.load(UserBlog.class, userID);
				session.delete(user);
				tx.commit();
		}

		/* Change/update password to database */
		public void changePassword(int userID, String newpass) {
			
				Session session = sessionFactory.getCurrentSession();
				Transaction tx = session.beginTransaction();
				UserBlog user = (UserBlog) session.load(UserBlog.class, userID);
				user.setPassword(newpass);
				session.update(user);
				tx.commit();
		}

		public boolean check(String username) {
			// TODO Auto-generated method stub
			return false;
		}
}
