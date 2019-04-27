package org.ooptraining.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void padding() {
        final String padding = StringUtils.padding(5);

        final String expectedPadding = "     ";
        assertThat(padding).isEqualTo(expectedPadding);
    }

    @Test
    void getRemainPadding1() {
        final String inputKorean = "aabb";
        final int remainPadding = StringUtils.getRemainPadding(inputKorean, 10);

        assertThat(remainPadding).isEqualTo(6);
    }

    @Test
    void getRemainPadding2() {
        final String inputKorean = "abcd";
        final int remainPadding = StringUtils.getRemainPadding(inputKorean, 6);

        assertThat(remainPadding).isEqualTo(2);
    }

    @Test
    void normalize1() {
        final String input2 = "abcde";
        final String expected2 = "abcde";
        assertThat(StringUtils.normalize(input2, 5)).isEqualTo(expected2);
    }

    @Test
    void normalize2() {
        final String input2 = "abcdefgh";
        final String expected2 = "abc..";
        assertThat(StringUtils.normalize(input2, 6)).isEqualTo(expected2);
    }
}