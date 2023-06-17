package pract_1;

import org.springframework.stereotype.Component;

@Component("musicBean") //Вместо того что бы в XML файле прописовать вручную, аннотация проще и удобнее
public class ClassicalMusic implements Music{
    private ClassicalMusic() {
    }

    public static ClassicalMusic getClassicalMusic() {
        return new ClassicalMusic();
    }

    public String getSong() {
        return "Sonata 12";
    }

    public void doMyInit() {
        System.out.println("My init");
    }

    public void destroyMyInit() {
        System.out.println("Destroy");
    }
}
