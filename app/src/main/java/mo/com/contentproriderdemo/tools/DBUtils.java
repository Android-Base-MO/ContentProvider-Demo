package mo.com.contentproriderdemo.tools;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 数据库
 * Created by Administrator on 2015/8/21.
 */
public class DBUtils extends SQLiteOpenHelper{

    public DBUtils(Context context) {
        super(context, "school.db", null  , 1);
    }


    /**
     * 数据库第一次创建的时回调此方法
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "create table stu(id integer primary key autoincrement," +
                "name varchar,age integer)";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}














