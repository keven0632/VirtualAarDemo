package keven.zcdog.pluginvirtual;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PluginMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plugin_activity_main);


    }

    public void openWindow(View view){
        MyAlertDialog.showDialog(this);
    }
}
