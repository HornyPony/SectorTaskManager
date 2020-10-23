package com.example.sectortaskmanager.SingleActivity.AddEvent;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sectortaskmanager.R;
import com.example.sectortaskmanager.SingleActivity.AddEvent.AddEventUtils.Music;
import com.example.sectortaskmanager.SingleActivity.AddEvent.AddEventUtils.MusicAdapter;

import java.util.ArrayList;
import java.util.List;


public class PresetMusicFragment extends Fragment {
    private List<Music> musicList;
    private MusicAdapter musicAdapter;
    private RecyclerView recyclerView;

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
        musicList.add(new Music("Anime ", "Heaven", R.raw.anime));
        musicList.add(new Music("Anime Ehh", "Heaven", R.raw.anime_ehh));
        musicList.add(new Music("Home", "Edward Sharpe & The Magnetic Zeros", R.raw.home));

        musicAdapter = new MusicAdapter(getActivity(), musicList);
        recyclerView.setAdapter(musicAdapter);
    }
}