package net.dhruvpatel.shortify;

import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;

import net.dhruvpatel.shortify.interfaces.DateListener;
import net.dhruvpatel.shortify.interfaces.TimeListener;
import net.dhruvpatel.shortify.interfaces.Task;
import net.dhruvpatel.shortify.interfaces.Agree;
import net.dhruvpatel.shortify.interfaces.Click;

/**
 * Created by dhruv on 19-08-2016.
 */
public class Helper {
    public static  <T extends View, E extends String>T bind(int resId){
        return Binder.bind(resId);
    }

    public static String bindStr(int resId){
        return Binder.bindStr(resId);
    }

    public static float bindDimen(int resId){
        return Binder.bindDimen(resId);
    }

    public static Animation bindAnim(int resId){
        return Binder.bindAnim(resId);
    }

    public static Drawable bindDrawable(int resId){
        return Binder.bindDrawable(resId);
    }

    public static int bindColor(int resId){
        return Binder.bindColor(resId);
    }

    public static int bindInteger(int resId){
        return Binder.bindInteger(resId);
    }

    public static boolean bindBoolean(int resId){
        return Binder.bindBoolean(resId);
    }

    public static Movie bindMovie(int resId){
        return Binder.bindMovie(resId);
    }

    public static void alertDialog(String title, String description){
        Dialogs.alertDialog(title,description);
    }

    public static void confirmDialog(String title, String description, final Click Click) {
        Dialogs.confirmDialog(title, description, Click);
    }

    public static void yesNoDialog(String title, String description, final Agree Agree) {
        Dialogs.yesNoDialog(title, description, Agree);
    }

    public static $ progressDialog(String title, String description, int style) {
        return Dialogs.progressDialog(title, description, style);
    }

    public $ max(int i) {
        return Dialogs.max(i);
    }

    public $ progress(int i) {
        return Dialogs.progress(i);
    }

    public static void closeProgress() {
        Dialogs.closeProgress();
    }

    public static void datePicker(DateListener dateListener){
        InputHandlers.datePicker(dateListener);
    }

    public static void timePicker(TimeListener timeListener){
        InputHandlers.timePicker(timeListener);
    }

    public static $ id(int id){
        return Views.id(id);
    }

    public static <T extends View>T view(){
        return Views.view();
    }

    public  $ text(String str){
        return Views.text(str);
    }

    public $ text(int stringResId){
        return Views.text(stringResId);
    }

    public static String text(){
        return Views.text();
    }

    public $ color(int color){
        return Views.color(color);
    }

    public $ color(String colorhex){
        return Views.color(colorhex);
    }

    public $ size(int val){
        return Views.size(val);
    }

    public static boolean validate(int type){
        return Views.validate(type);
    }

    public $ font(String path){
        return Views.font(path);
    }

    public $ allcapital(){
        return Views.allcapital();
    }

    public $ pwd(boolean option){
        return Views.pwd(option);
    }

    public $ linkify(){
        return Views.linkify();
    }

    public $ capitalize(){
        return Views.capitalize();
    }

    public $ selectable(){
        return Views.selectable();
    }

    public $ show(){
        return Views.show();
    }

    public $ hide(){
        return Views.hide();
    }

    public $ gravity(int gravity){
        return Views.gravity(gravity);
    }

    public $ orientation(int orientation){
        return Views.orientation(orientation);
    }

    public $ click(final Task task){
        return Views.click(task);
    }

    public static boolean checkIfAppInstalled(String packageName){
        return BasicOperations.checkIfAppInstalled(packageName);
    }

    public static void openAppInStore(){
        BasicOperations.openAppInStore();
    }

    public static void openAppInStore(String packageName){
        BasicOperations.openAppInStore(packageName);
    }

    public static String time(String format){
        return BasicOperations.time(format);
    }

    public static boolean checkPermission(String permission){
        return BasicOperations.checkPermission(permission);
    }

    public static void toast(String message){
        BasicOperations.toast(message);
    }

    public static void open(Class activityClass) {
        BasicOperations.open(activityClass);
    }

    public static void open(Class activityClass, Bundle bundle) {
        BasicOperations.open(activityClass, bundle);
    }
}
