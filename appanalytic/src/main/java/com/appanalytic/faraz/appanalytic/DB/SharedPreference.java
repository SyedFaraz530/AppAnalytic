package com.appanalytic.faraz.appanalytic.DB;

import android.content.Context;

public class SharedPreference {
    Context context;

    private static SharedPreference instance = null;
    private static String URL = "Url";
    private static String STORAGE_NAME = "Analyitc";

    private SharedPreference(Context context) {
        this.context = context;
    }

    public static SharedPreference getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPreference(context);

        }
        return instance;
    }

    public void saveUrl(String companyCode) {
        save(URL, companyCode);
    }

    public String getUrl() {
        return get(URL, "");
    }

    private void save(String key, String value) {
        context.getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE).edit().putString(key, value.trim()).commit();
    }

    private String get(String key, String def) {
        return context.getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE).getString(key, def);
    }
}
