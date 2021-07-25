package com.lovethefeel.springboot.common;

import java.math.BigDecimal;

public final class ServiceUtils {

    public final static BigDecimal ref = new BigDecimal("1000");
    public final static BigDecimal rateRef = new BigDecimal("100");

    /**
     * 1좌당 가격 = 기준가격 / 1000
     * @param amt
     * @return
     */
    public static BigDecimal getFundOneCalc(BigDecimal amt) {
        return amt.divide(ref, 2, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal getTotalBalance(BigDecimal amt1, BigDecimal amt2) {
        return amt1.divide(amt2, 2, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal getEval(BigDecimal amt1, BigDecimal amt2) {
        return amt1.multiply(amt2).divide(ref, 2, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal getInvest(BigDecimal amt1, BigDecimal amt2) {
        return amt1.subtract(amt2).divide(amt2.divide(rateRef), 2, BigDecimal.ROUND_HALF_UP);
    }
}
