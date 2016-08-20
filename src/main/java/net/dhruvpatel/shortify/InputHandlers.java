package net.dhruvpatel.shortify;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.DatePicker;
import android.widget.TimePicker;

import net.dhruvpatel.shortify.interfaces.DateListener;
import net.dhruvpatel.shortify.interfaces.TimeListener;

import java.util.Calendar;

/**
 * Created by dhruv on 19-08-2016.
 */
public class InputHandlers {
    private static DatePickerFragment datePickerFragment;
    private static DateListener mDateListner;
    private static TimePickerFragment timePickerFragment;
    private static TimeListener mTimeListner;
    protected static Activity sInputHandlersActivity;

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            mDateListner.onSelect(day, month + 1, year);
        }

    }

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            mTimeListner.onSelect(hourOfDay, minute);
        }
    }

    public static void datePicker(DateListener dateListener){
        datePickerFragment = new DatePickerFragment();
        datePickerFragment.show(sInputHandlersActivity.getFragmentManager(), "datePicker");
        mDateListner = dateListener;
    }

    public static void timePicker(TimeListener timeListener){
        timePickerFragment = new TimePickerFragment();
        timePickerFragment.show(sInputHandlersActivity.getFragmentManager(), "timePicker");
        mTimeListner = timeListener;
    }
}
