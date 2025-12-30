package com.codegym.games.racer;
import com.codegym.engine.cell.*;
import com.codegym.games.racer.road.*;

public class RacerGame extends Game{
    public static final int WIDTH =64;
    public static final int CENTER_X = WIDTH/2;
    public static final int ROADSIDE_WIDTH = 14;
    public static final int HEIGHT =64;
    private static final int RACE_GOAL_CARS_COUNT=40;
    private RoadMarking roadMarking;
    private PlayerCar player;
    private RoadManager roadManager;
    private FinishLine finishLine;
    private ProgressBar progressBar;


    private boolean isGameStopped;

    public void initialize(){
        showGrid(false);
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }
    private void moveAll(){
        roadMarking.move(player.speed);
        roadManager.move(player.speed);
        player.move();
        finishLine.move(player.speed);
        progressBar.move(roadManager.getPassedCarsCount());
    }
    public void setCellColor(int x, int y, Color color){
        if (x<0 || x>=WIDTH) return;
        if (y<0 ||y>=HEIGHT) return;
        super.setCellColor(x, y, color);
    }
    @Override
    public void onTurn(int i){
        if (roadManager.getPassedCarsCount()>=RACE_GOAL_CARS_COUNT) finishLine.show();

        if (roadManager.checkCrash(player)){
            gameOver();
        }
        else{
            roadManager.generateNewRoadObjects(this);
            moveAll();
        }
        drawScene();
    }
    


    @Override
    public void onKeyPress(Key key) {
        if (isGameStopped){
            if (key==Key.SPACE) createGame();
            else return;
        }
        switch (key){
            case LEFT:
                player.setDirection(Direction.LEFT);
                break;
            case RIGHT:
                player.setDirection(Direction.RIGHT);
                break;
            case UP:
                player.speed=2;
                break;
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key==Key.LEFT  && player.getDirection()==Direction.LEFT)  player.setDirection(Direction.NONE);
        if (key==Key.RIGHT && player.getDirection()==Direction.RIGHT) player.setDirection(Direction.NONE);
        if (key==Key.UP) player.speed=1;
    }

    private void createGame(){
        isGameStopped=false;
        setTurnTimer(40);
        roadMarking = new RoadMarking();
        roadManager = new RoadManager();
        player = new PlayerCar();
        finishLine=new FinishLine();
        progressBar = new ProgressBar(RACE_GOAL_CARS_COUNT);
        drawScene();

    }
    private void drawScene(){
        drawField();
        roadMarking.draw(this);
        finishLine.draw(this);
        roadManager.draw(this);
        player.draw(this);
        progressBar.draw(this);
    }
    private void drawField(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Color c;
                if (i==CENTER_X) c=Color.WHITE;
                else if (i>=ROADSIDE_WIDTH && i<WIDTH-ROADSIDE_WIDTH) c=Color.DIMGREY;
                else c=Color.GREEN;

                setCellColor(i, j, c);
            }

        }
    }

    private void gameOver(){
        isGameStopped=true;
        showMessageDialog(Color.RED, "CRASHED", Color.BLACK, 50);
        stopTurnTimer();
        player.stop();
    }
}
