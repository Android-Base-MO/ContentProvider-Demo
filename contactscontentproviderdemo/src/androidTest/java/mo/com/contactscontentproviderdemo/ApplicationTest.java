package mo.com.contactscontentproviderdemo;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import java.util.List;

import mo.com.contactscontentproviderdemo.bean.ContactInfo;
import mo.com.contactscontentproviderdemo.tools.ContactUtils;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    private static final String TAG = "ApplicationTest";

    public ApplicationTest() {
        super(Application.class);
    }

    public void testContactAll(){
        List<ContactInfo> list = ContactUtils.getAllCotacts(getContext());

        for (ContactInfo info:list) {
            Log.i(TAG,info.toString());
        }

    }
}