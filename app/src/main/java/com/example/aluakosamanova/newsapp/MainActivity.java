package com.example.aluakosamanova.newsapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Category category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
//        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
//        adapter.addFragment(new FragmentOne(), "RECENT NEWS");
//        adapter.addFragment(new FragmentTwo(), "CATEGORY");
//        viewPager.setAdapter(adapter);
//
//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(viewPager);
        category.setImgSrc("https://www.google.kz/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwiRwOuYi9rWAhWpZpoKHUhdAgUQjRwIBw&url=http%3A%2F%2Fsnappy.appypie.com%2Fmarketplace%2Fsports-mobile-apps&psig=AOvVaw3dtNBgP6qEYTMhCG_adREE&ust=1507313682750651");
        category.setName("Sport");
        category.save();
        recyclerView=(RecyclerView)findViewById(R.id.rvCategories);
        GridLayoutManager mGrid=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(mGrid);
        recyclerView.setHasFixedSize(true);
        List<Category> imageSugar = Category.listAll(Category.class);
        CategoriesAdapter mAdapter = new CategoriesAdapter(this, imageSugar);
        recyclerView.setAdapter(mAdapter);
    }

    // Adapter for the viewpager using FragmentPagerAdapter
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}