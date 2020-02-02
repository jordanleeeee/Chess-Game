package Chess;

import config.ChessManager;
import util.Coordinate;
import config.ChessPane;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Queen extends Chess{

    private ChessManager chessManager = null;
    private final Image whiteIcon = new Image("file:resources/whiteQueen.png", ChessPane.ICON_SIZE, ChessPane.ICON_SIZE, true, true);
    private final Image blackIcon = new Image("file:resources/blackQueen.png", ChessPane.ICON_SIZE, ChessPane.ICON_SIZE, true, true);

    public Queen(int row, int col, boolean isBlack) {
        super(row, col, isBlack);
    }

    @Override
    public ArrayList<Coordinate> getAvailableNextMovePosition() {
        if(chessManager == null){
            chessManager = ChessManager.getInstance();
        }
        ArrayList<Coordinate> possibleMove = new ArrayList<>();
        Coordinate tempCoord;

        tempCoord = currentLocation.getTopRight();
        while (tempCoord.isValidCoordinate()) {
            if(chessManager.haveChess(tempCoord, isBlack)){
                break;
            }
            if(chessManager.haveChess(tempCoord, !isBlack)){
                possibleMove.add(tempCoord);
                break;
            }
            possibleMove.add(tempCoord);
            tempCoord = tempCoord.getTopRight();
        }
        tempCoord = currentLocation.getTopLeft();
        while (tempCoord.isValidCoordinate()) {
            if(chessManager.haveChess(tempCoord, isBlack)){
                break;
            }
            if(chessManager.haveChess(tempCoord, !isBlack)){
                possibleMove.add(tempCoord);
                break;
            }
            possibleMove.add(tempCoord);
            tempCoord = tempCoord.getTopLeft();
        }
        tempCoord = currentLocation.getBottomRight();
        while (tempCoord.isValidCoordinate()) {
            if(chessManager.haveChess(tempCoord, isBlack)){
                break;
            }
            if(chessManager.haveChess(tempCoord, !isBlack)){
                possibleMove.add(tempCoord);
                break;
            }
            possibleMove.add(tempCoord);
            tempCoord = tempCoord.getBottomRight();
        }
        tempCoord = currentLocation.getBottomLeft();
        while (tempCoord.isValidCoordinate()) {
            if(chessManager.haveChess(tempCoord, isBlack)){
                break;
            }
            if(chessManager.haveChess(tempCoord, !isBlack)){
                possibleMove.add(tempCoord);
                break;
            }
            possibleMove.add(tempCoord);
            tempCoord = tempCoord.getBottomLeft();
        }
        tempCoord = currentLocation.getUpward();
        while (tempCoord.isValidCoordinate()) {
            if(chessManager.haveChess(tempCoord, isBlack)){
                break;
            }
            if(chessManager.haveChess(tempCoord, !isBlack)){
                possibleMove.add(tempCoord);
                break;
            }
            possibleMove.add(tempCoord);
            tempCoord = tempCoord.getUpward();
        }
        tempCoord = currentLocation.getDownward();
        while (tempCoord.isValidCoordinate()) {
            if(chessManager.haveChess(tempCoord, isBlack)){
                break;
            }
            if(chessManager.haveChess(tempCoord, !isBlack)){
                possibleMove.add(tempCoord);
                break;
            }
            possibleMove.add(tempCoord);
            tempCoord = tempCoord.getDownward();
        }
        tempCoord = currentLocation.getLHS();
        while (tempCoord.isValidCoordinate()) {
            if(chessManager.haveChess(tempCoord, isBlack)){
                break;
            }
            if(chessManager.haveChess(tempCoord, !isBlack)){
                possibleMove.add(tempCoord);
                break;
            }
            possibleMove.add(tempCoord);
            tempCoord = tempCoord.getLHS();
        }
        tempCoord = currentLocation.getRHS();
        while (tempCoord.isValidCoordinate()) {
            if(chessManager.haveChess(tempCoord, isBlack)){
                break;
            }
            if(chessManager.haveChess(tempCoord, !isBlack)){
                possibleMove.add(tempCoord);
                break;
            }
            possibleMove.add(tempCoord);
            tempCoord = tempCoord.getRHS();
        }
        return possibleMove;
    }

    @Override
    public Image getIcon() {
        return (isBlack)? blackIcon: whiteIcon;
    }

}
