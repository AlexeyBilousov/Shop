package com.test.shop;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class Shop {
    private static final int TEN = 10;
    private static final String SPACE = " ";

    public String orderDescription(int count, int id, String locale) {
        StringBuilder order = new StringBuilder();
        order.append(count);
        order.append(SPACE);
        int num = count % TEN;
        order.append(getCorrectWord(num, id, locale));
        return order.toString();
    }

    private String getCorrectWord(int num, int id, String locale) {
        int column;
        String word = null;
        try {
            JSONObject jsonObject = new JSONObject(Constants.DATABASE);
            JSONArray jsonArray = jsonObject.getJSONArray(locale);
            JSONObject jsonWord = jsonArray.getJSONObject(id);
            Iterator<String> iterator = jsonWord.keys();
            while (iterator.hasNext()) {
                column = Integer.parseInt(iterator.next());
                if (column <= num && !iterator.hasNext()) {
                    word = jsonWord.getString(String.valueOf(column));
                }
                if (column <= num) {
                    word = jsonWord.getString(String.valueOf(column));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return word;
    }
}
