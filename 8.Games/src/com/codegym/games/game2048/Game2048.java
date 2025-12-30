package com.codegym.games.game2048;
import com.codegym.engine.cell.*;


public class Game2048 extends Game{
    private static final int SIDE=4;
    private int[][] gameField;
    private boolean isGameStopped = false;

    private int score;

    
    private void createGame(){
        score=0;
        setScore(score);
        gameField = new int[SIDE][SIDE];
        createNewNumber();
        createNewNumber();
    }

    private void win() {
        isGameStopped=true;
        showMessageDialog(Color.GREEN, "Success!", Color.WHITE, 50);
    }

    private void gameOver(){
        isGameStopped=true;
        showMessageDialog(Color.RED, "Failure!", Color.WHITE, 50);
    }

    private boolean canUserMove(){
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (gameField[i][j]==0) return true;
            }
        }

        for (int i = 0; i < SIDE-1; i++) {
            for (int j = 0; j < SIDE-1; j++) {
                if (gameField[i][j]==gameField[i][j+1]) return true;
                if (gameField[i][j]==gameField[i+1][j]) return true;
            }
        }

        for (int j = 0; j < SIDE-1; j++) {
            if (gameField[SIDE-1][j]==gameField[SIDE-1][j+1]) return true;
        }
        for (int i = 0; i < SIDE-1; i++) {
            if (gameField[i][SIDE-1]==gameField[i+1][SIDE-1]) return true;
        }

        return false;
    }

    @Override
    public void initialize(){
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    @Override
    public void onKeyPress(Key key){
        if (isGameStopped) {
            if (key==Key.SPACE) {
                isGameStopped=false;
                createGame();
                drawScene();
            }
            return;
        }
        if (!canUserMove()) {
            gameOver();
            return;
        }
        boolean pressedKey=true;
        switch (key){
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
            default:
                pressedKey=false;
                break;
        }
        if (pressedKey) drawScene();
    }

    private void moveLeft(){
        boolean madeMove=false;
        for (int i=0;i<SIDE;i++){
            boolean moveTemp =
                    (compressRow(gameField[i])
                            | mergeRow(gameField[i])
                            | compressRow(gameField[i]));
            madeMove = madeMove || moveTemp;
        }

        if (madeMove) createNewNumber();
    }
    private void moveRight(){
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveUp(){
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void moveDown(){
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }
    private void drawScene(){
        for (int i=0; i<SIDE; i++) for (int j=0; j<SIDE;j++){
            setCellColoredNumber(i, j, gameField[j][i]);
        }
    }

    private void rotateClockwise(){
        int[][] rot = new int[SIDE][SIDE];

        for (int i=0; i<SIDE;i++)
            for (int j=0; j<SIDE;j++)
            {
                rot[i][j]=gameField[SIDE-j-1][i];
            }
        gameField=rot;
    }

    private boolean compressRow(int[] row){
        boolean madeChanges=false;

        int emptyCount = 0;
        for (int i=0; i<SIDE;i++){
            if (row[i]==0){
                emptyCount++;
            }
            else if (emptyCount!=0){
                madeChanges=true;
                row[i-emptyCount]=row[i];
                row[i]=0;
            }
        }

        return madeChanges;
    }

    private boolean mergeRow(int[] row){
        boolean madeChanges=false;
        
        for (int i=0; i<SIDE-1;i++) {
            if (row[i] != 0 && row[i] == row[i + 1]) {
                madeChanges = true;
                row[i] *= 2;
                score += row[i];
                setScore(score);
                row[i + 1] = 0;
                i++;
            }
        }
        return madeChanges;
    }

    private int getMaxTileValue(){
        int max=0;
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (gameField[i][j]>max) max=gameField[i][j];
            }
        }
        return max;
    }
    
    private Color getColorByValue(int value){
        //return Color.values()[value/2];
        switch (value){
            case 2:
                return Color.LIGHTPINK;
                
            case 4:
                return Color.DEEPPINK;
                
            case 8:
                return Color.PURPLE;
                
            case 16:
                return Color.DARKVIOLET;
                
            case 32:
                return Color.MEDIUMVIOLETRED;
                
            case 64:
                return Color.RED;
                
            case 128:
                return Color.ORANGERED;
                
            case 256:
                return Color.ORANGE;
                
            case 512:
                return Color.YELLOW;
                
            case 1024:
                return Color.YELLOWGREEN;
                
            case 2048:
                return Color.GREEN;
                
            default:
                return Color.WHITE;
        }
    }
    
    private void setCellColoredNumber(int x, int y, int v){
        if (v==0) setCellValueEx(x, y, getColorByValue(v), "");
        else setCellValueEx(x, y, getColorByValue(v), Integer.toString(v));
    }
    
    private void createNewNumber(){
        if (getMaxTileValue()==2048) win();
        int x = getRandomNumber(SIDE);
        int y = getRandomNumber(SIDE);
        while (gameField[x][y]!=0){
            x = getRandomNumber(SIDE);
            y = getRandomNumber(SIDE);
        }
        
        //if (getRandomNumber(10)==9) gameField[x][y]=4;
        //else gameField[x][y]=2;

        int v = 2 + 2*(getRandomNumber(10)/9);

        gameField[x][y]=v;
    }
}