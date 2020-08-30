package com.example.sectortaskmanager.Intro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.sectortaskmanager.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class IntroAdapter extends RecyclerView.Adapter<IntroAdapter.ViewHolder> {
    private List<IntroItem> introItemsList;
    private ViewPager2 viewPager2;

    public IntroAdapter(List<IntroItem> introItemsList, ViewPager2 viewPager2) {
        this.introItemsList = introItemsList;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public IntroAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.intro_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IntroAdapter.ViewHolder holder, int position) {
        IntroItem introItem = introItemsList.get(position);
        holder.bind(introItem);
    }

    @Override
    public int getItemCount() {
        return introItemsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private RoundedImageView guideImageView;
        private TextView slideNumberTextView;
        private TextView guideDescription;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            guideImageView = itemView.findViewById(R.id.guideImageView);
            slideNumberTextView = itemView.findViewById(R.id.slideNumberTextView);
            guideDescription = itemView.findViewById(R.id.guideDescription);
        }

        public void bind(IntroItem introItem) {
            guideImageView.setImageResource(introItem.getGuideImage());
            slideNumberTextView.setText(introItem.getSlideNumber());
            guideDescription.setText(introItem.getGuideDescription());
        }
    }
}
