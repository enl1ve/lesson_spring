package pract_1;

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
