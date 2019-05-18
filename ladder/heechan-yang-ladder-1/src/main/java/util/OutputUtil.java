package util;

import java.util.Map;

public class OutputUtil {

    public void printResult(String[] people, Map resultMap, String target) {
        System.out.println(Constants.TEXT_OUTPUT_RESULTS);

        if (target.equals(Constants.TEXT_ALL)) {
            printAllResult(resultMap, people);
        } else {
            printEachResult(resultMap, target);
        }
    }

    public void printAllResult(Map resultMap, String[] people) {
        for (String key : people) {
            printEachResult(resultMap, key);
        }
    }

    public void printEachResult(Map resultMap, String target) {
        System.out.println(target + " : " + resultMap.get(target));
    }
}
