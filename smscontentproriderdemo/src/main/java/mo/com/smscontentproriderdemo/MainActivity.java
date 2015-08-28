package mo.com.smscontentproriderdemo;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * 使用短信内容提供者，给自己定时发短信（开启装逼模式）包含通知
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 现在的需求是：给自己发送一条银行发来的短信，并在通知状态栏显示消息
     *
     * @param view
     */
    public void send(View view) {


        /*   查看系统上传源码：可以通过查看清单文件来获取内容提供者的信息
        <provider android:name="SmsProvider"
                  android:authorities="sms"
                  android:multiprocess="true"
                  android:readPermission="android.permission.READ_SMS"
                  android:writePermission="android.permission.WRITE_SMS" />*/

        Uri uri = Uri.parse("content://sms");
        //获得内容解析对象
        ContentResolver resolver = getContentResolver();

        //设置短信的信息属性（查看短信的数据库，实质上就是向短信数据库添加信息）

        //我们只要针对其中的几个属性进行添加就行了
        ContentValues values = new ContentValues();
        values.put("type", 1);       //短信类型   1：表示接收到的短信   2：表示发出去的短信
        values.put("date", System.currentTimeMillis());  //短信事件
        values.put("address", "558896");    //发件人
        values.put("body", "尊敬的张先生,您的尾号8976的VIP金卡收到了一笔网银转账交易，金额为：3,000,000.00 ," +
                "当前的活期余额为: 860,800,900.00," +
                "感谢您使用中国农业银行.【农业银行深圳支行】");

        //向短信内容提供者的数据库中添加短信
        resolver.insert(uri, values);

        notifi_1();

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void notifi_1(){
        //高版本代码
        //从系统服务中 得到通知管理者
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //定义一个通知：标题。内容。大图片。小图片
        Notification notification = new Notification.Builder(this)
                .setContentTitle("我是标题")
                .setContentText("我是内容")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher))
                .build();

        //显示通知
        manager.notify(1,notification);

    }
    public void notifi_2(){
        //发送通知
        //低版本兼容的通知
        //得到管理者
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //定义一个通知
        Notification notification =
                new Notification(R.mipmap.ic_launcher,      //状态栏显示的图标
                        "你有一条新的短信信息",           //状态栏显示的信息
                        System.currentTimeMillis());

        //指定跳转的界面
        Intent intent = new Intent();
        intent.setClassName("com.android.mms", "com.android.mms.ui.ConversationList");

        //定义一个PengdingIntent 对象，里面指定点击之后，跳转到什么界面
        PendingIntent contentIntent = PendingIntent.getActivities(MainActivity.this, 1, new Intent[]{intent}, 0);

        //把通知拖拉下来之后显示的内容以及点击之后的去向
        notification.setLatestEventInfo(MainActivity.this,"9958","尊敬的张先生," +
                "您的尾号8976的VIP金卡收到了一笔网银转账交易，金额为：3,000,000.00 ,当前的活期余额为: 860,800,900.00," +
                "感谢您使用中国农业银行.【农业银行深圳支行】",contentIntent);

        //显示通知
        manager.notify(1,notification);
    }


}
