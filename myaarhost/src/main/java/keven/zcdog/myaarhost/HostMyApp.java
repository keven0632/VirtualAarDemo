package keven.zcdog.myaarhost;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.content.ContextCompat;

import java.io.File;

/**
 * Created by zhengjian on 2019/4/16.
 */

public class HostMyApp  {
    public static void init(Context context){
//        PluginManager.getInstance(context).init();

        //app_plugin
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            String pluginPath = Environment.getExternalStorageDirectory().getAbsolutePath().concat("/testpulgin.apk");
            File plugin = new File(pluginPath);
            try {
//                PluginManager.getInstance(context).loadPlugin(plugin);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {

//            ActivityCompat.requestPermissions(this,
//                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
        }
    }
}
