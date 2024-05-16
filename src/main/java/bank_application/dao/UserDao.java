package bank_application.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import bank_application.dto.User;

public class UserDao {
	public EntityManager getManager()
	{
		return Persistence.createEntityManagerFactory("kishor").createEntityManager();
	}
	public void saveUser(User user)
	{
		EntityTransaction transaction=getManager().getTransaction();
			transaction.begin();
			getManager().persist(user);
			transaction.commit();	
	}
	public void editUser(User user,int id) {

		User dbuser = getManager().find(User.class,id);
		EntityTransaction transaction=getManager().getTransaction();

		if (dbuser != null) {
			transaction.begin();
			getManager().merge(user);
			transaction.commit();
		} else {
			System.out.println("User not fount at :" + id);
		}
	}

	public User findUser(int id) {
		
		User user=getManager().find(User.class, id);
		return user;
	}
	public User getAccount(int accno)
	{
		EntityManager manager=getManager();
		Query query=manager.createQuery("SELECT u FROM User u WHERE u.accno=?1");
		query.setParameter(1, accno);
		try {
			User user=(User)query.getSingleResult();
			return user;
		} catch (Exception e) {
			return null;
		}
	}

}
