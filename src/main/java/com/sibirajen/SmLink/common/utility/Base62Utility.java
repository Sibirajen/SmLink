package com.sibirajen.SmLink.common.utility;

import org.springframework.stereotype.Component;

@Component
public class Base62Utility {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int BASE = ALPHABET.length();

    public String encode(long num){
        StringBuilder sb = new StringBuilder();
        while (num > 0){
            sb.append(ALPHABET.charAt((int) num % BASE));
            num /= BASE;
        }
        return sb.reverse().toString();
    }

    public long decode(String str){
        long num = 0;
        for(int i = 0; i < str.length(); i++){
            num = num * BASE + ALPHABET.indexOf(str.charAt(i));
        }
        return num;
    }
}
