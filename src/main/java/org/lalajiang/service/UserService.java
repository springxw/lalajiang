package org.lalajiang.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public Boolean login(String name, String pwd) {
        if ("admin".equals(name) && "admin110".equals(pwd)) {
            return true;
        }
        return false;
    }
}
