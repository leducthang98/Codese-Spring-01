package com.example.shopee.helper.encrypt;

import org.mindrot.jbcrypt.BCrypt;

public class Encryptor {

    public static String bcryptHash(String input) {
        return BCrypt.hashpw(input, BCrypt.gensalt(12)); // 4 - 30
    } // ma hoa

}
