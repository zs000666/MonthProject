package bwie.com.lib_core.utils;

import android.util.Log;

import bwie.com.lib_core.common.Constans;

/**
 * date:2019/7/9
 * name:windy
 * function:
 */
public class LogUtils {
    private static final String TAG=LogUtils.class.getSimpleName();
    public static void v(String msg){
        if (!Constans.IS_RELEASE){ //false的时候
            Log.d(TAG,msg);
        }
    }

    public static void e(String msg){
        if (!Constans.IS_RELEASE){//如果不是正式版环境
            Log.e(TAG,msg);
        }
    }
}
