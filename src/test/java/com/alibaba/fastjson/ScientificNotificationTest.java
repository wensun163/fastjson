package com.alibaba.fastjson;

import org.junit.Test;

import static com.alibaba.json.bvt.compatible.jsonlib.CompatibleTest_noasm.assertEquals;

public class ScientificNotificationTest {
    String outputKey = "\"rank\"";
    String inputKey = "rank";

    /**
     * This method tests the given number to scientific notation in the given JSON
     * object
     *
     */
    @Test
    public void testScientificNotation() {
        String strObj1 = "{" + outputKey + ": 2.444444444444444E7}";
        String strObj2 = "{" + outputKey + ": 2.4E7}";

        JSONObject jsonObject1 = JSON.parseObject(strObj1);
        JSONObject jsonObject2 = JSON.parseObject(strObj2);

        assertEquals("{" + outputKey + ":\"2.4444444E7\"}",
                ScientificNotification.toJSONScientifcNotation(jsonObject1, inputKey));
        assertEquals("{" + outputKey + ":\"2.4E7\"}",
                ScientificNotification.toJSONScientifcNotation(jsonObject2, inputKey));
    }

    /**
     * This method tests the given billion valued number to scientific notation in
     * the given JSON object
     *
     */
    @Test
    public void testScientificNotationWithBillionValues() {
        String strObj1 = "{" + outputKey + ": 4900000000}";
        String strObj2 = "{" + outputKey + ": 100900000000}";

        JSONObject jsonObject1 = JSON.parseObject(strObj1);
        JSONObject jsonObject2 = JSON.parseObject(strObj2);

        assertEquals("{" + outputKey + ":\"4.9E9\"}",
                ScientificNotification.toJSONScientifcNotation(jsonObject1, inputKey));
        assertEquals("{" + outputKey + ":\"1.009E11\"}",
                ScientificNotification.toJSONScientifcNotation(jsonObject2, inputKey));
    }

    /**
     * This method tests the given million valued number to scientific notation in
     * the given JSON object
     *
     */
    @Test
    public void testScientificNotationWithMillionValues() {
        String strObj1 = "{" + outputKey + ": 2000000000000000000000000000}";
        String strObj2 = "{" + outputKey + ": 1100000}";

        JSONObject jsonObject1 = JSON.parseObject(strObj1);
        JSONObject jsonObject2 = JSON.parseObject(strObj2);

        assertEquals("{" + outputKey + ":\"2E27\"}",
                ScientificNotification.toJSONScientifcNotation(jsonObject1, inputKey));
        assertEquals("{" + outputKey + ":\"1.1E6\"}",
                ScientificNotification.toJSONScientifcNotation(jsonObject2, inputKey));
    }

    /**
     * This method tests the given integer number to scientific notation in the
     * given JSON object
     *
     */
    @Test
    public void testScientificNotationWithIntegerValues() {
        String strObj1 = "{" + outputKey + ": 100}";
        String strObj2 = "{" + outputKey + ": 10000}";

        JSONObject jsonObject1 = JSON.parseObject(strObj1);
        JSONObject jsonObject2 = JSON.parseObject(strObj2);

        assertEquals("{" + outputKey + ":\"1E2\"}",
                ScientificNotification.toJSONScientifcNotation(jsonObject1, inputKey));
        assertEquals("{" + outputKey + ":\"1E4\"}",
                ScientificNotification.toJSONScientifcNotation(jsonObject2, inputKey));
    }

    /**
     * This method tests the given simple and complex decimal number to scientific
     * notation in the given JSON object
     *
     */
    @Test
    public void testScientificNotationWithSimpleAndComplexDecimalValues() {
        String strObj1 = "{" + outputKey + ": 1.1}";
        String strObj2 = "{" + outputKey + ": 100.123456789E7}";

        JSONObject jsonObject1 = JSON.parseObject(strObj1);
        JSONObject jsonObject2 = JSON.parseObject(strObj2);

        assertEquals("{" + outputKey + ":\"1.1E0\"}",
                ScientificNotification.toJSONScientifcNotation(jsonObject1, inputKey));
        assertEquals("{" + outputKey + ":\"1.0012346E9\"}",
                ScientificNotification.toJSONScientifcNotation(jsonObject2, inputKey));
    }

}


