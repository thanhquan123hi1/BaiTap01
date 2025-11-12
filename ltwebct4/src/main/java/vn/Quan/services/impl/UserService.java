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


}
