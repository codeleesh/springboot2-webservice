package com.lovethefeel.springboot.common;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

public class DateFormatTest {

    @Test
    public void getNowDate() {
        String formatDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        assertThat(formatDate).isEqualTo(DateFormat.YYYYMMDD.getNowDate());
    }
}
