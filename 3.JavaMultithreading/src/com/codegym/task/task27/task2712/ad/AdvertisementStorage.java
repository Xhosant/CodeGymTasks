package com.codegym.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    private static AdvertisementStorage instance = null;
    private final List<Advertisement> videos = new ArrayList<>();

    public static synchronized AdvertisementStorage getInstance() {
        if (instance==null) instance = new AdvertisementStorage();
        return instance;
    }
    private AdvertisementStorage(){
        Object someContent = new Object();
        add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min
        add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); // 15 min
        add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60)); // 10 min
    }
    public List<Advertisement> list(){
        return videos;
    }
    public void add(Advertisement advertisement){
        videos.add(advertisement);
    }
}
