package com.lovethefeel.springboot.common;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;

public class ServiceUtilsTest {

    @Test
    void getFundOneCalc() {
        BigDecimal amt = new BigDecimal("759");

        assertThat(new BigDecimal("0.76")).isEqualTo(ServiceUtils.getFundOneCalc(amt));
    }

    @Test
    void getTotalBalance() {
        BigDecimal depositAmt = new BigDecimal("300000");
        BigDecimal oneFundAmt = new BigDecimal("0.76");

        assertThat(new BigDecimal("394736.84"))
                .isEqualTo(ServiceUtils.getTotalBalance(depositAmt, oneFundAmt));
    }

    @Test
    void getEval() {
        BigDecimal totalFundAmt = new BigDecimal("394736.84");
        BigDecimal standardAmt = new BigDecimal("759");

        assertThat(new BigDecimal("299605.26"))
                .isEqualTo(ServiceUtils.getEval(totalFundAmt, standardAmt));
    }

    @Test
    void getInvestRate() {
        BigDecimal evalAmt = new BigDecimal("299605.26");
        BigDecimal investAmt = new BigDecimal("300000");

        assertThat(new BigDecimal("-0.13"))
                .isEqualTo(ServiceUtils.getInvest(evalAmt, investAmt));
    }
}
