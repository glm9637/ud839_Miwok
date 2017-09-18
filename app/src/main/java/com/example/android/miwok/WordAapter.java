package com.example.android.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Erzeugt von fengels am 15.09.2017.
 */

public class WordAapter extends ArrayAdapter<Word> {
	
	private int mCategoryColor;
	
	public WordAapter(Context context, ArrayList<Word> words, int categoryColor) {
		super(context, R.layout.list_item, words);
		mCategoryColor = categoryColor;
	}
	
	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
		}
		RelativeLayout objTextContainer = (RelativeLayout) convertView.findViewById(R.id.text_layout);
		objTextContainer.setBackgroundResource(mCategoryColor);
		((TextView) convertView.findViewById(R.id.default_text_view)).setText(getItem(position).getDefaultTranslation());
		((TextView) convertView.findViewById(R.id.miwok_text_view)).setText(getItem(position).getMiwokTranslation());
		if (getItem(position).HasImageAssociated()) {
			((ImageView) convertView.findViewById(R.id.image)).setImageResource(getItem(position).getImageResourceId());
		} else {
			convertView.findViewById(R.id.image).setVisibility(View.GONE);
		}
		convertView.setTag(R.id.tag_media_resource,getItem(position).getMediaResourceId());
		return convertView;
	}
}
