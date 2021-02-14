package fr.esgi.gameoflife.core;

import java.util.ArrayList;

public class Grille {

    int numberElement;
    int maxLenght;
    int maxHeight;

    ArrayList<Case> caseList = new ArrayList<Case>();

    public Grille(final boolean[][] grid){
        int count = 0;

        this.maxLenght = grid.length;
        this.maxHeight = grid[0].length;

        for(int x = 0 ; x < grid.length ; x++){
            for(int y = 0; y < grid[x].length ; y++){
                Case newCase = new Case(x,y,grid[x][y]);
                this.caseList.add(newCase);
            }
        }
    }

    public int getNumberElement() {
        return numberElement;
    }

    public void setNumberElement(int numberElement) {
        this.numberElement = numberElement;
    }

    public int getMaxLenght() {
        return maxLenght;
    }

    public void setMaxLenght(int maxLenght) {
        this.maxLenght = maxLenght;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public ArrayList<Case> getCaseList() {
        return caseList;
    }

    public void setCaseList(ArrayList<Case> caseList) {
        this.caseList = caseList;
    }

    public Case giveACase(int x, int y){
        int i;
        for(i = 0; i<caseList.size(); i++){
            if(caseList.get(i).getHorizontalPosition() == x && caseList.get(i).getVerticalPosition() == y){
                return caseList.get(i);
            }
        }
        return caseList.get(0);
    }

    public boolean CheckAliveCell(int x,int y){
        int aliveNeighbour = CheckNeighbourAlive(x,y);
        boolean isAlive = true;

        if(aliveNeighbour < 2){
            isAlive = false;
        }else if(aliveNeighbour > 3){
            isAlive = false;
        }

        return isAlive;
    }

    public boolean CheckDeadCell(int x,int y){
        int aliveNeighbour = CheckNeighbourAlive(x,y);
        //System.out.println("Verification cellule morte en x : " + x + " y : " + y + " nombre alive : " + aliveNeighbour);
        boolean isAlive = false;
        if(aliveNeighbour == 3){
            isAlive = true;
        }
        return isAlive;
    }


    public int CheckNeighbourAlive(int x,int y) {
        int counterAliveCellule = 0;

        if (y + 1 < maxHeight) {
            Case top = giveACase(x, y + 1);
            if (top.isChecked()) {
                counterAliveCellule++;
                //System.out.println("Top");
            }
        }

        if (x + 1 < maxLenght) {
            Case right = giveACase(x + 1, y);
            if (right.isChecked()) {
                counterAliveCellule++;
                //System.out.println("Right");
            }
        }

        if (x - 1 >= 0) {
            Case left = giveACase(x - 1, y);
            if (left.isChecked()) {
                counterAliveCellule++;
                //System.out.println("left");
            }
        }

        if (y - 1 >= 0) {
            Case down = giveACase(x, y - 1);
            if (down.isChecked()) {
                counterAliveCellule++;
                //System.out.println("down");
            }
        }

        if(y - 1 >= 0 && x - 1 >= 0){
            Case cornerLeftDown = giveACase(x - 1 , y - 1);
            if(cornerLeftDown.isChecked()){
                counterAliveCellule++;
                //System.out.println("cornerLD");
            }
        }

        if(y + 1 < maxHeight && x - 1 >= 0){
            Case cornerLeftTop= giveACase(x - 1 , y + 1);
            if(cornerLeftTop.isChecked()){
                counterAliveCellule++;
                //System.out.println("cornerLT");
            }
        }

        if(y - 1 >= 0 && x + 1 < maxLenght){
            Case cornerRightDown = giveACase(x + 1 , y - 1);
            if(cornerRightDown.isChecked()){
                counterAliveCellule++;
                //System.out.println("cornerRD");
            }
        }

        if(y + 1 < maxHeight && x + 1 < maxLenght){
            Case cornerRightTop = giveACase(x + 1 , y + 1);
            if(cornerRightTop.isChecked()){
                counterAliveCellule++;
                //System.out.println("cornerRT");
            }
        }
        //System.out.println("Nombre de cellules voisines vivantes : " + counterAliveCellule);
        return counterAliveCellule;
    }

}
