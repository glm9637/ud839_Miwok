package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorsFragment extends Fragment {
	
	private MediaItemOnClickListener mMediaItemOnClickListener;
	
	public ColorsFragment() {
		// Required empty public constructor
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.word_list,container,false);
		
		// Create an array of words
		ArrayList<Word> words = new ArrayList<>();
		words.add(new Word("red", "weṭeṭṭi",R.raw.color_red,R.drawable.color_red));
		words.add(new Word("green", "chokokki",R.raw.color_green,R.drawable.color_green));
		words.add(new Word("brown", "ṭakaakki",R.raw.color_brown,R.drawable.color_brown));
		words.add(new Word("gray", "ṭopoppi",R.raw.color_gray,R.drawable.color_gray));
		words.add(new Word("black", "kululli",R.raw.color_black,R.drawable.color_black));
		words.add(new Word("white", "kelelli",R.raw.color_white,R.drawable.color_white));
		words.add(new Word("dusty yellow", "ṭopiisә",R.raw.color_dusty_yellow,R.drawable.color_dusty_yellow));
		words.add(new Word("mustard yellow", "chiwiiṭә",R.raw.color_mustard_yellow,R.drawable.color_mustard_yellow));
		
		
		WordAapter itemsAdapter = new WordAapter(getContext(),words,R.color.category_colors);
		
		ListView listView = (ListView) rootView.findViewById(R.id.list);
		
		listView.setAdapter(itemsAdapter);
		mMediaItemOnClickListener = new MediaItemOnClickListener((AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE));
		listView.setOnItemClickListener(mMediaItemOnClickListener);
		return rootView;
	}
	
	@Override
	public void onStop() {
		super.onStop();
		mMediaItemOnClickListener.ReleaseMediaPlayer();
	}
}
