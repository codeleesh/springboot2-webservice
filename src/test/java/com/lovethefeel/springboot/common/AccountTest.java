package com.lovethefeel.springboot.common;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    public void testGetAccount() {
        AccountType accountType = selectAccountType();
        Account account = Account.findByAccountType(accountType);

        assertThat("은행").isEqualTo(account.getTitle());
    }

    private AccountType selectAccountType(){
        return AccountType.A1001;
    }

    @Test
    public void testRandom() {

        AccountType accountType = AccountType.getRandom();
        Account account = Account.findByAccountType(accountType);

        System.out.println(accountType.name());
        System.out.println(accountType.getTitle());
        System.out.println(account.getTitle());
        System.out.println(account.name());
    }

    @Test
    public void getRandomAccountType() {
        String code = "BA";
        System.out.println(Account.getRandomAccountType(code));
    }
}
