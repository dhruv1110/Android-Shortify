package net.dhruvpatel.shortify;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dhruv on 26-08-2016.
 */
public class JSONParser {

    private static final String TAG = "JSONParser";

    private static Object parseJSON(String path, JSONObject data){
        Object result = null;
        String[] pathParts = path.split("\\.");
        int totalParts = pathParts.length;
        for(int i=0 ; i<totalParts ; i++){
            Log.v(TAG, pathParts[i]);
            if(i == totalParts - 1){
                if(pathParts[i].contains("[") && pathParts[i].contains("]")){
                    try {
                        int indexNumber = Integer.parseInt(pathParts[i].substring(pathParts[i].indexOf("[")+1,pathParts[i].indexOf("]")));
                        JSONArray jsonArray = data.getJSONArray(pathParts[i].substring(0,pathParts[i].indexOf("[")));
                        return jsonArray.getJSONObject(indexNumber);
                    } catch (JSONException e) {
                        Log.e(TAG, e.getMessage());
                    }
                }
                else {
                    try {
                        return data.get(pathParts[i]);
                    } catch (JSONException e) {
                        Log.e(TAG, e.getMessage());
                    }
                }
            }
            else if(pathParts[i].contains("[") && pathParts[i].contains("]")){
                try {
                    int indexNumber = Integer.parseInt(pathParts[i].substring(pathParts[i].indexOf("[")+1,pathParts[i].indexOf("]")));
                    JSONArray jsonArray = data.getJSONArray(pathParts[i].substring(0,pathParts[i].indexOf("[")));
                    data = jsonArray.getJSONObject(indexNumber);
                } catch (JSONException e) {
                    Log.e(TAG, e.getMessage());
                }
            }
            else{
                try {
                    data = data.getJSONObject(pathParts[i]);
                } catch (JSONException e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        }
        return result;
    }

    public static int getIntFromJSON(String path, JSONObject data){
        return (int) parseJSON(path, data);
    }

    public static boolean getBooleanFromJSON(String path, JSONObject data){
        return (boolean) parseJSON(path, data);
    }

    public static String getStringFromJSON(String path, JSONObject data){
        return String.valueOf(parseJSON(path, data));
    }

    public static double getDoubleFromJSON(String path, JSONObject data){
        return (double) parseJSON(path, data);
    }

    public static long getLongFromJSON(String path, JSONObject data){
        return (long) parseJSON(path, data);
    }
}
