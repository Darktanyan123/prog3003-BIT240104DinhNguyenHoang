package com.mycompany.exthree;
public class HomeTheaterFacade {

    private TV tv;
    private SoundSystem sound;
    private DVDPlayer dvd;
    private Light light;

    public HomeTheaterFacade() {
        tv = new TV();
        sound = new SoundSystem();
        dvd = new DVDPlayer();
        light = new Light();
    }

    public void watchMovie() {
        light.dim(); // giảm dộ sáng
        tv.on();     // bật TV
        sound.on();  // bật loa
        dvd.on();    // bật DVD
        System.out.println("San sang xem phim!");
    }
}
