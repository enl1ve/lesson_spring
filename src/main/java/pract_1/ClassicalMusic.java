package pract_1;

import org.springframework.stereotype.Component;

import java.util.List;

@Component //Вместо того что бы в XML файле прописовать вручную, аннотация проще и удобнее
public class ClassicalMusic implements Music{
    String[] songs = {"zxc", "hih", "Bethovin"};
    private ClassicalMusic() {
    }

    public static ClassicalMusic getClassicalMusic() {
        return new ClassicalMusic();
    }

    public String getSong() {
        int n = (int)Math.floor(Math.random() * songs.length);
        return songs[n];
    }

    public void doMyInit() {
        System.out.println("My init");
    }

    public void destroyMyInit() {
        System.out.println("Destroy");
    }
}
