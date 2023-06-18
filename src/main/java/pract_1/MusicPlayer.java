package pract_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    //@Autowired //так же даже через приватные поля
    private Music music1;
    private Music music2;

    //Внедрение IoC (инверсия управления)
    @Autowired // Аннотация DI(внедрения зависимости)
    public MusicPlayer(@Qualifier("rockMusic") Music music1,
                       @Qualifier("classicalMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    //@Autowired //можно через сеттер

    public void playMusic(Genre genre) {
        switch (genre) {
            case CLASSICAL:
                System.out.println("Playing: " + music2.getSong());
                break;
            case ROCK:
                System.out.println("Playing: " + music1.getSong());
                break;
        }
    }
}