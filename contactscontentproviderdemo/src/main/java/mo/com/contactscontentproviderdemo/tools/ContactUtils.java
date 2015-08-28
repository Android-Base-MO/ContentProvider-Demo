package mo.com.contactscontentproviderdemo.tools;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import mo.com.contactscontentproviderdemo.bean.ContactInfo;

/**
 * 获取联系人工具类
 * Created by Administrator on 2015/8/21.
 */
public class ContactUtils {
    private static final String TAG = "ContactUtils";

    /* <provider android:name="ContactsProvider2"
            android:authorities="contacts;com.android.contacts"
            android:label="@string/provider_label"
            android:multiprocess="false"
            android:readPermission="android.permission.READ_CONTACTS"
            android:writePermission="android.permission.WRITE_CONTACTS">
    </provider>
            */

    /**
     * 获取所有联系人的信息
     *
     * @return
     */
    public static List<ContactInfo> getAllCotacts(Context context) {

        //获取内容解析器
        ContentResolver resolver = context.getContentResolver();

        //指定查询的是raw_contact表，注意：这里的主机名和path路径可以通过查看商城应用源码得到
        Uri contactUri = Uri.parse("content://com.android.contacts/raw_contacts");
        Uri datauri = Uri.parse("content://com.android.contacts/data");

        //得到查询的游标结果集，我们这里值需要contact_id就够了
        Cursor cursor_contact = resolver.query(contactUri, new String[]{"contact_id"}, null, null, null);

        List<ContactInfo> list = new ArrayList<ContactInfo>();

        while (cursor_contact.moveToNext()) {
            String id = cursor_contact.getString(0);

            Log.i(TAG, "contact_id---------------->" + id);

            //循环得到一个联系人的时候，将创建出来一个对象
            ContactInfo info = new ContactInfo();
            info.setId(id);


            //注意：这里查询mimetyp_id将会抛出不被识别列的异常,
            // 所以想要查询mimetype，就直接写mimetype就行了
            //执行data表查询的时候，并不是真正查询data表，而是查询data的视图表view_data

            Cursor datacursor = resolver.query(datauri, new String[]{"data1", "mimetype"}, "raw_contact_id=?", new String[]{id}, null);
            
            while (datacursor.moveToNext()){
                String data = datacursor.getString(0);
                String  mimetype = datacursor.getString(1);

                if(mimetype.equals("vnd.android.cursor.item/name")) { //姓名
                    info.setName(data);
                }else if(mimetype.equals("vnd.android.cursor.item/phone_v2")){  //号码
                    info.setPhone(data);
                }else if(mimetype.equals("vnd.android.cursor.item/email_v2")){  //邮箱
                    info.setEmail(data);
                }else if(mimetype.equals("vnd.android.cursor.item/im")){    //
                    info.setIm(data);
                }
            }
            list.add(info);
        }
        cursor_contact.close();

        return list;
    }
}
