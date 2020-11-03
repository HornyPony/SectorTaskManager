package com.example.sectortaskmanager.SingleActivity.AddEvent.ChooseSound;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sectortaskmanager.R;

import java.util.ArrayList;
import java.util.List;


public class PresetMusicFragment extends Fragment implements MusicAdapter.OnMusicPlayListener, MusicAdapter.OnMusicStopListener {
    private List<Music> musicList;
    private MusicAdapter musicAdapter;
    private RecyclerView recyclerView;
    private Boolean isMusicNotCreated = true;
    private MediaPlayer mediaPlayer;
    private MusicAdapter.ViewHolder lastViewHolder;;

    public PresetMusicFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_preset_music, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        musicList = new ArrayList<>();

        recyclerView = view.findViewById(R.id.presetMusicRecyclerView);
        musicList.add(new Music("Anime", "Heaven", R.raw.anime));
        musicList.add(new Music("Anime Ehh", "Heaven", R.raw.anime_ehh));
        musicList.add(new Music("Home", "Edward Sharpe & The Magnetic Zeros", R.raw.home));
        musicList.add(new Music("Хватит", "Гречка", R.raw.grechka_xvatit));
        musicAdapter = new MusicAdapter(getActivity(), musicList, this, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(musicAdapter);
    }

    @Override
    public void onMusicPlayClick(MusicAdapter.ViewHolder view, Music m) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            m.setPlaying(false);
        }

        if (!m.isPlaying()){
            mediaPlayer = MediaPlayer.create(getActivity(), m.getMusic());
            mediaPlayer.start();
            isMusicNotCreated = false;
            m.setPlaying(true);
            view.playButton.setImageResource(R.drawable.ic_play_arrow_blue);
            if (lastViewHolder != null && lastViewHolder != view) {
                lastViewHolder.playButton.setImageResource(R.drawable.ic_baseline_play_arrow_24);
            }
            lastViewHolder = view;
        }
    }

    @Override
    public void onMusicStopClick(MusicAdapter.ViewHolder view) {
        if (!isMusicNotCreated) {
            mediaPlayer.stop();
            mediaPlayer.release();
            isMusicNotCreated = true;
        }
        view.playButton.setImageResource(R.drawable.ic_baseline_play_arrow_24);
    }
}