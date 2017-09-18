package com.example.android.miwok;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * Erzeugt von fengels am 18.09.2017.
 */

public class MediaItemOnClickListener implements AdapterView.OnItemClickListener {
	private MediaPlayer mMediaPlayer;
	private AudioManager mAudioManager;
	private AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener;
	
	public MediaItemOnClickListener(AudioManager audioManager)
	{
		mAudioManager = audioManager;
		mAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
			@Override
			public void onAudioFocusChange(int i) {
				switch (i){
					case AudioManager.AUDIOFOCUS_LOSS:
						ReleaseMediaPlayer();
						break;
					case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
						if(mMediaPlayer!=null) {
							mMediaPlayer.pause();
							mMediaPlayer.seekTo(0);
						}
						break;
					case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
						if(mMediaPlayer!=null)
						{
							mMediaPlayer.pause();
							mMediaPlayer.seekTo(0);
						}
					case AudioManager.AUDIOFOCUS_GAIN:
						if(mMediaPlayer!=null){
							mMediaPlayer.start();
						}
				}
				
			}
		};
	}
	
	@Override
	public void onItemClick(AdapterView<?> adapterView, final View view, int i, long l) {
		int MediaId = Integer.parseInt(view.getTag(R.id.tag_media_resource).toString());
		mMediaPlayer = MediaPlayer.create(view.getContext(), MediaId);
		int result = mAudioManager.requestAudioFocus(mAudioFocusChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
		if(result==AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
			
			mMediaPlayer.start();
			mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mediaPlayer) {
					ReleaseMediaPlayer();
				}
			});
		}else{
			ReleaseMediaPlayer();
			Toast.makeText(view.getContext(),"Could not play Audio",Toast.LENGTH_LONG).show();
		}
	}
	
	public void ReleaseMediaPlayer()
	{
		if(mMediaPlayer!=null)
		{
			mAudioManager.abandonAudioFocus(mAudioFocusChangeListener);
			mMediaPlayer.release();
			mMediaPlayer = null;
		}
	}
}
