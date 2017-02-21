package com.insurance.service.impl;

import com.insurance.entity.User;
import com.insurance.service.UserService;

import javax.inject.Named;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Stoyan on 2/19/2017.
 */
@Named
public class UserServiceImpl implements UserService {

    private static Map<String, User> inMemoryStorage;
    private final Object lock = new Object();

    static {
        inMemoryStorage = new HashMap<>();
    }

    @Override
    public boolean isUserExist(String ID) {
        synchronized (lock){
            return null != inMemoryStorage.get(ID);
        }
    }

    @Override
    public void saveUser(User user) {
        synchronized (lock){
            inMemoryStorage.put(user.getID(), user);
        }
    }

    @Override
    public User getUser(String ID) {
        synchronized (lock){
            return inMemoryStorage.get(ID);
        }
    }
}
