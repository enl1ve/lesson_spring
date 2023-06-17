package pract_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    //@Autowired //так же даже через приватные поля
    private ClassicalMusic music;
    private MetalMusic metalMusic;

    //Внедрение IoC (инверсия управления)
    @Autowired // Аннотация DI(внедрения зависимости)
    public MusicPlayer(ClassicalMusic music, MetalMusic metalMusic) {
        this.music = music;
        this.metalMusic = metalMusic;
    }

    //@Autowired //можно через сеттер
    public void setMusic(ClassicalMusic music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.println("Playing: " + music.getSong() + ", " + metalMusic.getSong());
    }
}