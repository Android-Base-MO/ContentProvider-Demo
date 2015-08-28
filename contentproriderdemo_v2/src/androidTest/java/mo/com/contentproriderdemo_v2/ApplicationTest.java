package mo.com.contentproriderdemo_v2;

import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testSave() {
           /*获取内容解析者*/
        ContentResolver resolver = getContext().getContentResolver();
        //指定.
//        Uri uri = Uri.parse("content://mo.com.contentproriderdemo.SCHOOL/stu");
        Uri uri = Uri.parse("content://mo.com.contentproriderdemo.SCHOOL/stu");

        ContentValues values = new ContentValues();
        values.put("name", "aaaaaa");
        values.put("age", 99);
        resolver.insert(uri, values);
    }
}