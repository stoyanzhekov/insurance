package com.insurance.service;

import com.insurance.entity.User;

import javax.inject.Named;
import java.math.BigDecimal;

/**
 * Created by Stoyan on 2/19/2017.
 */

public interface UserService {

    boolean isUserExist(String ID);

    void saveUser(User user);

    User getUser(String ID);
}
