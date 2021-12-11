package com.alibaba.fastjson;

import java.text.DecimalFormat;

/**
 * This class is created for the purpose of converting the number to scientific
 * notation present in a JSON Object
 *
 */
public class ScientificNotification {

    /**
     * This method takes a JSON Object and a key, converts the value of the given
     * key to scientific notation and returns the object as a JSON String
     *
     * @param object for JSONObject
     * @param key for the key of key:value pair of JSONObject
     * @return String for the JSONObject presentation
     */
    public static String toJSONScientifcNotation(final JSONObject object, final String key) {

        object.put(key, new DecimalFormat("0.#######E0").format(object.getDouble(key)));

        return JSON.toJSONString(object);
    }

}
