package dao;

import model.User;

public interface UserDao {
	public void addUser(User u);
	public User getUser(String id);

}
