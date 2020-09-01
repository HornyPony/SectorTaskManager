package com.example.sectortaskmanager.Resources;

import com.example.sectortaskmanager.Intro.IntroItem;
import com.example.sectortaskmanager.R;

public class IntroItems {
    private static final String GUIDE_GREETING = "Добро пожаловать в SectorTaskManager. Пройти краткое обучение?";
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

    public static final IntroItem SLIDE_GREETING = new IntroItem(R.drawable.temporary, GUIDE_GREETING);
    public static final IntroItem SLIDE_1 = new IntroItem(R.drawable.temporary, TEXT_SLIDE_1);
    public static final IntroItem SLIDE_2 = new IntroItem(R.drawable.temporary, TEXT_SLIDE_2);
    public static final IntroItem SLIDE_3 = new IntroItem(R.drawable.temporary, TEXT_SLIDE_3);
    public static final IntroItem SLIDE_4 = new IntroItem(R.drawable.temporary, TEXT_SLIDE_4);
    public static final IntroItem SLIDE_5 = new IntroItem(R.drawable.temporary, TEXT_SLIDE_5);
    public static final IntroItem SLIDE_6 = new IntroItem(R.drawable.temporary, TEXT_SLIDE_6);
    public static final IntroItem SLIDE_7 = new IntroItem(R.drawable.temporary, TEXT_SLIDE_7);
    public static final IntroItem SLIDE_8 = new IntroItem(R.drawable.temporary, TEXT_SLIDE_8);
    public static final IntroItem SLIDE_9 = new IntroItem(R.drawable.temporary, TEXT_SLIDE_9);
    public static final IntroItem SLIDE_10 = new IntroItem(R.drawable.temporary, TEXT_SLIDE_10);

    public static final IntroItem[] SLIDES = {SLIDE_GREETING, SLIDE_1, SLIDE_2, SLIDE_3, SLIDE_4, SLIDE_5,
            SLIDE_6, SLIDE_7, SLIDE_8, SLIDE_9, SLIDE_10};

    public static IntroItem[] getIntroItems() {
        return SLIDES;
    }


}
