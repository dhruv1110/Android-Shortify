package net.dhruvpatel.shortify;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.text.util.Linkify;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.dhruvpatel.shortify.interfaces.Task;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dhruv on 19-08-2016.
 */
public class Views {
    private static final String TAG = "Views";
    protected static View mView;
    protected static Activity sViewsActivity;

    public static $ id(int id){
        mView = sViewsActivity.findViewById(id);
        return $.getInstance();
    }

    public static <T extends View>T view(){
        return (T) mView;
    }
    public static $ text(String str){
        try{
            if (mView instanceof android.widget.TextView) {
                android.widget.TextView textView = (android.widget.TextView) mView;
                textView.setText(str);
            } else if (mView instanceof EditText) {
                EditText editText = (EditText) mView;
                editText.setText(str);
            } else if (mView instanceof Button) {
                Button button = (Button) mView;
                button.setText(str);
            }
        }catch (Exception e){
            Log.d(TAG, e.getMessage());
        }
        return $.getInstance();
    }


    public static $ text(int stringResId){
        try {
            String str = sViewsActivity.getResources().getString(stringResId);
            if (mView instanceof TextView) {
                TextView textView = (TextView) mView;
                textView.setText(str);
            } else if (mView instanceof EditText) {
                EditText editText = (EditText) mView;
                editText.setText(str);
            }
            else if(mView instanceof Button){
                Button button = (Button) mView;
                button.setText(str);
            }
        }catch (Exception e){
            Log.d(TAG, e.getMessage());
        }
        return $.getInstance();
    }


    public static String text(){
        String str = "";
        try{
            if(mView instanceof TextView){
                TextView textView = (TextView) mView;
                str = (String) textView.getText().toString();
            }
            else if(mView instanceof EditText){
                EditText editText = (EditText) mView;
                str = (String) editText.getText().toString();
            }
            else if(mView instanceof Button){
                Button button = (Button) mView;
                str = (String) button.getText().toString();
            }
        }catch (Exception e){
            Log.d(TAG, e.getMessage());
        }
        return str;
    }


    public static $ color(int color){
        try {
            if (mView instanceof TextView) {
                TextView textView = (TextView) mView;
                textView.setTextColor(color);
            } else if (mView instanceof EditText) {
                EditText editText = (EditText) mView;
                editText.setTextColor(color);
            } else if (mView instanceof Button) {
                Button button = (Button) mView;
                button.setTextColor(color);
            }
        }catch (Exception e){
            Log.d(TAG, e.getMessage());
        }
        return  $.getInstance();
    }


    public static $ color(String colorhex){
        try{
            if(mView instanceof TextView){
                TextView textView = (TextView) mView;
                textView.setTextColor(Color.parseColor(colorhex));
            }
            else if(mView instanceof EditText){
                EditText editText = (EditText) mView;
                editText.setTextColor(Color.parseColor(colorhex));
            }
            else if(mView instanceof Button){
                Button button = (Button) mView;
                button.setTextColor(Color.parseColor(colorhex));
            }
        }catch (Exception e){
            Log.d(TAG, e.getMessage());
        }
        return  $.getInstance();
    }

    public static $ size(int val){
        try{
            if(mView instanceof TextView){
                TextView textView = (TextView) mView;
                textView.setTextSize(val);
            }
            else if(mView instanceof EditText){
                EditText editText = (EditText) mView;
                editText.setTextSize(val);
            }
            else if(mView instanceof Button){
                Button button = (Button) mView;
                button.setTextSize(val);
            }
        }catch (Exception e){
            Log.d(TAG, e.getMessage());
        }
        return  $.getInstance();
    }

    public static boolean validate(int type){
        boolean validateData = false;
        try{
            if(mView instanceof EditText){
                EditText editText = (EditText) mView;
                String text = editText.getText().toString();
                switch(type){
                    case $.EMPTY:{
                        if(!text.equalsIgnoreCase("")) validateData = true;
                        break;
                    }
                    case $.EMAIL:{
                        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
                        Matcher m = p.matcher(text);
                        boolean matchFound = m.matches();
                        if (matchFound) validateData = true;
                        break;
                    }
                    case $.NUMBER:{
                        if (!text.contains("[a-zA-Z]+")) validateData = true;
                        break;
                    }
                    case $.WEBSITE:{
                        try {
                            URL url = new URL(text);
                            validateData = true;
                        } catch (MalformedURLException e) {
                            validateData = false;
                        }
                        break;
                    }
                }
            }
        }catch (Exception e){
            Log.d(TAG, e.getMessage());
        }
        return validateData;
    }

