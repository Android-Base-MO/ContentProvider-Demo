package mo.com.contactscontentproviderdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import mo.com.contactscontentproviderdemo.bean.ContactInfo;
import mo.com.contactscontentproviderdemo.tools.ContactUtils;

public class AllContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_list);

        final List<ContactInfo> list = ContactUtils.getAllCotacts(this);
        ListView lv = (ListView) findViewById(R.id.contact_list);

        lv.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = null;
                if(convertView != null){
                    v = convertView;
                }else{
                   v = View.inflate(AllContactActivity.this,R.layout.item_contact,null);
                }
                RelativeLayout back_relative = (RelativeLayout) v.findViewById(R.id.back_relative);
                TextView contact_name = (TextView) v.findViewById(R.id.contact_name);
                TextView contact_phone = (TextView) v.findViewById(R.id.contact_phone);


                contact_name.setText(list.get(position).getName());
                contact_phone.setText(list.get(position).getPhone());

                if(position%2 == 1){    //切换背景色调
                    back_relative.setBackgroundColor(getResources().getColor(R.color.accent_material_dark));
                }else {
                    back_relative.setBackgroundColor(getResources().getColor(R.color.highlighted_text_material_light));
                }

                return v;
            }
        });




    }

}
