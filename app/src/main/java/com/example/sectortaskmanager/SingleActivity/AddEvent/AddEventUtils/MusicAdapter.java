package com.example.sectortaskmanager.SingleActivity.AddEvent.AddEventUtils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sectortaskmanager.R;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Music> musicList;

    public MusicAdapter(Context context, List<Music> musicList) {
        this.inflater = LayoutInflater.from(context);;
        this.musicList = musicList;
    }

    @NonNull
    @Override
    public MusicAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.music_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicAdapter.ViewHolder holder, int position) {
        Music music = musicList.get(position);

        holder.musicNameTextView.setText(music.getMusicName());
        holder.singerNameTextView.setText(music.getSingerName());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView musicNameTextView, singerNameTextView;
        ViewHolder(View view){
            super(view);
            musicNameTextView =  view.findViewById(R.id.musicNameTextView);
            singerNameTextView =  view.findViewById(R.id.singerNameTextView);
        }
    }
}
