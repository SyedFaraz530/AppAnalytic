package com.appanalytic.faraz.appanalytic.analytic;

import android.content.Context;
import android.util.Log;

import com.appanalytic.faraz.appanalytic.DB.Helper;
import com.appanalytic.faraz.appanalytic.DB.SharedPreference;
import com.appanalytic.faraz.appanalytic.bean.ScreenViewBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Analytic {
    static Context context;
    SharedPreference sharedPreference;

    public Analytic(Context context) {
        this.context = context;
        sharedPreference = SharedPreference.getInstance(context);
    }

    public void Url(String url) {
        sharedPreference.saveUrl(url);
    }

    //
    public static void open(String screenName, String appVersion, String appUser, String openTime) {
//        String time = getCurrentDateTime("yyyy-MM-dd HH:mm:ss");
        ScreenViewBean viewBean = new ScreenViewBean();
        viewBean.setScreenName(screenName);

        try {
//            String version = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            viewBean.setAddedOn(openTime);
            viewBean.setAppVersion(appVersion);
            viewBean.setOpenTime(openTime);
            viewBean.setAppUser(appUser);
            new Helper(context).add(viewBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close(String openTime) {
        String closeTime = getCurrentDateTime("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ScreenViewBean viewBean = new ScreenViewBean();
        try {
            Date closeDate = format.parse(closeTime);
            Date OpenDate = format.parse(openTime);
            Log.i("+++", "OpenDate: " + OpenDate.getTime() + " Close Date: " + closeDate.getTime());
            long mills = closeDate.getTime() - OpenDate.getTime();

            viewBean.setTimeSpent(mills + "");
            Log.i("+++", " updateScreenView: " + mills);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        viewBean.setCloseTime(closeTime);
        new Helper(context).update(viewBean);
    }

    public static String getCurrentDateTime(String format) {

        Date currentDate = Calendar.getInstance().getTime();
        Log.i("++++", "getAppVersion: " + new SimpleDateFormat(format, Locale.getDefault()).format(currentDate));

        return new SimpleDateFormat(format, Locale.getDefault()).format(currentDate);

    }
}
