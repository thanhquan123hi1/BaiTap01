package vn.Quan.dao;

import java.util.List;

import vn.Quan.models.UserModel;

public interface IUserDao {
	
    List<UserModel> findAll();
    UserModel findById(int id);
    void insert(UserModel user);
    UserModel findByUserName(String username);
    UserModel findByEmail(String email);

    
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);
    boolean checkExistPhone(String phone);

}