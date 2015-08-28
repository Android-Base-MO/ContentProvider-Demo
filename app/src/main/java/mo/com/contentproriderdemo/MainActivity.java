package mo.com.contentproriderdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import mo.com.contentproriderdemo.tools.DBUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBUtils helpler = new DBUtils(this);
        helpler.getWritableDatabase();

    }


}
