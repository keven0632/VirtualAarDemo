package keven.zcdog.myaarhost;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.didi.virtualapk.PluginManager;

import java.io.File;

public class HostMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_main);
//app_plugin
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            String pluginPath = Environment.getExternalStorageDirectory().getAbsolutePath().concat("/testpulgin.apk");
            File plugin = new File(pluginPath);
            try {
                PluginManager.getInstance(getApplicationContext()).loadPlugin(plugin);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
        }
        TextView tv_host = findViewById(R.id.tv_host);
        tv_host.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("keven.zcdog.pluginvirtual", "keven.zcdog.pluginvirtual.PluginMainActivity");
                startActivity(intent);
            }
        });
    }
}
