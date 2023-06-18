package pract_1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component //Вместо того что бы в XML файле прописовать вручную, аннотация проще и удобнее
@Scope("prototype")
public class ClassicalMusic implements Music{
    private ClassicalMusic() {
    }

    public static ClassicalMusic getClassicalMusic() {
        return new ClassicalMusic();
    }

    public String getSong() {
        return "Sonata 12";
    }

    @PostConstruct
    public void doMyInit() {
        System.out.println("My init");
    }

    @PreDestroy
    public void destroyMyInit() {
        System.out.println("Destroy");
    }
}
