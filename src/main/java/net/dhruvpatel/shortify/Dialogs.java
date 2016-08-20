package net.dhruvpatel.shortify;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import net.dhruvpatel.shortify.interfaces.Agree;
import net.dhruvpatel.shortify.interfaces.Click;

/**
 * Created by dhruv on 19-08-2016.
 */
public class Dialogs {

    protected static Activity sDialogActivity;
    protected static ProgressDialog sProgressDialog;

    public static void alertDialog(String title, String description){
        AlertDialog.Builder builder = new AlertDialog.Builder(sDialogActivity);
        builder.setMessage(description)
                .setTitle(title);
        AlertDialog dialog = builder.create();
        dialog.show();

    }


    

    public static void confirmDialog(String title, String description, final Click Click) {
        AlertDialog.Builder builder = new AlertDialog.Builder(sDialogActivity);
        builder.setMessage(description)
                .setTitle(title);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Click.ok();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public static void yesNoDialog(String title, String description, final Agree Agree) {
        AlertDialog.Builder builder = new AlertDialog.Builder(sDialogActivity);
        builder.setMessage(description)
                .setTitle(title);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Agree.yes();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Agree.no();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public static $ progressDialog(String title, String description, int style) {
        sProgressDialog.setTitle(title);
        sProgressDialog.setMessage(description);
        sProgressDialog.setProgressStyle(style);
        sProgressDialog.setCancelable(false);
        sProgressDialog.setIndeterminate(false);
        sProgressDialog.show();
        return $.getInstance();
    }

    public static $ max(int i) {
        sProgressDialog.setMax(i);
        return $.getInstance();
    }

    public static $ progress(int i) {
        sProgressDialog.setProgress(i);
        return $.getInstance();
    }

    public static void closeProgress() {
        Dialogs.sProgressDialog.dismiss();
    }
}
