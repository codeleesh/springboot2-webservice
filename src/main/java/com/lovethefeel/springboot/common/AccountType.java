package com.lovethefeel.springboot.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum AccountType {
    A1001("자유식"),
    A1002("입력식"),
    A1003("출력시"),
    A2001("신용대출"),
    A2002("직장대출");

    private String title;

    AccountType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static AccountType getRandom () {
        List<AccountType> values = Collections.unmodifiableList(Arrays.asList(values()));
        int size = values.size();
        Random random = new Random();
        return values.get(random.nextInt(size));
    }
}
