package net.dhruvpatel.shortify;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by dhruv on 29-08-2016.
 */
public class AJAX {
    private static final String TAG = "AJAX";
    private static final int GET = 0;
    private static final int POST = 1;

    public static void get(URL url, AJAXCallback callback){
        new HttpTask(url, callback, AJAX.GET, null).execute();
    }

    public static void post(URL url, HashMap<String, Object> queryStringData, AJAXCallback callback){
        new HttpTask(url, callback, AJAX.POST, queryStringData).execute();
    }

    static class HttpTask extends AsyncTask<String, Void, Void> {
        private URL mUrl;
        private String data;
        private AJAXCallback mCallback;
        private int mRequestMethod;
        private HashMap<String, Object>  mQueryStringData;

        public HttpTask(URL url, AJAXCallback callback, int requestMethod, HashMap<String, Object>  queryStringData){
            mRequestMethod = requestMethod;
            mCallback = callback;
            mUrl = url;
            mQueryStringData = queryStringData;
        }
        protected Void doInBackground(String... urls) {

            try {
                InputStreamReader input = null;
                if (mUrl.toString().toLowerCase().startsWith("https://")){
                    HttpsURLConnection conn = (HttpsURLConnection) mUrl.openConnection();
                    if(mRequestMethod == GET)
                        conn.setRequestMethod("GET");
                    else {
                        conn.setRequestMethod("POST");
                        StringBuilder queryStringBuilder = new StringBuilder();
                        Set<String> keys = mQueryStringData.keySet();
                        Iterator<String> keysIterator = keys.iterator();
                        while(keysIterator.hasNext()){
                            String key = keysIterator.next();
                            queryStringBuilder.append(key)
                                    .append("=")
                                    .append(mQueryStringData.get(key))
                                    .append("&");
                        }
                        String urlParameters = queryStringBuilder.toString();

                        conn.setDoOutput(true);
                        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
                        wr.writeBytes(urlParameters);
                        wr.flush();
                        wr.close();
                    }
                    if(conn.getResponseCode() == 200) {
                        input = new InputStreamReader(conn.getInputStream());
                    }
                    conn.disconnect();
                }else{
                    HttpURLConnection conn = (HttpURLConnection) mUrl.openConnection();
                    if(mRequestMethod == GET)
                        conn.setRequestMethod("GET");
                    else {
                        conn.setRequestMethod("POST");
                        StringBuilder queryStringBuilder = new StringBuilder();
                        Set<String> keys = mQueryStringData.keySet();
                        Iterator<String> keysIterator = keys.iterator();
                        while(keysIterator.hasNext()){
                            String key = keysIterator.next();
                            queryStringBuilder.append(key)
                                    .append("=")
                                    .append(mQueryStringData.get(key))
                                    .append("&");
                        }
                        String urlParameters = queryStringBuilder.toString();

                        conn.setDoOutput(true);
                        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
                        wr.writeBytes(urlParameters);
                        wr.flush();
                        wr.close();
                    }
                    if(conn.getResponseCode() == 200) {
                        input = new InputStreamReader(conn.getInputStream());
                    }
                    conn.disconnect();
                }
                if(input != null) {
                    BufferedReader in = new BufferedReader(input);
                    StringBuilder response = new StringBuilder();

                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    data = response.toString();
                    mCallback.onComplete(data);
                }else {
                    mCallback.onComplete("Bad request");
                }
            } catch (Exception e) {
                Log.e(TAG, e.toString());
            }
            return null;
        }
    }

    public interface AJAXCallback{
        public void onComplete(String response);
    }
}
