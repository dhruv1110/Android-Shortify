package net.dhruvpatel.shortify;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;

/**
 * Created by dhruv on 04-05-2016.
 */
@SuppressLint("all")
public class $ extends Helper  {
    public static final int HORIZONTAL = 1;
    public static final int SPINNER = 0;
    public static final int EMPTY = 1;
    public static final int EMAIL = 2;
    public static final int NUMBER = 3;
    public static final int WEBSITE = 4;
    public static Activity mActivity;

    private static $ singleton = new $( );
    private static final Integer DAY = 0;
    private static final Integer MONTH = 0;
    private static final Integer YEAR = 0;


    public static $ getInstance( ) {
        return $.singleton;
    }



    public static void init(Activity act){
        Dialogs.sDialogActivity = act;
        Binder.sActivity = act;
        InputHandlers.sInputHandlersActivity = act;
        Views.sViewsActivity = act;
        BasicOperations.sBasicOperationsActivity = act;
        mActivity = act;
        Dialogs.sProgressDialog = new ProgressDialog(act);
    }
    protected static void logError(Exception e){

    }




/*********************************************************************************
    public static class image{
        private int resid = 0;
        private Bitmap bitmap = null;
        private File file;
        private Uri uri;
        private imgSource choice;
        private Bitmap resultBitmap;
        private enum imgSource{
            RESID (0),
            FILEIMAGE (1),
            URI (2),
            BITMAP (3);
            private final int choice;

            imgSource(int c) {
                choice = c;
            }

            public int getChoice() {
                return choice;
            }
        }
        public image(int id){
            resid = id;
            choice = imgSource.RESID;
        }

        public image(File filepath){
            file = filepath;
            choice = imgSource.FILEIMAGE;
        }

        public image(Uri uripath){
            uri = uripath;
            choice = imgSource.URI;
        }

        public image(Bitmap bmp){
            bitmap = bmp;
            choice = imgSource.BITMAP;
        }

        public image crop(int start_x, int start_y, int width, int height){

            switch (choice){
                case RESID:{

                }
            }
            return this;
        }
    }
*************************************************************************************************/

}
