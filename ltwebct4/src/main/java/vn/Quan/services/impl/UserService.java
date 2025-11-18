package vn.Quan.services.impl;

import vn.Quan.dao.IUserDao;
import vn.Quan.dao.impl.UserDaoImpl;
import vn.Quan.models.UserModel;
import vn.Quan.services.IUserService;

public class UserService implements IUserService {
	
	IUserDao userDao = new UserDaoImpl();

	@Override
	public UserModel login(String username, String password) {
	    UserModel user = this.FindByUserName(username);
	    if (user != null && password.equals(user.getPassword())) {
	        return user;
	    }
	    return null;
	}

	@Override
	public UserModel FindByUserName(String username) {
	    return userDao.findByUserName(username);
	}
	
	@Override
	public boolean register(String username, String password, String email, String fullname, String phone) {

	    if (userDao.checkExistUsername(username)) {
	        return false;
	    }

	    long millis = System.currentTimeMillis();
	    java.sql.Date date = new java.sql.Date(millis);

	    UserModel u = new UserModel();
	    u.setUsername(username);
	    u.setPassword(password);
	    u.setEmail(email);
	    u.setFullname(fullname);
	    u.setPhone(phone);
	    u.setImages(null);
	    u.setRoleid(3);  
	    u.setCreateDate(date);

	    userDao.insert(u);
	    return true;
	}

	@Override
	public boolean checkExistEmail(String email) {
	    return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
	    return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
	    return userDao.checkExistPhone(phone);
	}

	@Override
	public void insert(UserModel user) {
	    userDao.insert(user);
	}

	@Override
	public UserModel findByEmail(String email) {
	    return userDao.findByEmail(email);
	}


}
