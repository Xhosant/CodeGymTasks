package com.codegym.games.racer;

public class FinishLine extends GameObject{
    private boolean isVisible=false;
    public void show(){
        isVisible=true;
    }
    public void move(int boost){
        if (isVisible) y+=boost;
    }
    public FinishLine(){

        super(RacerGame.ROADSIDE_WIDTH, -1 * ShapeMatrix.FINISH_LINE.length, ShapeMatrix.FINISH_LINE);
    }
}
