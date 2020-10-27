package com.example.sectortaskmanager.SingleActivity.AddEvent.ChooseSound;

public class Music {
    private String musicName;
    private String singerName;
    private int music;


    public int getMusic() {
        return music;
    }

    public void setMusic(int music) {
        this.music = music;
    }

    public Music(String musicName, String singerName, int music) {
        this.musicName = musicName;
        this.singerName = singerName;
        this.music = music;

    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }


}
