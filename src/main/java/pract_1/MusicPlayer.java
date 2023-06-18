package pract_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    //@Autowired //так же даже через приватные поля
    private Music music;
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    //Внедрение IoC (инверсия управления)
    @Autowired // Аннотация DI(внедрения зависимости)
    public MusicPlayer(@Qualifier("classicalMusic") Music music) {
        this.music = music;
    }

    //@Autowired //можно через сеттер
    public void setMusic(ClassicalMusic music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.println("Playing: " + music.getSong());
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }
}