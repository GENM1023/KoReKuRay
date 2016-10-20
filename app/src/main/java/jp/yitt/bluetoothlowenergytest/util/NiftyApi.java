package jp.yitt.bluetoothlowenergytest.util;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by genm1023 on 8/31/16.
 */
public class NiftyApi {
    private static final String TAG = "NiftyApi";
    //private static final String outputFormat = "json";

    public static void getHoge(NiftyApi.Callback callback){
        String url = null;

    }

    public interface Callback{
        void onPostExecute(String str);
    }
}
