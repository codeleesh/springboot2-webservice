package com.lovethefeel.springboot.common;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

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
        assertThat(account.getAccountTypeList().size()).isNotNull();
    }

    @Test
    public void getRandomAccountType() {
        String code = "BA";
        AccountType accountType = Account.getRandomAccountType(code);
        assertThat(accountType.getCode()).isNotNull();

        String code1 = "CA";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Account.getRandomAccountType(code1));
    }

    @Test
    public void findByAccountType() {

        AccountType accountType = AccountType.TYPE1;
        assertThat(Account.BA).isEqualTo(Account.findByAccountType(accountType));

        String exceptionCheck = "TYPE7";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Account.findByAccountType(AccountType.valueOf(exceptionCheck)));
    }
}
