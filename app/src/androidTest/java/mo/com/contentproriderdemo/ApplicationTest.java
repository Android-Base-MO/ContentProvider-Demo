package mo.com.contentproriderdemo;

import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.test.ApplicationTestCase;

import mo.com.contentproriderdemo.dao.StuDao;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    public ApplicationTest() {
        super(Application.class);
    }
    public void testSave(){
           /*获取内容解析者*/
        ContentResolver resolver = getContext().getContentResolver();
        //指定.
//        Uri uri = Uri.parse("content://mo.com.contentproriderdemo.SCHOOL/stu");
        Uri uri = Uri.parse("content://mo.com.contentproriderdemo.prorider.StuContentProrider/stu");

        ContentValues values  = new ContentValues();
        values.put("name","momomx");
        values.put("age",15);
          resolver.insert(uri, values);
    }

    public void testDaoSave(){
        StuDao dao = new StuDao(getContext());
        ContentValues values = new ContentValues();
        values.put("name","zhangsan");
        values.put("age",12);
        dao.insert(values);
    }
}