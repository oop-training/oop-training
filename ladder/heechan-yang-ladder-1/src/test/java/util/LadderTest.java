package util;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    void swapTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Ladder ladder = new Ladder();

        Method swapMethod = Ladder.class.getDeclaredMethod("swap", int[].class,
                int.class,
                int.class);
        swapMethod.setAccessible(true);

        // given
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};

        //when
        swapMethod.invoke(ladder, arr, 0, 3);

        //then
        assertThat(arr).isEqualTo(new int[]{4,2,3,1,5,6});
    }


}