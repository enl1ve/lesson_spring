package pract_1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Configuration
//@ComponentScan("pract_1")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
    @Bean
    public ClassicalMusic classicalMusic() {
        return new ClassicalMusic();
    }

    @Bean
    public RockMusic rockMusic() {
        return new RockMusic();
    }

    @Bean
    public MetalMusic metalMusic() {
        return new MetalMusic();
    }

    @Bean
    public MusicPlayer musicPlayer() {
        List<Music> music = new ArrayList<Music>();
        music.add(classicalMusic());
        music.add(rockMusic());
        music.add(metalMusic());

        return new MusicPlayer(music);
    }

}
