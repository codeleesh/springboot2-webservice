package com.lovethefeel.springboot.common;

public enum AccountType {
    A1001("자유식"),
    A1002("입력식"),
    A1003("출력시"),
    A2001("신용대출"),
    A2002("직장대출"),
    EMPTY("없음");

    private String title;

    AccountType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
