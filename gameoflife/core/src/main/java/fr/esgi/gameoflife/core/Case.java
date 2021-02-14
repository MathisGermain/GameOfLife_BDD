package fr.esgi.gameoflife.core;

public class Case {

    private int verticalPosition;
    private int horizontalPosition;
    private boolean isChecked;

    public Case(int x,int y, boolean alive){
        this.horizontalPosition = x;
        this.verticalPosition = y;
        this.isChecked = alive;

    }

    public int getVerticalPosition() {
        return verticalPosition;
    }

    public void setVerticalPosition(int verticalPosition) {
        this.verticalPosition = verticalPosition;
    }

    public int getHorizontalPosition() {
        return horizontalPosition;
    }

    public void setHorizontalPosition(int horizontalPosition) {
        this.horizontalPosition = horizontalPosition;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
