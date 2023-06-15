package pract_1;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    private List<Music> musics = new ArrayList<Music>();

    private String name;
    private int volume;
    //Внедрение IoC (инверсия управления)
    //public MusicPlayer(Music music) {this.music = music;}

    public MusicPlayer(){
    }

    public List<Music> getMusics() {
        return musics;
    }

    public void setMusics(List<Music> musics) {
        this.musics = musics;
    }

    //    public void setMusic(Music music) {
//        this.music = music;
//    }


    public void playMusic() {
        for (Music s: musics)
        System.out.println("Playing: " + s.getSong());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
