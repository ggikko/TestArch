package test.hello.testarch;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import test.hello.testarch.fragment.TestFragment;
import test.hello.testarch.viewmodel.TestViewModel;

import static test.hello.testarch.R.id.tab;

public class MainActivity extends AppCompatActivity {

    TestPagerAdapter mTestPagerAdapter;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTestPagerAdapter = new TestPagerAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.pager);
        mViewPager.setAdapter(mTestPagerAdapter);

        TestViewModel testViewModel = ViewModelProviders.of(this).get(TestViewModel.class);

        if (testViewModel.getTestItem().get() == null) {
            testViewModel.init();
            testViewModel.setItem("1");
        }

        TabLayout tabLayout = findViewById(tab);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                Log.e("ggikko", "select");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public class TestPagerAdapter extends FragmentStatePagerAdapter {
        public TestPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return new TestFragment();
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Test " + position;
        }
    }
}
