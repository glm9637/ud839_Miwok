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
public class FamilyFragment extends Fragment {
	
	private MediaItemOnClickListener mMediaItemOnClickListener;
	
	public FamilyFragment() {
		// Required empty public constructor
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.word_list,container,false);
		
		// Create an array of words
		ArrayList<Word> words = new ArrayList<>();
		words.add(new Word("father", "әpә",R.raw.family_father,R.drawable.family_father));
		words.add(new Word("mother", "әṭa",R.raw.family_mother,R.drawable.family_mother));
		words.add(new Word("son", "angsi",R.raw.family_son,R.drawable.family_son));
		words.add(new Word("daughter", "tune",R.raw.family_daughter,R.drawable.family_daughter));
		words.add(new Word("older brother", "taachi",R.raw.family_older_brother,R.drawable.family_older_brother));
		words.add(new Word("younger brother", "chalitti",R.raw.family_younger_brother,R.drawable.family_younger_brother));
		words.add(new Word("older sister", "teṭe",R.raw.family_older_sister,R.drawable.family_older_sister));
		words.add(new Word("younger sister", "kolliti",R.raw.family_younger_sister,R.drawable.family_younger_sister));
		words.add(new Word("grandmother", "ama",R.raw.family_grandmother,R.drawable.family_grandmother));
		words.add(new Word("grandfather", "paapa",R.raw.family_grandfather,R.drawable.family_grandfather));
		
		
		WordAapter itemsAdapter = new WordAapter(getContext(),words,R.color.category_family);
		
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
