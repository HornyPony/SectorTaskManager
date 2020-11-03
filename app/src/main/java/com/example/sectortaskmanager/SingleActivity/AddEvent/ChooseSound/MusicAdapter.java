package com.example.sectortaskmanager.SingleActivity.AddEvent.ChooseSound;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sectortaskmanager.R;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<Music> musicList;
    private OnMusicPlayListener onMusicPlayListener;
    private OnMusicStopListener onMusicStopListener;


    public MusicAdapter(Context context, List<Music> musicList, OnMusicPlayListener onMusicPlayListener,
                        OnMusicStopListener onMusicStopListener) {
        this.inflater = LayoutInflater.from(context);
        this.musicList = musicList;
        this.onMusicPlayListener = onMusicPlayListener;
        this.onMusicStopListener = onMusicStopListener;
    }

    @NonNull
    @Override
    public MusicAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.music_item, parent, false);
        return new ViewHolder(view, onMusicPlayListener);
    }

    @Override
    public void onBindViewHolder(@NonNull final MusicAdapter.ViewHolder holder, int position) {
        final Music music = musicList.get(position);
        holder.musicNameTextView.setText(music.getMusicName());
        holder.singerNameTextView.setText(music.getSingerName());


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.playButton:
                        onMusicPlayListener.onMusicPlayClick(holder, music);
                        break;
                    case R.id.stopButton:
                        onMusicStopListener.onMusicStopClick(holder);
                        break;
                }
            }
        };

        holder.playButton.setOnClickListener(onClickListener);
        holder.stopButton.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView musicNameTextView, singerNameTextView;
        final ImageView playButton, stopButton;
        OnMusicPlayListener onMusicPlayListener;

        ViewHolder(View view, final OnMusicPlayListener onMusicPlayListener) {
            super(view);
            this.onMusicPlayListener = onMusicPlayListener;
            musicNameTextView = view.findViewById(R.id.musicNameTextView);
            singerNameTextView = view.findViewById(R.id.singerNameTextView);
            playButton = view.findViewById(R.id.playButton);
            stopButton = view.findViewById(R.id.stopButton);
        }
    }

    public interface OnMusicPlayListener {
        void onMusicPlayClick(ViewHolder view, Music m);
    }


    public interface OnMusicStopListener {
        void onMusicStopClick(ViewHolder view);
    }
}
