package com.zfdev.puncheur.clock.in;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends Activity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        System.out.println("进入APP");
//    }
    //8.0以上手机需要添加此代码才能正常运行
    public void onResume() {
        super.onResume();
        System.out.println("进入APP 2");
        // 获取要打开的 URI scheme
        String uriScheme = "keep://webview/https%3A%2F%2Fkit.gotokeep.com%2Factivity%2Fpuncheur-clock-in%3Ffullscreen%3Dtrue%26kpwebbtntitlecolor%3D000000";

        // 创建 Intent 对象，用于调用其他应用程序
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uriScheme));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_REQUIRE_NON_BROWSER);

        // 启动应用程序
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            // 处理应用程序未找到的情况
            e.printStackTrace();
        }
        finish();
    }
}
