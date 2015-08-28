package mo.com.contactscontentproviderdemo;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class TabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Notice that setContentView() is not used, because we use the root
        // android.R.id.content as the container for each fragment

        // setup action bar for tabs
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);

       /* ActionBar.Tab tab = actionBar.newTab()
                .setText(R.string.artist)
                .setTabListener(new TabListener<ArtistFragment>(
                        this, "artist", ArtistFragment.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setText(R.string.album)
                .setTabListener(new TabListener<AlbumFragment>(
                        this, "album", AlbumFragment.class));
        actionBar.addTab(tab);*/
    }


}
