package vn.Quan.services;

import vn.Quan.models.UserModel;

public interface IUserService {
    UserModel login(String username, String password);

    UserModel FindByUserName(String username);
}

