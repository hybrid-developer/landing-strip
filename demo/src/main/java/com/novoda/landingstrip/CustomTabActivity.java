package com.novoda.landingstrip;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.novoda.landing_strip.R;
import com.novoda.landingstrip.setup.Data;
import com.novoda.landingstrip.setup.fragment.DemoFragmentPagerAdapter;

public class CustomTabActivity extends AppCompatActivity {

    private LandingStrip landingStrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_tab);
        setTitle("Demo: " + getClass().getSimpleName());

        landingStrip = (LandingStrip) findViewById(R.id.landing_strip);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new DemoFragmentPagerAdapter(getSupportFragmentManager()));

        landingStrip.attach(viewPager, viewPager.getAdapter(), customTabs);
    }

    @Override
    protected void onDestroy() {
        landingStrip.detach();
        super.onDestroy();
    }

    private final LandingStrip.TabSetterUpper customTabs = new LandingStrip.TabSetterUpper() {
        @Override
        public View setUp(int position, CharSequence title, View inflatedTab) {
            ((TextView) inflatedTab.findViewById(R.id.tab_2_title)).setText("" + position);
            ((ImageView) inflatedTab.findViewById(R.id.tab_2_content)).setImageResource(Data.values()[position].getResId());

            return inflatedTab;
        }
    };

}
