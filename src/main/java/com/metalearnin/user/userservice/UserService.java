package com.metalearnin.user.userservice;

import com.metalearnin.user.userdto.UserSignUpDTO;

public interface UserService {

    boolean usersave(UserSignUpDTO userSignUpDTO);
}
