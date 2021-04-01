package com.example.learndogri;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.google.android.material.tabs.TabLayout;

/**
 * {@link CategoryAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for
 * each list item based on a data source which is a list of {@link Word} objects.
 */

public class CategoryAdapter extends FragmentStateAdapter {
    private Context mContext;

    public CategoryAdapter(FragmentActivity  fragmentActivity) {
        super(fragmentActivity);
    }


   /* public CategoryAdapter(FragmentManager fm) {
        super(new Fragment());
    }
    */

    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new NumbersFragment();
        } else if (position == 1) {
            return new InterogativeFragment();
        } else {
            return new PhrasesFragment();
        }
    }


    @Override
    public int getItemCount() {
        return 3;
    }



}

/*
public class CategoryAdapter extends FragmentPagerAdapter {

    */
/** Context of the app *//*

    private Context mContext;

    */
/**
 * Create a new {@link CategoryAdapter} object.
 *
 * @param context is the context of the app
 * @param fm is the fragment manager that will keep each fragment's state in the adapter
 *           across swipes.
 *//*

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    */
/**
 * Return the {@link Fragment} that should be displayed for the given page number.
 *//*

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new NumbersFragment();
        } else if (position == 1) {
            return new InterogativeFragment();
        } else {
            return new PhrasesFragment();
        }
    }
    */
/**
 * Return the total number of pages.
 *//*

    @Override
    public int getCount() {
        return 4;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_numbers);
        } else if (position == 1) {
            return mContext.getString(R.string.category_interrogative);
        } else  {
            return mContext.getString(R.string.category_phrases);
        }
    }
}*/
