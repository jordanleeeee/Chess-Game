package chess;
import javafx.scene.image.Image;
import util.Coordinate;
import java.util.ArrayList;

public abstract class Chess {

    protected boolean isBlack;
    protected boolean isFirstMove = true;
    Coordinate currentLocation;
    private final Image blackIcon;
    private final Image whiteIcon;

    public Chess(int row, int col, boolean isBlack, Image blackIcon, Image whiteIcon){
        currentLocation = new Coordinate(row, col);
        this.isBlack = isBlack;
        this.blackIcon = blackIcon;
        this.whiteIcon = whiteIcon;
    }

    public Coordinate getCoordinate(){
        return currentLocation;
    }
    public void setCurrentLocation(Coordinate currentLocation) {
        this.currentLocation = currentLocation;
    }
    public boolean isBlack() {
        return isBlack;
    }
    public Image getIcon() {
        return (isBlack)? blackIcon: whiteIcon;
    }
    public void setIsMoved(){
        isFirstMove = false;
    }

    public abstract ArrayList<Coordinate> getAvailableNextMovePosition();

    @Override
    public abstract String toString();

}