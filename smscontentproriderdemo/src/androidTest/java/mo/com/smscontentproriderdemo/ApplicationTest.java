package mo.com.smscontentproriderdemo;

import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.test.ApplicationTestCase;
import android.util.Log;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    private static final String TAG = "ApplicationTest";

    public ApplicationTest() {
        super(Application.class);
    }

    public void testInsertSms(){
        Uri uri = Uri.parse("content://sms");
        //获得内容解析对象
        ContentResolver resolver = getContext().getContentResolver();

        ContentValues values = new ContentValues();
        values.put("address","15577643712");
        values.put("body","my name is momxmo");
        values.put("type",1);

        Uri count = resolver.insert(uri, values);
        Log.i(TAG,"影响了："+count+"记录");
    }

    //查询短信
    public void testQuery(){
        Uri uri = Uri.parse("content://sms");
        //获得内容解析对象
        ContentResolver resolver = getContext().getContentResolver();

        Cursor cursor = resolver.query(uri, new String[]{"address", "body"}, null, null, null);

        while (cursor.moveToNext()){
            String address = cursor.getString(cursor.getColumnIndex("address"));
            String body = cursor.getString(cursor.getColumnIndex("body"));

            Log.i(TAG,"address:"+address+".......body"+body);
        }
    }
}