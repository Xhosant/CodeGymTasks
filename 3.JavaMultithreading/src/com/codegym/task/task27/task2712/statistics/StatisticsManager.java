package com.codegym.task.task27.task2712.statistics;

import com.codegym.task.task27.task2712.kitchen.Cook;
import com.codegym.task.task27.task2712.statistics.event.OrderReadyEventDataRow;
import com.codegym.task.task27.task2712.statistics.event.EventDataRow;
import com.codegym.task.task27.task2712.statistics.event.EventType;
import com.codegym.task.task27.task2712.statistics.event.VideosSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticsManager {
    private StatisticsManager(){}
    private Set<Cook> cooks = new HashSet<Cook>();

    public Set<Cook> getCooks() {
        return cooks;
    }

    private static StatisticsManager instance = null;
    private StatisticsStorage statisticsStorage = new StatisticsStorage();

    public static StatisticsManager getInstance() {
        if (instance==null) instance = new StatisticsManager();
        return instance;
    }
    public void record(EventDataRow data){
        this.statisticsStorage.put(data);
    }
    public void register(Cook cook){
        cooks.add(cook);
    }

    public Map<String, Long> getProfitMap() {
        Map<String, Long> res = new HashMap();
        List<EventDataRow> rows = statisticsStorage.get(EventType.VIDEOS_SELECTED);
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        long total = 0l;
        for (EventDataRow row : rows) {
            VideosSelectedEventDataRow dataRow = (VideosSelectedEventDataRow) row;
            String date = format.format(dataRow.getDate());
            if (!res.containsKey(date)) {
                res.put(date, 0l);
            }
            total += dataRow.getAmount();
            res.put(date, res.get(date) + dataRow.getAmount());
        }

        res.put("Total", total);

        return res;
    }

    public Map<String, Map<String, Integer>> getCookWorkloadingMap() {
        Map<String, Map<String, Integer>> res = new HashMap(); //name, time
        List<EventDataRow> rows = statisticsStorage.get(EventType.ORDER_READY);
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (EventDataRow row : rows) {
            OrderReadyEventDataRow dataRow = (OrderReadyEventDataRow) row;
            String date = format.format(dataRow.getDate());
            if (!res.containsKey(date)) {
                res.put(date, new HashMap<String, Integer>());
            }
            Map<String, Integer> cookMap = res.get(date);
            String cookName = dataRow.getCookName();
            if (!cookMap.containsKey(cookName)) {
                cookMap.put(cookName, 0);
            }

            Integer totalTime = cookMap.get(cookName);
            cookMap.put(cookName, totalTime + dataRow.getTime());
        }

        return res;
    }
    
    private class StatisticsStorage{
        private Map<EventType, List<EventDataRow>> storage;

        public StatisticsStorage() {
            storage = new HashMap<>();
            for (EventType type: EventType.values()
                 ) {
                storage.put(type, new ArrayList<EventDataRow>());
            }
        }
        private void put(EventDataRow data){
            EventType type = data.getType();
            List<EventDataRow> entry = storage.get(type);
            entry.add(data);
            storage.put(type, entry);
        }

        private List<EventDataRow> get(EventType type) {
            if (!this.storage.containsKey(type))
                throw new UnsupportedOperationException();

            return this.storage.get(type);
        }
    }

}
