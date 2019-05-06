package keven.zcdog.pluginvirtual;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by zhengjian on 2019/4/30.
 */
public class MyAlertDialog {
    public static void showDialog(final Context context){
        //    通过AlertDialog.Builder这个类来实例化我们的一个AlertDialog的对象
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //    设置Title的图标
        builder.setIcon(R.drawable.head);
        //    设置Title的内容
        builder.setTitle("弹出警告框");
        //    设置Content来显示一个信息
        builder.setMessage("确定删除吗？");
        //    设置一个PositiveButton
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(context, "确定" , Toast.LENGTH_SHORT).show();
            }
        });
        //    设置一个NegativeButton
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(context, "取消" , Toast.LENGTH_SHORT).show();
            }
        });
        //    设置一个NeutralButton
        builder.setNeutralButton("忽略", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(context, "忽略", Toast.LENGTH_SHORT).show();
            }
        });
        //    显示出该对话框
        builder.show();
    }
}
