package keven.zcdog.retryvirtualapk;

import android.app.Application;
import android.content.Context;

import keven.zcdog.myaarhost.HostMyApp;

/**
 * Created by zhengjian on 2019/4/16.
 */

public class MyAppApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        HostMyApp.init(this);
    }
}
