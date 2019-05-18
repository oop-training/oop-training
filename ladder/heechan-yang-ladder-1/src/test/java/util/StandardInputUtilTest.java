package util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import util.io.StandardInputUtil;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class StandardInputUtilTest {

    StandardInputUtil standardInputUtil;

    @BeforeAll
    void setUp() {
        System.out.println("INIT InputUtilTest");
        standardInputUtil = new StandardInputUtil();
    }

    @Test
    void inputPeople() throws Exception {
        Method method = StandardInputUtil.class.getDeclaredMethod("inputPeople");
        method.setAccessible(true);

        // given

        //when
//        inputPeopleMethod.invoke();

        //then

    }

    @Test
    void inputResults() throws Exception {
        Method method = StandardInputUtil.class.getDeclaredMethod("inputResults");
        method.setAccessible(true);

        // given

        //when
//        inputPeopleMethod.invoke();

        //then

    }

    @Test
    void inputHeight() throws Exception {
        Method method = StandardInputUtil.class.getDeclaredMethod("inputHeight");
        method.setAccessible(true);

        // given

        //when
//        inputPeopleMethod.invoke();

        //then

    }

    @Test
    void inputTarget() throws Exception {
        Method method = StandardInputUtil.class.getDeclaredMethod("inputTarget");
        method.setAccessible(true);

        // given

        //when
//        inputPeopleMethod.invoke();

        //then

    }
}