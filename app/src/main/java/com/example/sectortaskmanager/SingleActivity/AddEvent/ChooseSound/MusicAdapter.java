package com.example.sectortaskmanager.SingleActivity.AddEvent.ChooseSound;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sectortaskmanager.R;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private List<Music> musicList;
    private MediaPlayer mediaPlayer;
    private Boolean isMusicNotCreated = true;
    private Boolean isClicked = false;


    public MusicAdapter(Context context, List<Music> musicList) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.musicList = musicList;
    }

    @NonNull
    @Override
    public MusicAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.music_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MusicAdapter.ViewHolder holder, int position) {
        final Music music = musicList.get(position);

        holder.musicNameTextView.setText(music.getMusicName());
        holder.singerNameTextView.setText(music.getSingerName());

      View.OnClickListener onClickListener = new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              switch (view.getId()){
                  case R.id.playButton:
                      if (mediaPlayer != null){
                          mediaPlayer.release();
                          isMusicNotCreated = true;
                      }
                      playMusic(music, holder);
                      break;
                  case R.id.stopButton:
                      stopMusic(holder);
                      break;
              }
          }
      };

      holder.playButton.setOnClickListener(onClickListener);
      holder.stopButton.setOnClickListener(onClickListener);
    }

    private void stopMusic(MusicAdapter.ViewHolder holder) {
        if (!isMusicNotCreated) {
            mediaPlayer.stop();
            mediaPlayer.release();
            isMusicNotCreated = true;
        }
        holder.playButton.setImageResource(R.drawable.ic_baseline_play_arrow_24);

    }

    private void playMusic(Music music, MusicAdapter.ViewHolder holder) {
        if (isMusicNotCreated) {
            mediaPlayer = MediaPlayer.create(context, music.getMusic());
            isMusicNotCreated = false;
            isClicked = true;
        }
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            holder.playButton.setImageResource(R.drawable.ic_baseline_play_arrow_24);

        } else {
            mediaPlayer.start();
            holder.playButton.setImageResource(R.drawable.ic_baseline_pause_24);
        }



    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView musicNameTextView, singerNameTextView;
        final ImageView playButton, stopButton;

        ViewHolder(View view) {
            super(view);
            musicNameTextView = view.findViewById(R.id.musicNameTextView);
            singerNameTextView = view.findViewById(R.id.singerNameTextView);
            playButton = view.findViewById(R.id.playButton);
            stopButton = view.findViewById(R.id.stopButton);

        }
    }
}
