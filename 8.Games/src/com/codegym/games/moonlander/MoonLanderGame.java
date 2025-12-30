package com.codegym.games.moonlander;
import com.codegym.engine.cell.*;

public class MoonLanderGame extends Game{
    public static final int WIDTH=64;
    public static final int HEIGHT=64;
    private Rocket rocket;
    private GameObject landscape;
    private boolean isUpPressed;
    private boolean isLeftPressed;
    private boolean isRightPressed;
    private GameObject platform;
    private boolean isGameStopped;
    private int score;

    @Override
    public void initialize(){
        setScreenSize(WIDTH, HEIGHT);
        createGame();
        showGrid(false);
    }

    @Override
    public void onTurn(int x){
        rocket.move(isUpPressed, isLeftPressed, isRightPressed);
        if (score>0) score--;

        check();
        setScore(score);
        drawScene();
    }

    @Override
    public void onKeyPress(Key key){
        if (isGameStopped){
            if (key==Key.SPACE) createGame();
            return;
        }
        switch (key){
            case UP:
                isUpPressed=true;
                break;
            case LEFT:
                isLeftPressed=true;
                isRightPressed=false;
                break;
            case RIGHT:
                isLeftPressed=false;
                isRightPressed=true;
                break;
        }
    }
    @Override
    public void onKeyReleased(Key key){
        switch (key){
            case UP:
                isUpPressed=false;
                break;
            case LEFT:
                isLeftPressed=false;
                break;
            case RIGHT:
                isRightPressed=false;
                break;
        }
    }


    @Override
    public void setCellColor(int x, int y, Color color){
        if (x>=WIDTH || y>=HEIGHT || x<0 || y<0) return;
        super.setCellColor(x, y, color);
    }

    private void createGame(){
        isGameStopped=false;
        score=1000;
        setTurnTimer(50);
        createGameObjects();
        drawScene();
        isLeftPressed=false;
        isRightPressed=false;
        isUpPressed=false;
    }

    private void createGameObjects(){
        rocket=new Rocket(WIDTH/2, 0);
        landscape = new GameObject(0, 25, ShapeMatrix.LANDSCAPE);
        platform=new GameObject(23, MoonLanderGame.HEIGHT-1, ShapeMatrix.PLATFORM);
    }

    private void drawScene(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellColor(i, j, Color.BLACK);
            }
        }
        rocket.draw(this);
        landscape.draw(this);
    }


    private void check(){
        if (rocket.isCollision(landscape) && !(rocket.isStopped() && rocket.isCollision(platform))) gameOver();
        else if (rocket.isCollision(platform) && rocket.isStopped()) win();

    }
    private void win(){
        rocket.land();
        isGameStopped=true;
        stopTurnTimer();
        showMessageDialog(Color.GREEN, "Landed", Color.BLACK, 50);
    }
    private void gameOver(){
        rocket.crash();
        score=0;
        isGameStopped=true;
        stopTurnTimer();
        showMessageDialog(Color.RED, "Crashed", Color.BLACK, 50);

    }

}
