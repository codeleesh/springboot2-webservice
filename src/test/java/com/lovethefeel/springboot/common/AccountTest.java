package com.lovethefeel.springboot.common;

import org.junit.Test;
import org.springframework.security.core.parameters.P;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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

}
