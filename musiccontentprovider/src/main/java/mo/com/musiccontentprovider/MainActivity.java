package mo.com.musiccontentprovider;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取多媒体的内容提供者

        ContentResolver resolver= getContentResolver();

        Intent intent= new Intent();

        Uri uri = Uri.parse("content://media/files");

        resolver.query(uri,new String[]{"_data","mime_type",
                "_size","title","_display_name",""},null,null,null);
    }


















}
