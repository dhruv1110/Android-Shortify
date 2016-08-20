package net.dhruvpatel.shortify;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dhruv on 19-08-2016.
 */
public class BasicOperations {

    protected static Activity sBasicOperationsActivity;

    public static boolean checkIfAppInstalled(String packageName){
        PackageManager pm = sBasicOperationsActivity.getApplicationContext().getPackageManager();
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static void openAppInStore(){
        final String appPackageName = sBasicOperationsActivity.getPackageName();
        try {
            sBasicOperationsActivity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            sBasicOperationsActivity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }

    public static void openAppInStore(String packageName){
        final String appPackageName = packageName;
        try {
            sBasicOperationsActivity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            sBasicOperationsActivity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }


    public static String time(String format){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        //get current date time with Date()
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static boolean checkPermission(String permission){
        boolean permitted = false;
        if (ContextCompat.checkSelfPermission(sBasicOperationsActivity, permission)
                == PackageManager.PERMISSION_GRANTED) {
            permitted = true;
        }
        return permitted;
    }

    public static void toast(String message){
        Toast.makeText(sBasicOperationsActivity.getApplicationContext(),message, Toast.LENGTH_SHORT).show();
    }


    public static void open(Class activityClass) {
        sBasicOperationsActivity.startActivity(new Intent(sBasicOperationsActivity.getApplicationContext(), activityClass));
    }

    public static void open(Class activityClass, Bundle bundle) {
        Intent intent = new Intent(sBasicOperationsActivity.getApplicationContext(), activityClass);
        for (String key : bundle.keySet()) {
            Object value = bundle.get(key);
            if(value instanceof String)
                intent.putExtra(key, String.valueOf(value));
            else if(value instanceof Byte)
                intent.putExtra(key, ((Byte) value).byteValue());
            else if(value instanceof Integer)
                intent.putExtra(key, (int) value);
            else if(value instanceof Double)
                intent.putExtra(key,(double) value);
        }
        sBasicOperationsActivity.startActivity(intent);
    }
}
