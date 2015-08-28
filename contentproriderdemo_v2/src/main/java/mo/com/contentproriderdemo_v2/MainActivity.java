package mo.com.contentproriderdemo_v2;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * 外部程序向内容提供者操作数据库信息
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 向内容提供者的数据库中添加信息
     * @param view
     */
    public void save(View view) {

        /*获取内容解析者*/
        ContentResolver resolver = getContentResolver();
        //指定.
//        Uri uri = Uri.parse("content://mo.com.contentproriderdemo.SCHOOL/stu");
        Uri uri = Uri.parse("content://mo.com.contentproriderdemo.SCHOOL/stu");

        ContentValues values  = new ContentValues();
        values.put("name","momomx");
        values.put("age",15);
        resolver.insert(uri,values);

    }

    /**
     * 删除内容提供者的数据库信息
     * @param view
     */
    public void delete(View view) {

         /*获取内容解析者*/
        ContentResolver resolver = getContentResolver();

        //指定.
        Uri uri = Uri.parse("content://mo.com.contentproriderdemo.SCHOOL/stu");
        resolver.delete(uri, "name=?", new String[]{"momomx"});
    }


    /**
     * 修改内容提供的信息
     * @param view
     */
    public void update(View view) {

           /*获取内容解析者*/
        ContentResolver resolver = getContentResolver();

        //指定.
        Uri uri = Uri.parse("content://mo.com.contentproriderdemo.SCHOOL/stu");
        ContentValues values = new ContentValues();
        values.put("name","lisi");
        values.put("age",55);

        resolver.update(uri,values,"name=?",new String[]{"momomx"});
    }


    /**
     * 查询内容提供的数据库信息
     * @param view
     */
    public void query(View view) {

             /*获取内容解析者*/
        ContentResolver resolver = getContentResolver();

        //指定.
        Uri uri = Uri.parse("content://mo.com.contentproriderdemo.SCHOOL/stu");

        Cursor cursor = resolver.query(uri, null, null, null, null);
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            int age = cursor.getInt(cursor.getColumnIndex("age"));

            Log.i(TAG,"name="+name+"-----age="+age);
        }
    }

}
