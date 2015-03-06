package miniblog.DAO.imp;

import java.util.List;

import miniblog.DAO.PostDAO;
import miniblog.model.Post;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostDAOImpl implements PostDAO {
	@Autowired
	SessionFactory sessionFactory;

	public void createNewPost(Post post) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(post);
		tx.commit();
	}

	public List<Post> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Post> posts = session.createQuery("FROM Post").list();
		return posts;
	}

	public List<Post> getAllByAuthor(int authorID) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Post> posts = session
				.createQuery("FROM Posts P WHERE p.Author.id = :authorID")
				.setParameter("authorID", authorID).list();
		if (posts.size() < 1) {
			return null;
		}
		return posts;
	}
	
	public List<Post> searchPost(String searchString) {
		// TODO Auto-generated method stub
		return null;
	}

	public Post getPost(int postID) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Post post = (Post) session.get(Post.class, postID);
		return post;
	}

	public void updatePost(int postID, Post newinfo) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Post post = (Post) session.get(Post.class, postID);
		post.setContent(newinfo.getContent());
		post.setStatus(newinfo.getStatus());
		post.setTitle(newinfo.getTitle());
		post.setModify_date(newinfo.getModify_date());
		session.update(post);
		tx.commit();
	}

	public void deletePost(int postID) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Post post = (Post) session.get(Post.class, postID);
		session.delete(post);
		tx.commit();
	}

	public void changeStatus(int postID) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Post post = (Post) session.get(Post.class, postID);
		if (post.getStatus().equals("Available")) {
			post.setStatus("Delete");
		} else {
			post.setStatus("Available");
		}
		tx.commit();
	}

	public boolean isDelete(int postID) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Post post = (Post) session.get(Post.class, postID);
		if (post.getStatus().equals("Delete")) {
			return true;
		}
		return false;
	}

	

}
