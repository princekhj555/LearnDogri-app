package com.example.learndogri;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;



public class MainActivity extends AppCompatActivity {

    private FragmentStateAdapter pagerAdapter;
    private ViewPager2 viewPager;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);


       /* // Find the view pager that will allow the user to swipe between fragments
        ViewPager2 viewPager = (ViewPager2) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        *//*CategoryAdapter adapter = new CategoryAdapter(getSupportFragmentManager());*//*
        CategoryAdapter adapter1= new CategoryAdapter(getFragmentManager().findFragmentById(R.id.viewpager));

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter1);
*/
        // Instantiate a ViewPager2 and a PagerAdapter.
        viewPager = findViewById(R.id.viewpager);
        pagerAdapter = new CategoryAdapter(this);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setPageTransformer(new DepthPageTransformer());

        TabLayout tabLayout = findViewById(R.id.tab_layout);

        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        if(position==0)
                            tab.setText("Numbers");
                        else if (position==1)
                             tab.setText("Interogative Words");
                        else
                            tab.setText("Phrases");

                    }
                }).attach();


       /* tabLayout.addTab(tabLayout.newTab().setText("Numbers"),0,true);
        tabLayout.addTab(tabLayout.newTab().setText("Interogative Words"),1,true);
        tabLayout.addTab(tabLayout.newTab().setText("Phrases"),2,true);
*/






              /* TabLayoutMediator(tabs, viewpage,
                TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when (position) {
            0 -> { tab.text = "TAB ONE"}
            1 -> { tab.text = "TAB TWO"}
        }
        }).attach();
*/
        /*public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
            TabLayout tabLayout = view.findViewById(R.id.tab_layout);
            new TabLayoutMediator(tabLayout, viewPager,
                    (tab, position) -> tab.setText("OBJECT " + (position + 1))
            ).attach();

        }*/



        /*    // Find the tab layout that shows the tabs
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        // Connect the tab layout with the view pager. This will
        //   1. Update the tab layout when the view pager is swiped
        //   2. Update the view pager when a tab is selected
        //   3. Set the tab layout's tab names with the view pager's adapter's titles
        //      by calling onPageTitle()
        tabLayout.setupWithViewPager(viewPager);*/
    }
    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }
    @RequiresApi(21)
    public static class DepthPageTransformer implements ViewPager2.PageTransformer {
        private static final float MIN_SCALE = 0.75f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0f);

            } else if (position <= 0) { // [-1,0]
                // Use the default slide transition when moving to the left page
                view.setAlpha(1f);
                view.setTranslationX(0f);
                view.setTranslationZ(0f);
                view.setScaleX(1f);
                view.setScaleY(1f);

            } else if (position <= 1) { // (0,1]
                // Fade the page out.
                view.setAlpha(1 - position);

                // Counteract the default slide transition
                view.setTranslationX(pageWidth * -position);
                // Move it behind the left page
                view.setTranslationZ(-1f);

                // Scale the page down (between MIN_SCALE and 1)
                float scaleFactor = MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0f);
            }
        }
    }


/*    public class CollectionDemoFragment extends Fragment {
        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            TabLayout tabLayout = view.findViewById(R.id.tab_layout);
            new TabLayoutMediator(tabLayout, viewPager,
                    (TabLayout.Tab tab, int position) -> {
                        tab.setText(getString(R.string.category_numbers) + (position + 1));
                    }
            ).attach();
        }
    }*/

}