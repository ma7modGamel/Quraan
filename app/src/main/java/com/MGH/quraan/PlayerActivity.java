package com.MGH.quraan;


import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.MGH.quraan.Plus.Utilities;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class PlayerActivity extends AppCompatActivity implements OnCompletionListener {
    TextView current_time;
    ImageView image_Rhythm;
    AnimationDrawable mAnimation;



    TextView txt_Status;
    Utilities utils;
    MediaPlayer mp;
    SeekBar songProgressBar;
    ImageButton btnPlay;
    TextView songTitleLabel;
    TextView songTotalDurationLabel, songCurrentDurationLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        AdView mAdView2;

        MobileAds.initialize(this, "ca-app-pub-2736518314640941~6047833569");
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-2736518314640941/6652276719");
        mAdView2 = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        mAdView2.loadAd(adRequest);

        AdView mAdView;


        AdView adView1 = new AdView(this);
        adView1.setAdSize(AdSize.BANNER);
        adView1.setAdUnitId("ca-app-pub-2736518314640941/4130302572");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest2 = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        mAdView.loadAd(adRequest2);

        songProgressBar = (SeekBar) findViewById(R.id.seekbar);
        songTitleLabel = findViewById(R.id.songTitle);
        btnPlay = findViewById(R.id.btnPlay);
        songCurrentDurationLabel = findViewById(R.id.songCurrentDurationLabel);
        songTotalDurationLabel = findViewById(R.id.songTotalDurationLabel);
        image_Rhythm = findViewById(R.id.img_equilizer);
        image_Rhythm.setBackgroundResource(R.drawable.simple_animation);
        mAnimation = (AnimationDrawable) image_Rhythm.getBackground();
        WebView myWebView = findViewById(R.id.webview);
        myWebView.loadUrl("https://alkafeel.net/islamiclibrary/quran/quran/html/quran-03.html#qur003");
        txt_Status = findViewById(R.id.txt_Status);

        // Mediaplayer
        mp = new MediaPlayer();
        processing_actionBar();
        utils = new Utilities();
        songProgressBar.setMax(mp.getDuration());

        // Listeners
        songProgressBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mp.seekTo(songProgressBar.getProgress());

            }
        });
        mp.setOnCompletionListener(this); // Important

        if (URLUtil.isValidUrl(getIntent().getExtras().getString("url"))) {
            playSong(getIntent().getExtras().getString("url"));

            myWebView.loadUrl(getIntent().getExtras().getString("urlPdf"));
            Log.e("1000110001",getIntent().getExtras().getString("urlPdf"));
            Log.e("1000440001",getIntent().getExtras().getString("name"));
        }
        btnPlay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // check for already playing
                if (mp.isPlaying()) {
                    if (mp != null) {
                        mp.pause();
                        stopRhythm();
                        // Changing button image to play button
                        btnPlay.setImageResource(R.drawable.img_btn_play);
                    }
                } else {

                    // Resume song
                    if (mp != null) {
                        mp.start();
                        startRhythm();
                        // Changing button image to pause button
                        btnPlay.setImageResource(R.drawable.img_btn_pause);
                    }
                }

            }
        });


    }

    public void onBackPressed()
    {
        myHandler.removeCallbacks(this.mUpdateTimeTask);
        songProgressBar.setProgress(0);
        finish();
        super.onBackPressed();
    }

    private void startRhythm() {
        image_Rhythm.post(new Runnable() {
            public void run() {
                mAnimation.start();
            }
        });
    }

    private void stopRhythm() {
        image_Rhythm.post(new Runnable() {
            public void run() {
                mAnimation.stop();
            }
        });
    }


    public void playSong(String s) {
        // Play song
        try {

            mp.reset();
            mp.setDataSource(s);
            mp.prepare();
            mp.start();
            startRhythm();

            // Displaying Song title
            String songTitle = getIntent().getExtras().getString("name");
            songTitleLabel.setText(songTitle);


            mp.setOnCompletionListener(new OnCompletionListener() {
                public void onCompletion(MediaPlayer paramAnonymousMediaPlayer) {
                    txt_Status.setText(getString(R.string.text_5));
                    songCurrentDurationLabel.setText("");
                    stopRhythm();
                    btnPlay.setImageResource(R.drawable.img_btn_play);
                }
            });
            // Changing Button Image to pause image
            btnPlay.setImageResource(R.drawable.img_btn_pause);

            // set Progress bar values
            songProgressBar.setProgress(0);
            songProgressBar.setMax(100);
            moveSeekBar();

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void onDestroy()
    {
        super.onDestroy();
        mp.release();
    }


    long totalDuration=0;
    long currentDuration=0;
    int oneTimeOnly = 0;
    Handler myHandler;

    private void moveSeekBar() {

        totalDuration = mp.getDuration();
        currentDuration = mp.getCurrentPosition();
        myHandler = new Handler();
        if (oneTimeOnly == 0) {
            songProgressBar.setMax((int) totalDuration);
            oneTimeOnly = 1;
        }
        songCurrentDurationLabel.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes((long) currentDuration), TimeUnit.MILLISECONDS.toSeconds((long) currentDuration) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) currentDuration))));
        songTotalDurationLabel.setText(String.format("%d min, %d sec",
                TimeUnit.MILLISECONDS.toMinutes(totalDuration),
                TimeUnit.MILLISECONDS.toSeconds(totalDuration) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                toMinutes(totalDuration)))
        );
        songProgressBar.setProgress((int) currentDuration);
        myHandler.postDelayed(mUpdateTimeTask, 50);

    }

    private Runnable mUpdateTimeTask = new Runnable() {
        public void run() {
            if (mp != null) {
                currentDuration = mp.getCurrentPosition();
                songCurrentDurationLabel.setText(String.format("%d min, %d sec",
                        TimeUnit.MILLISECONDS.toMinutes(currentDuration),
                        TimeUnit.MILLISECONDS.toSeconds(currentDuration) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                        toMinutes(currentDuration))));
                songTotalDurationLabel.setText(String.format("%d min, %d sec",
                        TimeUnit.MILLISECONDS.toMinutes(totalDuration),
                        TimeUnit.MILLISECONDS.toSeconds(totalDuration) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                        toMinutes(totalDuration)))
                );

            } else {
                Log.e("ERROORR", "run: ");
            }
            songProgressBar.setProgress((int) currentDuration);
            myHandler.postDelayed(this, 50);
        }
    };



    public void processing_actionBar() {
        getSupportActionBar().setDisplayOptions(R.styleable.ActionBar_indeterminateProgressStyle);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar);
        ((TextView) findViewById(R.id.title_text)).setText(getIntent().getExtras().getString("name"));
    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }
}
