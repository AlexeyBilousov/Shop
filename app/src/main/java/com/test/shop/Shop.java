package com.test.shop;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Shop {
    private static final int TEN = 10;
    private static final String INVALID = "Invalid order settings";
    private static final String SPACE = " ";

    public String orderDescription(int count, int id, String locale) {
        StringBuilder order = new StringBuilder();
        order.append(count);
        order.append(SPACE);
        int num = count % TEN;
        switch (locale) {
            case Constants.EN:
                    order.append(getCorrectWordEn(num, count, id, locale));
                break;
            case Constants.RU:
                    order.append(getCorrectWordRu(num, count, id, locale));
                break;
            default:
                order = new StringBuilder(INVALID);
        }
        return order.toString();
    }

    private String getCorrectWordRu(int num, int count, int id, String locale) {
        String word;
        if (num == 1 && count != 11) {
            word = getWordWithJSON(id, locale, Constants.ONE);
        } else if (num > 1 && num < 5 && (count > 14 || count < 11)) {
            word = getWordWithJSON(id, locale, Constants.TWO_FOUR);
        } else {
            word = getWordWithJSON(id, locale, Constants.FIVE_NINE_ZERO);
        }
        return word;
    }

    private String getCorrectWordEn(int num, int count, int id, String locale) {
        String word;
        if (num == 1) {
            word = getWordWithJSON(id, locale, Constants.ONE);
        } else {
            word = getWordWithJSON(id, locale, Constants.TWO_FOUR);
        }
        return word;
    }

    private String getWordWithJSON(int id, String locale, String column) {
        String word = null;
        try {
            JSONObject jsonObject = new JSONObject(Constants.DATABASE);
            JSONArray jsonArray = jsonObject.getJSONArray(locale);
            JSONObject jsonWord = jsonArray.getJSONObject(id);
            word = jsonWord.getString(column);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return word;
    }
}
