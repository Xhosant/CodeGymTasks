package com.codegym.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticsAdvertisementManager {
    private static StatisticsAdvertisementManager instance = new StatisticsAdvertisementManager();
    private StatisticsAdvertisementManager(){}

    public static StatisticsAdvertisementManager getInstance() {
        return instance;
    }

    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    public List<Advertisement> getActiveAds(){
        List<Advertisement> in = advertisementStorage.list();
        List<Advertisement> out = new ArrayList<>();
        for (Advertisement ad:in
             ) {
            if (ad.isActive()) out.add(ad);
        }
        return out;
    }
    public List<Advertisement> getInactiveAds(){
        List<Advertisement> in = advertisementStorage.list();
        List<Advertisement> out = new ArrayList<>();
        for (Advertisement ad:in
        ) {
            if (!ad.isActive()) out.add(ad);
        }
        return out;
    }
}
