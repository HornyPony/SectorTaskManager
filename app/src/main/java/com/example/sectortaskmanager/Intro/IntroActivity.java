package com.example.sectortaskmanager.Intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sectortaskmanager.R;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {
    private ViewPager2 introViewPager;
    private Button stopTutorialButton ;


    private static final String NUM_OF_SLIDES_INFO = "Всего 10 слайдов";
    private static final String NUM_SLIDE_1 = "1/10";
    private static final String NUM_SLIDE_2 = "2/10";
    private static final String NUM_SLIDE_3 = "3/10";
    private static final String NUM_SLIDE_4 = "4/10";
    private static final String NUM_SLIDE_5 = "5/10";
    private static final String NUM_SLIDE_6 = "6/10";
    private static final String NUM_SLIDE_7 = "7/10";
    private static final String NUM_SLIDE_8 = "8/10";
    private static final String NUM_SLIDE_9 = "9/10";
    private static final String NUM_SLIDE_10 = "10/10";

    private static final String GUIDE_GREETING = "Добро пожаловать в SectorTaskManager. Пройти краткое обучение";
    private static final String TEXT_SLIDE_1 = "Это проекция вашего календаря событий на 12-часовой циферблат";
    private static final String TEXT_SLIDE_2 = "Часовая и минутная стрелки, как на ваших наручных часах";
    private static final String TEXT_SLIDE_3 = "Секторы событий отображаются в тех часовых промежутках, в которых они будут происходить";
    private static final String TEXT_SLIDE_4 = "Между секторами отображается интервал времени простоя между событиями, и время от часовой стрелки до начала каждого события";
    private static final String TEXT_SLIDE_5 = "События выводятся автоматически с ходом времени на 12 часов вперед";
    private static final String TEXT_SLIDE_6 = "Важная деталь! Граница времени (серая пунктирная линия, которая отстает на 2 часа от часовой стрелки), отображает новые события с одной стороны и стирает старые с другой";
    private static final String TEXT_SLIDE_7 = "Перемещаться по времени можно вручную при помощи кнопок перемотки по часам и дням";
    private static final String TEXT_SLIDE_8 = "Вы можете перемещаться по времени, двигая часовую стрелку вручную";
    private static final String TEXT_SLIDE_9 = "Для возврата, нажмите кнопку сброса времени";
    private static final String TEXT_SLIDE_10 = "Используйте такой же виджет для вашего домашнего экрана";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        introViewPager = findViewById(R.id.introViewPager);
        stopTutorialButton = findViewById(R.id.stopTutorialButton);

        List<IntroItem> introItemsList = new ArrayList<>();
        introItemsList.add(new IntroItem(R.drawable.hello_guide, NUM_OF_SLIDES_INFO, GUIDE_GREETING));
        introItemsList.add(new IntroItem(R.drawable.first_slide, NUM_SLIDE_1, TEXT_SLIDE_1));
        introItemsList.add(new IntroItem(R.drawable.second_slide, NUM_SLIDE_2, TEXT_SLIDE_2));
        introItemsList.add(new IntroItem(R.drawable.third_slide, NUM_SLIDE_3, TEXT_SLIDE_3));
        introItemsList.add(new IntroItem(R.drawable.fourth_slide, NUM_SLIDE_4, TEXT_SLIDE_4));
        introItemsList.add(new IntroItem(R.drawable.fifth_slide, NUM_SLIDE_5, TEXT_SLIDE_5));
        introItemsList.add(new IntroItem(R.drawable.sixth_slide, NUM_SLIDE_6, TEXT_SLIDE_6));
        introItemsList.add(new IntroItem(R.drawable.seventh_slide, NUM_SLIDE_7, TEXT_SLIDE_7));
        introItemsList.add(new IntroItem(R.drawable.eighth_slide, NUM_SLIDE_8, TEXT_SLIDE_8));
        introItemsList.add(new IntroItem(R.drawable.ninth_slide, NUM_SLIDE_9, TEXT_SLIDE_9));
        introItemsList.add(new IntroItem(R.drawable.tenth_slide, NUM_SLIDE_10, TEXT_SLIDE_10));

        introViewPager.setAdapter(new IntroAdapter(introItemsList, introViewPager));
        introViewPager.setClipToPadding(false);
        introViewPager.setClipChildren(false);
        introViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        introViewPager.setPageTransformer(compositePageTransformer);

        stopTutorialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(IntroActivity.this, "Вы окончили туториал", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}