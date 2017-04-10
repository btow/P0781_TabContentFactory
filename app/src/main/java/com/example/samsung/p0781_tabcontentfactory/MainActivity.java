package com.example.samsung.p0781_tabcontentfactory;

import android.app.TabActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

@SuppressWarnings("ALL")
public class MainActivity extends TabActivity {

    private String TABS_TAG_1, TABS_TAG_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TABS_TAG_1 = getString(R.string.tag_1);
        TABS_TAG_2 = getString(R.string.tag_2);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabSpec;

        tabSpec = tabHost.newTabSpec(TABS_TAG_1);
        tabSpec.setContent(TabFactory);
        tabSpec.setIndicator(getString(R.string.title_tab_1));

        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec(TABS_TAG_2);
        tabSpec.setContent(TabFactory);
        tabSpec.setIndicator(getString(R.string.title_tab_2));

        tabHost.addTab(tabSpec);
    }

    TabHost.TabContentFactory TabFactory = new TabHost.TabContentFactory() {
        @Override
        public View createTabContent(String tag) {

            if (tag == TABS_TAG_1) {
                return getLayoutInflater().inflate(R.layout.tab, null);
            } else if (tag == TABS_TAG_2) {
                TextView textView = new TextView(MainActivity.this);
                textView.setText(R.string.text_handler);
                return textView;
            }

            return null;
        }
    };
}
