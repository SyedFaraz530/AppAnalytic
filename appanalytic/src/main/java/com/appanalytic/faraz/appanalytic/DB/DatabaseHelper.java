package com.appanalytic.faraz.appanalytic.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static String name = "AppAnalytic";
    private static int version = 1;
    public static String TABLE_SCREEN_VIEW = "ScreenView";
    public static String COLUMN_SCREEN_VIEW_ID = "id";
    public static String COLUMN_SCREEN_VIEW_OPENTIME = "OpenTime";
    public static String COLUMN_SCREEN_VIEW_CLOSETIME = "CloseTime";
    public static String COLUMN_SCREEN_VIEW_ADDEDON = "AddedOn";
    public static String COLUMN_SCREEN_VIEW_SCREENNAME = "ScreenName";
    public static String COLUMN_SCREEN_VIEW_TIME_SPENT = "TimeSpent";
    public static String COLUMN_SCREEN_VIEW_APP_USER = "AppUser";

    public static final String COLUMN_APP_VERSION = "AppVersion";
    private static DatabaseHelper instance = null;
    String queryScreenView = "CREATE TABLE " + TABLE_SCREEN_VIEW + " ( " + COLUMN_SCREEN_VIEW_ID + "" +
            " INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT," +
            " " + COLUMN_SCREEN_VIEW_SCREENNAME + " TEXT ," + COLUMN_SCREEN_VIEW_OPENTIME + " TEXT," +
            " " + COLUMN_SCREEN_VIEW_CLOSETIME + " TEXT, " + COLUMN_SCREEN_VIEW_ADDEDON + " TEXT , " + COLUMN_APP_VERSION + " TEXT , " + COLUMN_SCREEN_VIEW_TIME_SPENT + " TEXT , " + COLUMN_SCREEN_VIEW_APP_USER + " TEXT );";

    public DatabaseHelper(Context context) {
        super(context, name, null, version);
    }

    public static DatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseHelper(context);
        } else if (!instance.getWritableDatabase().isOpen()) {
            instance = new DatabaseHelper(context);
        }

//        if (!instance.getWritableDatabase().isOpen()) {
//            instance.getWritableDatabase().
//        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(queryScreenView);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}