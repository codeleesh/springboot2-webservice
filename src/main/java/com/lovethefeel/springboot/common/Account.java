package com.lovethefeel.springboot.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Account {
    BA("은행", Arrays.asList(AccountType.TYPE1, AccountType.TYPE2, AccountType.TYPE3)),
    CD("카드", Arrays.asList(AccountType.TYPE4, AccountType.TYPE5)),
    EMPTY("없음", Collections.EMPTY_LIST);

    private String name;
    private List<AccountType> accountTypeList;

    Account(String name, List<AccountType> accountTypeList) {
        this.name = name;
        this.accountTypeList = accountTypeList;
    }

    public static Account findByAccountType(AccountType accountType) {
        return Arrays.stream(Account.values())
                .filter(account -> account.hasAccountType(accountType))
                .findAny()
                .orElse(EMPTY);
    }

    // 코드 조회
    public boolean hasAccountType(AccountType accountType) {
        return accountTypeList.stream()
                .anyMatch(account -> account == accountType);
    }

    public static AccountType getRandomAccountType(String code) {
        return getAccountType(code);
    }

    private static AccountType getAccountType(String code) {
        int size = Account.valueOf(code).accountTypeList.size();
        return Account.valueOf(code).accountTypeList.get(new Random().nextInt(size));
    }

    public String getName() {
        return name;
    }

    public List<AccountType> getAccountTypeList() {
        return accountTypeList;
    }
}
