package mo.com.contactscontentproviderdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //查询所有联系人
    public void findAllContacts(View view){
        Intent intent = new Intent(this,AllContactActivity.class);

        startActivity(intent);
    }

    //查询所有联系人
    public void allcontact(View view){
        Intent intent = new Intent(this,AllContactActivity.class);

        startActivity(intent);
    }

}