    public static $ font(String path){
        try{
            Typeface type = Typeface.createFromFile(path);
            if(mView instanceof TextView){
                TextView textView = (TextView) mView;
                textView.setTypeface(type);
            }
            else if(mView instanceof EditText){
                EditText editText = (EditText) mView;
                editText.setTypeface(type);
            }
            else if(mView instanceof Button){
                Button button = (Button) mView;
                button.setTypeface(type);
            }
        }catch (Exception e){
            Log.d(TAG, e.getMessage());
        }
        return  $.getInstance();
    }

    public static $ allcapital(){
        try{
            if(mView instanceof TextView){
                TextView textView = (TextView) mView;
                textView.setAllCaps(true);
            }
            else if(mView instanceof EditText){
                EditText editText = (EditText) mView;
                editText.setAllCaps(true);
            }
            else if(mView instanceof Button){
                Button button = (Button) mView;
                button.setAllCaps(true);
            }
        }catch (Exception e){
            Log.d(TAG, e.getMessage());
        }
        return  $.getInstance();
    }

    public static $ pwd(boolean option){
        try{
            if(mView instanceof TextView){
                TextView textView = (TextView) mView;
                if(option)
                    textView.setTransformationMethod(new PasswordTransformationMethod());
                else
                    textView.setTransformationMethod(null);
            }
            else if(mView instanceof EditText){
                EditText editText = (EditText) mView;
                if(option)
                    editText.setTransformationMethod(new PasswordTransformationMethod());
                else
                    editText.setTransformationMethod(null);
            }
        }catch (Exception e){
            Log.d(TAG, e.getMessage());
        }
        return  $.getInstance();
    }

    public static $ linkify(){
        try{
            if(mView instanceof TextView){
                TextView textView = (TextView) mView;
                Linkify.addLinks(textView, Linkify.ALL);
            }
        }catch (Exception e){
            Log.d(TAG, e.getMessage());
        }
        return  $.getInstance();
    }


    public static $ capitalize(){
        try{
            if(mView instanceof TextView){
                TextView textView = (TextView) mView;
                textView.setInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
            }
        }catch (Exception e){
            Log.d(TAG, e.getMessage());
        }
        return  $.getInstance();
    }


    public static $ selectable(){
        try{
            if(mView instanceof TextView){
                TextView textView = (TextView) mView;
                textView.setTextIsSelectable(true);
            }
        }catch (Exception e){
            Log.d(TAG, e.getMessage());
        }
        return  $.getInstance();
    }

    public static $ show(){
        try{
            mView.setVisibility(View.VISIBLE);
            }catch (Exception e){
                Log.d(TAG, e.getMessage());
            }
        return  $.getInstance();
    }

    public static $ hide(){
        try{
            mView.setVisibility(View.GONE);
            }catch (Exception e){
                Log.d(TAG, e.getMessage());
            }
        return  $.getInstance();
    }

    public static $ gravity(int gravity){
        try{
            if(mView instanceof LinearLayout){
                LinearLayout linearLayout = (LinearLayout) mView;
                linearLayout.setGravity(gravity);
            }
            else if(mView instanceof LinearLayout){
                RelativeLayout relativeLayout = (RelativeLayout) mView;
                relativeLayout.setGravity(gravity);
            }
        }catch (Exception e){
            Log.d(TAG, e.getMessage());
        }
        return  $.getInstance();
    }

    public static $ orientation(int orientation){
        try{
            if(mView instanceof LinearLayout){
                LinearLayout linearLayout = (LinearLayout) mView;
                linearLayout.setOrientation(orientation);
            }
        }catch (Exception e){
            Log.d(TAG, e.getMessage());
        }
        return  $.getInstance();
    }

    public static $ click(final Task Task){
        try{
            if(mView instanceof Button){
                mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Task.perform();
                    }
                });
            }
        }catch (Exception e){
            Log.d(TAG, e.getMessage());
        }
        return  $.getInstance();
    }

}
