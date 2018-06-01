package com.appanalytic.faraz.appanalytic.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.appanalytic.faraz.appanalytic.bean.ScreenViewBean;

public class Helper {
    SQLiteDatabase helper;

    public Helper(Context context) {
        helper = DatabaseHelper.getInstance(context).getWritableDatabase();

    }

    public void add(ScreenViewBean bean) {
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_SCREEN_VIEW_ADDEDON, bean.getAddedOn());
        cv.put(DatabaseHelper.COLUMN_SCREEN_VIEW_OPENTIME, bean.getOpenTime());
        cv.put(DatabaseHelper.COLUMN_SCREEN_VIEW_SCREENNAME, bean.getScreenName());
        cv.put(DatabaseHelper.COLUMN_APP_VERSION, bean.getAppVersion());
        cv.put(DatabaseHelper.COLUMN_APP_VERSION, bean.getAppUser());
        helper.insert(DatabaseHelper.TABLE_SCREEN_VIEW, null, cv);

    }

    public void update(ScreenViewBean bean) {
        String arr[] = {bean.getOpenTime()};
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_SCREEN_VIEW_CLOSETIME, bean.getCloseTime());
        cv.put(DatabaseHelper.COLUMN_SCREEN_VIEW_TIME_SPENT, bean.getTimeSpent());
        helper.update(DatabaseHelper.TABLE_SCREEN_VIEW, cv, DatabaseHelper.COLUMN_SCREEN_VIEW_OPENTIME + "=?", arr);

    }


}
