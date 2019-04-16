package keven.zcdog.myaarhost;

import android.content.Context;

import com.didi.virtualapk.PluginManager;

/**
 * Created by zhengjian on 2019/4/16.
 */

public class HostMyApp  {
    public static void init(Context context){
        PluginManager.getInstance(context).init();
    }
}
