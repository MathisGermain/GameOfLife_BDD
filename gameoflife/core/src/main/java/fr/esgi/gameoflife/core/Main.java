package fr.esgi.gameoflife.core;

public class Main {

    public static void main(String args[]) {
        boolean[][] array = {
                { false, true, false },
                { false, true, false },
                { false, true, false }
        };

        GameOfLife game = new GameOfLife(array);

        printArray(game.tick());


    }

    public static void printArray(boolean[][] array) {
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[x].length; y++) {
                if(array[x][y]){
                    System.out.print('X');
                }else{
                    System.out.print('/');
                }
            }
            System.out.println();
        }
    }

}
