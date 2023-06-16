package pract_1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext.xml"
        );

        //Music music = context.getBean("musicBean", Music.class);
        //MusicPlayer musicPlayer = new MusicPlayer(music);

        // Внедрение DI
        MusicPlayer musicPlayer1 = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer musicPlayer2 = context.getBean("musicPlayer", MusicPlayer.class);

        boolean con = musicPlayer1 == musicPlayer2;
        System.out.println(con);

        System.out.println(musicPlayer1);
        System.out.println(musicPlayer2);

        musicPlayer1.setVolume(15);

        System.out.println(musicPlayer1.getVolume()); //15
        System.out.println(musicPlayer2.getVolume()); // и тут 15 потому что сингтон метод.. После изменения скоупа вернулись 50 процентов
                                                        // скоуп Прототип делает для каждого вызова новый бин

        //musicPlayer.playMusic();

//        System.out.println(musicPlayer.getName());
//        System.out.println(musicPlayer.getVolume());

        context.close();
    }
}
