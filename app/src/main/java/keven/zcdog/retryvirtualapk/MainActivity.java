package keven.zcdog.retryvirtualapk;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import keven.zcdog.myaarhost.HostMainActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

        }

            TextView tv_click = findViewById(R.id.tv_app);
        tv_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HostMainActivity.class);
                startActivity(intent);

            }
        });
        findViewById(R.id.tv_plugin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("keven.zcdog.pluginvirtual", "keven.zcdog.pluginvirtual.PluginMainActivity");
                startActivity(intent);
            }
        });

        findViewById(R.id.tv_plugin_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class<?> clazz = null;
                try {
                    clazz = Class.forName("keven.zcdog.pluginvirtual.MyAlertDialog");
                    Method showDialog = clazz.getMethod("showDialog", Context.class);
                    showDialog.invoke(null, MainActivity.this);
                } catch (ClassNotFoundException e) {
                    Log.e("TAG","ClassNotFoundException--"+e.toString());
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    Log.e("TAG","NoSuchMethodException--"+e.toString());
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    Log.e("TAG","IllegalAccessException--"+e.toString());
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    Log.e("TAG","InvocationTargetException--"+e.toString());
                    e.printStackTrace();
                }
            }
        });
    }
}
