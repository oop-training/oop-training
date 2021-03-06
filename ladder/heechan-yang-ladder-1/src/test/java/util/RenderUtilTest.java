package util;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class RenderUtilTest {


    @Test
    void getEachWidthTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RenderUtil renderUtil = new RenderUtil();

        Method getEachWidthMethod = RenderUtil.class.getDeclaredMethod("getEachWidth", String[].class, String[].class);
        getEachWidthMethod.setAccessible(true);

        // given
        String[] people1 = new String[]{"4444", "666666", "7777777", "88888888"};
        String[] rewards1 = new String[]{"333", "4444", "55555", "666666"};

        String[] people2 = new String[]{"4444", "666666", "7777777", "7777777", "7777777"};
        String[] rewards2 = new String[]{"333", "4444", "55555", "666666", "88888888"};

        String[] people3 = new String[]{"4444", "666666", "7777777", "88888888", "999999999"};
        String[] rewards3 = new String[]{"333", "4444", "55555", "666666", "7777777"};

        String[] people4 = new String[]{"4444", "666666", "7777777", "88888888", "999999999"};
        String[] rewards4 = new String[]{"333", "4444", "55555", "666666", "1010101010"};

        //when
        int intervalWidth1 = (int) getEachWidthMethod.invoke(renderUtil, people1, rewards1);
        int intervalWidth2 = (int) getEachWidthMethod.invoke(renderUtil, people2, rewards2);
        int intervalWidth3 = (int) getEachWidthMethod.invoke(renderUtil, people3, rewards3);
        int intervalWidth4 = (int) getEachWidthMethod.invoke(renderUtil, people4, rewards4);

        //then
        assertThat(intervalWidth1).isEqualTo(11);
        assertThat(intervalWidth2).isEqualTo(11);
        assertThat(intervalWidth3).isEqualTo(12);
        assertThat(intervalWidth4).isEqualTo(13);
    }

    @Test
    void getHorizontalPrintTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RenderUtil renderUtil = new RenderUtil();

        Method getHorizontalPrintMethod = RenderUtil.class.getDeclaredMethod("getHorizontalPrint", char.class, int.class);
        getHorizontalPrintMethod.setAccessible(true);

        // given
        int intervalWidth1 = 4;
        int intervalWidth2 = 5;
        int intervalWidth3 = 6;

        char char1 = ' ';
        char char2 = '-';
        char char3 = '*';

        //when
        String result1 = (String) getHorizontalPrintMethod.invoke(renderUtil, char1, intervalWidth1);
        String result2 = (String) getHorizontalPrintMethod.invoke(renderUtil, char2, intervalWidth2);
        String result3 = (String) getHorizontalPrintMethod.invoke(renderUtil, char3, intervalWidth3);

        //then
        assertThat(result1).isEqualTo("   ");
        assertThat(result2).isEqualTo("----");
        assertThat(result3).isEqualTo("*****");
    }
}