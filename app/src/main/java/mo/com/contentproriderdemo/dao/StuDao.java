package mo.com.contentproriderdemo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import mo.com.contentproriderdemo.tools.DBUtils;

/**
 * Created by Administrator on 2015/8/21.
 */
public class StuDao {

    DBUtils helper;

    public StuDao(Context context) {
        helper = new DBUtils(context);
    }

    /**
     * 向数据库中添加的方法
     *@param values 参数
     * @return 返回-1表示添加失败，大于1的数值表示添加成功
     */
    public int insert(ContentValues values) {
        SQLiteDatabase db = helper.getWritableDatabase();
        int count = -1; //插入了多少条记录
        if (db.isOpen()) {
            count = (int) db.insert("stu", null, values);
        }
        db.close();
        return count;
    }

    /**
     * 删除数据库记录
     *
     * @param whereClause 删除条件
     * @param whereArgs   条件的参数
     * @return 影响的记录数
     */
    public int delete(String whereClause, String[] whereArgs) {

        SQLiteDatabase db = helper.getWritableDatabase();
        int count = 0;
        if (db.isOpen()) {
            count = db.delete("stu", whereClause, whereArgs);
        }
        db.close();
        return count;
    }

    /**
     * 更新数据库数据
     * @param values
     * @param selection
     * @param selectionArgs
     * @return  影响的记录数
     */
    public int update (ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase db = helper.getWritableDatabase();
        int count = 0;
        if (db.isOpen()) {
            count = db.update("stu",values,selection,selectionArgs);
        }
        db.close();
        return count;
    }

    /**
     * 查询数据的信息
     *
     * @param selection     查询条件
     * @param selectionArgs 条件产生
     * @return 返回游标Cursor
     */
    public Cursor query( String[] columns, String selection,
                         String[] selectionArgs, String groupBy, String having, String orderBy) {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = null;
        if (db.isOpen()) {
            cursor = db.query("stu", columns,selection,selectionArgs,groupBy, having, orderBy);
        }
        return cursor;
    }

}
