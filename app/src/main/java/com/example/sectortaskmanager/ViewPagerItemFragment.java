package com.example.sectortaskmanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.sectortaskmanager.Intro.IntroItem;

public class ViewPagerItemFragment extends Fragment {
    private ImageView guideImageView;
    private TextView guideDescription;

    private IntroItem introItem;

    public static ViewPagerItemFragment getInstance(IntroItem introItem) {
        ViewPagerItemFragment fragment = new ViewPagerItemFragment();

        if (introItem != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("introItem", introItem);
            fragment.setArguments(bundle);
        }
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            introItem = getArguments().getParcelable("introItem");
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_viewpager_item, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        guideImageView = view.findViewById(R.id.guideImageView);
        guideDescription = view.findViewById(R.id.guideDescription);

        init();
    }

    private void init() {
        if (introItem != null) {
            RequestOptions requestOptions = new RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background);
            Glide.with(getActivity())
                    .setDefaultRequestOptions(requestOptions)
                    .load(introItem.getGuideImage())
                    .into(guideImageView);

            guideDescription.setText(introItem.getGuideDescription());


        }
    }
}
