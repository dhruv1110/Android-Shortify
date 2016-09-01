package net.dhruvpatel.shortify;

import android.app.Activity;
import android.app.ProgressDialog;

/**
 * Created by dhruv on 04-05-2016.
 */
public class $ extends Helper  {
    public static final int HORIZONTAL = 1;
    public static final int SPINNER = 0;
    public static final int EMPTY = 1;
    public static final int EMAIL = 2;
    public static final int NUMBER = 3;
    public static final int WEBSITE = 4;

    private static $ singleton = new $( );


    protected static $ getInstance() {
        return $.singleton;
    }

    public static void init(Activity act){
        Dialogs.sDialogActivity = act;
        Binder.sActivity = act;
        InputHandlers.sInputHandlersActivity = act;
        Views.sViewsActivity = act;
        BasicOperations.sBasicOperationsActivity = act;
        Dialogs.sProgressDialog = new ProgressDialog(act);
    }

}
