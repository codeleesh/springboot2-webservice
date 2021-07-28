package com.lovethefeel.springboot.common;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AccountTest {

    @Test
    public void testGetAccount() {
        AccountType accountType = selectAccountType();
        Account account = Account.findByAccountType(accountType);

        assertThat("은행").isEqualTo(account.getName());
    }

    private AccountType selectAccountType(){
        return AccountType.TYPE1;
    }

    @Test
    public void testRandom() {

        AccountType accountType = AccountType.getRandom();
        Account account = Account.findByAccountType(accountType);

        assertThat(3).isEqualTo(account.getAccountTypeList().size());
    }

    @Test
    public void getRandomAccountType() {
        String code = "BA";
        AccountType accountType = Account.getRandomAccountType(code);
    }
}
