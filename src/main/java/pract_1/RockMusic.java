package pract_1;

import org.springframework.stereotype.Component;

@Component
public class RockMusic implements Music{
    String[] songs = {"Bring me horizon", "Rockkk", "Bochi no rocki"};
    public String getSong() {
        int n = (int)Math.floor(Math.random() * songs.length);
        return songs[n];
    }
}
