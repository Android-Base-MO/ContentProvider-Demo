package mo.com.contentproriderdemo.prorider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import mo.com.contentproriderdemo.dao.StuDao;

/**
 * 学生数据库内容提供者
 * Created by Administrator on 2015/8/21.
 */
public class StuContentProrider extends ContentProvider {
    
    static UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    private static final int SUCCESS = 1;

    static {
        uriMatcher.addURI("mo.com.contentproriderdemo.SCHOOL","stu",SUCCESS);
    }
    
    @Override
    public boolean onCreate() {
        return false;
    }

    /**
     * 查询数据库
     * @param uri
     * @param projection
     * @param selection
     * @param selectionArgs
     * @param sortOrder
     * @return
     */
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        int code = uriMatcher.match(uri);
        Cursor cursor = null;
        if (code == SUCCESS){
            StuDao dao = new StuDao(getContext());
            cursor = dao.query(projection,selection,selectionArgs,null,null,sortOrder);
        }else {
            throw new IllegalArgumentException("这儿不是你完的地方");
        }
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    /**
     * 添加记录
     * @param uri
     * @param values
     * @return
     */
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        int code = uriMatcher.match(uri);
        if (code == SUCCESS){
            StuDao dao = new StuDao(getContext());
            dao.insert(values);
        }else {
            throw new IllegalArgumentException("这儿不是你完的地方");
        }
        return null;
    }

    /**
     * 删除记录
     * @param uri
     * @param selection
     * @param selectionArgs
     * @return
     */
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int code = uriMatcher.match(uri);
        int count = 0;
        if (code == SUCCESS){
            StuDao dao = new StuDao(getContext());
            count = dao.delete(selection,selectionArgs);
        }else {
            throw new IllegalArgumentException("这儿不是你完的地方");
        }
        return count;
    }

    /**
     * 数据库的更新
     * @param uri
     * @param values
     * @param selection
     * @param selectionArgs
     * @return
     */
    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {

        int code = uriMatcher.match(uri);
        int count = 0;
        if (code == SUCCESS){
            StuDao dao = new StuDao(getContext());
            count = dao.update(values,selection,selectionArgs);
        }else {
            throw new IllegalArgumentException("这儿不是你完的地方");
        }
        return count;
    }
}
