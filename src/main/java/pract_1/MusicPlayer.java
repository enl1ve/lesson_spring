package pract_1;

public class MusicPlayer {
    private Music music;
    //Внедрение IoC (инверсия управления)
    public MusicPlayer(Music music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.println("Playing: " + music.getSong());
    }
}
