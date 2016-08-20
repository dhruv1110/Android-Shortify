package net.dhruvpatel.shortify;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by dhruv on 19-08-2016.
 */
public class Binder {
    protected static Activity sActivity;

    public static  <T extends View, E extends String>T bind(int resId){
        Resources res = sActivity.getResources();
        String resourceName = res.getResourceTypeName(resId);
        if(resourceName.equalsIgnoreCase("id")) {
            T cl = (T) sActivity.findViewById(resId);
            return cl;
        }else {
            return null;
        }
    }

    public static String bindStr(int resId){
        Resources res = sActivity.getResources();
        String resourceName = res.getResourceTypeName(resId);
        if(resourceName.equalsIgnoreCase("string")) {
            return res.getString(resId);
        }else{
            return null;
        }
    }

    public static float bindDimen(int resId){
        Resources res = sActivity.getResources();
        String resourceName = res.getResourceTypeName(resId);
        if(resourceName.equalsIgnoreCase("dimen")) {
            return res.getDimension(resId);
        }else{
            return 0f;
        }
    }

    public static Animation bindAnim(int resId){
        Resources res = sActivity.getResources();
        String resourceName = res.getResourceTypeName(resId);
        if(resourceName.equalsIgnoreCase("anim")) {
            return AnimationUtils.loadAnimation(sActivity, resId);
        }else{
            return null;
        }
    }

    public static Drawable bindDrawable(int resId){
        Resources res = sActivity.getResources();
        String resourceName = res.getResourceTypeName(resId);
        if(resourceName.equalsIgnoreCase("drawable")) {
            return res.getDrawable(resId);
        }else{
            return null;
        }
    }

    public static int bindColor(int resId){
        Resources res = sActivity.getResources();
        String resourceName = res.getResourceTypeName(resId);
        if(resourceName.equalsIgnoreCase("color")) {
            return res.getColor(resId);
        }else{
            return 0;
        }
    }

    public static int bindInteger(int resId){
        Resources res = sActivity.getResources();
        String resourceName = res.getResourceTypeName(resId);
        if(resourceName.equalsIgnoreCase("integer")) {
            return res.getInteger(resId);
        }else{
            return 0;
        }
    }

    public static boolean bindBoolean(int resId){
        Resources res = sActivity.getResources();
        String resourceName = res.getResourceTypeName(resId);
        if(resourceName.equalsIgnoreCase("bool")) {
            return res.getBoolean(resId);
        }else{
            return false;
        }
    }

    public static Movie bindMovie(int resId){
        Resources res = sActivity.getResources();
        String resourceName = res.getResourceTypeName(resId);
        if(resourceName.equalsIgnoreCase("movie")) {
            return res.getMovie(resId);
        }else{
            return null;
        }
    }
}
