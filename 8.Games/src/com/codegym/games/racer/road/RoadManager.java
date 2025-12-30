package com.codegym.games.racer.road;

import com.codegym.games.racer.PlayerCar;
import com.codegym.games.racer.RacerGame;
import com.codegym.engine.cell.Game;
import java.util.*;


public class RoadManager {
    public static final int LEFT_BORDER=RacerGame.ROADSIDE_WIDTH;
    public static final int RIGHT_BORDER=RacerGame.WIDTH - LEFT_BORDER;
    private static final int FIRST_LANE_POSITION=16;
    private static final int FOURTH_LANE_POSITION=44;
    private static final int PLAYER_CAR_DISTANCE=12;

    private int passedCarsCount =0;
    private List<RoadObject> items = new ArrayList<RoadObject>();

    private RoadObject createRoadObject(RoadObjectType type, int x, int y){
        if (type==RoadObjectType.SPIKE) return new Spike(x, y);
        else if (type==RoadObjectType.DRUNK_CAR) return new MovingCar(x, y);
        else return new Car(type, x, y);
    }

    public int getPassedCarsCount() {
        return passedCarsCount;
    }

    private void addRoadObject(RoadObjectType type, Game game){
        int x = game.getRandomNumber(FIRST_LANE_POSITION, FOURTH_LANE_POSITION);
        int y = -1*RoadObject.getHeight(type);
        RoadObject nO = createRoadObject(type, x, y);
        if (nO!=null && isRoadSpaceFree(nO)) items.add(nO);
    }
    
    public void draw(Game game){
        for (RoadObject r : items){
            r.draw(game);
        }
    }
    public void move(int boost){
        for (RoadObject r : items){
            r.move(boost + r.speed, items);
        }
        deletePassedItems();
    }
    private void generateSpike(Game game){
        int x = game.getRandomNumber(100);
        if (!spikeExists() && x<10)
            addRoadObject(RoadObjectType.SPIKE, game);
    }
    private void generateRegularCar(Game game){
        int x = game.getRandomNumber(100);
        int carTypeNumber = game.getRandomNumber(4);
        if (x<30) addRoadObject(RoadObjectType.values()[carTypeNumber], game);
    }
    public void generateNewRoadObjects(Game game){
        generateSpike(game);
        generateRegularCar(game);
        generateMovingCar(game);
    }
    private void generateMovingCar(Game game){
        int x = game.getRandomNumber(100);
        if (x<10 && !movingCarExists()) addRoadObject(RoadObjectType.DRUNK_CAR, game);
    }
    private boolean spikeExists(){
        for (RoadObject r : items){
            if (r.type == RoadObjectType.SPIKE) return true;
        }
        return false;
    }

    private void deletePassedItems(){
        List<RoadObject> temp = new ArrayList<RoadObject>(items);
        for (RoadObject r : temp) {
            if (r.y >= RacerGame.HEIGHT) {
                if (r.type != RoadObjectType.SPIKE) passedCarsCount++;
                items.remove(r);
            }
        }
    }
    public boolean checkCrash(PlayerCar player){
        for (RoadObject r : items){
            if (r.isCollision(player)) return true;
        }
        return false;
    }
    private boolean isRoadSpaceFree(RoadObject object){
        for (RoadObject r : items){
            if (r.isCollisionWithDistance(object, PLAYER_CAR_DISTANCE)) return false;
        }
        return true;
    }
    private boolean movingCarExists(){
        for (RoadObject r : items){
            if (r.type==RoadObjectType.DRUNK_CAR) return true;
        }
        return false;
    }
}
