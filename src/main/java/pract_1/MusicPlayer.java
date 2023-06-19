package pract_1;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Random;

//@Component
public class MusicPlayer {
    //@Autowired //так же даже через приватные поля
    private List<Music> music;
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    //Внедрение IoC (инверсия управления)
    //@Autowired // Аннотация DI(внедрения зависимости)
    public MusicPlayer(List<Music> music) {
        this.music = music;
    }

    //@Autowired //можно через сеттер

    public void playMusic() {
        Random random = new Random();
        int randomIndex = random.nextInt(music.size());
        System.out.println("Playing " + music.get(randomIndex).getSong());
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }
}