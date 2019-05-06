package keven.zcdog.myaarhost;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HostMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_main);

        TextView tv_host = findViewById(R.id.tv_host);
        tv_host.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("keven.zcdog.pluginvirtual", "keven.zcdog.pluginvirtual.PluginMainActivity");
                startActivity(intent);
            }
        });

        findViewById(R.id.tv_host_opendialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Class<?> clazz = null;
                    try {
                        clazz = Class.forName("keven.zcdog.pluginvirtual.MyAlertDialog");
                        Method showDialog = clazz.getMethod("showDialog", Context.class);
                        showDialog.invoke(null, HostMainActivity.this);
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
