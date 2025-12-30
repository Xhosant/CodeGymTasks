package en.codegym.task.jdk13.task06.task0634;

import java.util.Scanner;

/* 
Chess board
*/

public class Solution {
    public static char[][] array;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int side=scanner.nextInt();
        
        array = new char[side][side];
        
        for (int x = 0; x<side; x++) for (int y = 0; y<side; y++){
            if ((x+y)%2==0) array[x][y]='#';
            else array[x][y]=' ';
        }
        
        printArray();
    }
    
    private static void printArray() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}
