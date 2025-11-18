package vn.Quan.services;

import vn.Quan.models.UserModel;

public interface IUserService {
	
    UserModel login(String username, String password);
    UserModel FindByUserName(String username);
    void insert(UserModel user);
    UserModel findByEmail(String email);

    boolean register(String username, String password, String email, String fullname, String phone);
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);
    boolean checkExistPhone(String phone);
}

