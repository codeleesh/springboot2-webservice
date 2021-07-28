package com.lovethefeel.springboot.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum AccountType {
    TYPE1("1001", "자유식"),
    TYPE2("1002", "입력식"),
    TYPE3("1003", "출력시"),
    TYPE4("2001", "신용대출"),
    TYPE5("2002", "직장대출");

    private String code;
    private String name;

    AccountType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static AccountType getRandom () {
        List<AccountType> values = Collections.unmodifiableList(Arrays.asList(values()));
        int size = values.size();
        Random random = new Random();
        return values.get(random.nextInt(size));
    }
}
