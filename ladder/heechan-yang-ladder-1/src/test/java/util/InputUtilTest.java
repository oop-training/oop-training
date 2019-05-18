package util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class InputUtilTest {

    InputUtil inputUtil;

    @BeforeAll
    void setUp() {
        System.out.println("INIT InputUtilTest");
        inputUtil = new InputUtil();
    }

    @Test
    void inputPeople() throws Exception {
        Method method = InputUtil.class.getDeclaredMethod("inputPeople");
        method.setAccessible(true);

        // given

        //when
//        inputPeopleMethod.invoke();

        //then

    }

    @Test
    void inputResults() throws Exception {
        Method method = InputUtil.class.getDeclaredMethod("inputResults");
        method.setAccessible(true);

        // given

        //when
//        inputPeopleMethod.invoke();

        //then

    }

    @Test
    void inputHeight() throws Exception {
        Method method = InputUtil.class.getDeclaredMethod("inputHeight");
        method.setAccessible(true);

        // given

        //when
//        inputPeopleMethod.invoke();

        //then

    }

    @Test
    void inputTarget() throws Exception {
        Method method = InputUtil.class.getDeclaredMethod("inputTarget");
        method.setAccessible(true);

        // given

        //when
//        inputPeopleMethod.invoke();

        //then

    }
}