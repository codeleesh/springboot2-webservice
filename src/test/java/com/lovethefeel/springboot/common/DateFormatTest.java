package com.lovethefeel.springboot.common;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DateFormatTest {

    @Test
    public void testRandomLetter() {
        assertThat(DateFormat.randomLetter()).isNotNull();
    }
}
