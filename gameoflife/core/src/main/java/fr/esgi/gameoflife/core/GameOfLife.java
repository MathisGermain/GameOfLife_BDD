package fr.esgi.gameoflife.core;

public class GameOfLife {

    private Grille grille;
    final boolean[][] grid;

    public GameOfLife(final boolean[][] grid) {
        this.grille = new Grille(grid);
        this.grid = grid;

    }

    public boolean[][] tick() {

        int index;
        boolean isAlive;
        boolean[][] newGrid = new boolean[this.grille.maxLenght][this.grille.maxHeight];

        for(int x = 0 ; x < this.grille.getCaseList().size() ; x++){
            Case caseToTest = this.grille.getCaseList().get(x);
            if(caseToTest.isChecked()){
                isAlive = this.grille.CheckAliveCell(caseToTest.getHorizontalPosition(),caseToTest.getVerticalPosition());
            }else{
                isAlive = this.grille.CheckDeadCell(caseToTest.getHorizontalPosition(),caseToTest.getVerticalPosition());
            }

            newGrid[caseToTest.getHorizontalPosition()][caseToTest.getVerticalPosition()]=isAlive;

        }

        this.grille = new Grille(newGrid);

        return newGrid;
    }

    public boolean[][] getGrid() {
        return grid;
    }
}
