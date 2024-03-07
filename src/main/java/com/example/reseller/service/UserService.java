package com.example.reseller.service;

import com.example.reseller.model.dto.user.UserLoginBindingModel;
import com.example.reseller.model.dto.user.UserRegisterBindingModel;

public interface UserService {
    boolean login(UserLoginBindingModel userLoginBindingModel);

    boolean register(UserRegisterBindingModel userRegisterBindingModel);

    void logout();
}
