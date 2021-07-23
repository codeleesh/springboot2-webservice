package com.lovethefeel.springboot.common;

import java.text.SimpleDateFormat;
import java.util.*;

public enum DateFormat {

    /**
     * yyyyMMdd 문자열 형식
     */
    YYYYMMDD("yyyyMMdd")
    ,
    /**
     * HHmmss 문자열 형식
     */
    HHMMSS("HHmmss")
    ,
    /**
     * yyyyMMddHHmmss 문자열 형식
     */
    YYYYMMDDHHMMSS("yyyyMMddHHmmss")
    ,
    /**
     * yyyyMMddHHmmssTT ( 1/100초 ) 문자열 형식
     * yyyyMMddHHmmssSSS 문자열(16자리) 포맷으로 사용하여 변환해서 사용해야 함.
     */
    YYYYMMDDHHMMSSTT("yyyyMMddHHmmssSSS")
    ,
    /**
     * yyyy-MM-dd HH:mm:ss.SSSZ 문자열 형식
     */
    YYYY_MM_DD_MILLI_TZONE("yyyy-MM-dd HH:mm:ss.SSSZ")
    ,
    /**
     * yMMddHHmmssSSS 문자열 형식
     * GID 임시 발급
     */
    YMMDDHHMMSSSSS("yMMddHHmmssSSS")
    ;

    private String value;

    DateFormat(final String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    private static final List<DateFormat> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static DateFormat randomLetter () {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    /**
     * 해당 날짜 포맷에 맞게 현재 날짜를 반환한다.
     * 잘못된 날짜 형식일 경우 빈 문자열을 반환
     *
     * @return String
     *
     */
    public String getNowDate() {

        String retValue = "";

        try {

            retValue = new SimpleDateFormat(this.value)
                    .format(Calendar.getInstance().getTime());

            // 표준 전문 날짜 포맷일 경우만
            if ( DateFormat.YYYYMMDDHHMMSSTT == this ) {
                retValue = retValue.substring(0, 16);
            }
        } catch (NullPointerException | IllegalArgumentException
                | IndexOutOfBoundsException e) {
            e.getStackTrace();
        }

        return retValue;
    }
}
