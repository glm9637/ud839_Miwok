package com.example.android.miwok;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.View;

/**
 * Erzeugt von fengels am 18.09.2017.
 */

public class CategoryPagerAdapter extends FragmentPagerAdapter {
	private Context mContext;
	
	public CategoryPagerAdapter(FragmentManager fm, Context context) {
		super(fm);
		mContext = context;
	}
	
	@Override
	public int getCount() {
		return 4;
	}
	
	@Override
	public Fragment getItem(int position) {
		
		switch (position)
		{
			case 0:
				return new ColorsFragment();
			case 1:
				return new FamilyFragment();
			case 2:
				return new NumbersFragment();
			case 3:
				return new PhrasesFragment();
		}
		return null;
	}
	
	@Override
	public CharSequence getPageTitle(int position) {
		switch (position)
		{
			case 0:
				return  mContext.getString(R.string.category_colors);
			case 1:
				return  mContext.getString(R.string.category_family);
			case 2:
				return  mContext.getString(R.string.category_numbers);
			case 3:
				return  mContext.getString(R.string.category_phrases);
		}
		return "";
	}
}
