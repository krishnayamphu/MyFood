package com.myfood;

import com.myfood.dao.UserDAO;
import org.apache.commons.codec.digest.DigestUtils;

public class TestApp {
    public static void main(String[] args) {
//        System.out.println(DigestUtils.sha256Hex("a123"));
        System.out.println(UserDAO.auth("admin",DigestUtils.sha256Hex("a123")));
    }
}
