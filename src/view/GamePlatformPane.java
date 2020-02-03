package view;

import config.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.jetbrains.annotations.NotNull;
import util.StepRecorder;

public class GamePlatformPane extends Pane {

    private static GamePlatformPane INSTANCE = null;

    private Label gameInfo = new Label();
    private Label specialNotice = new Label();

    private GamePlatformPane(Player black, Player white){
        Label playerDetails = new Label();
        playerDetails.setText("Black: "+ black.getName() +" vs White: "+ white.getName());
        playerDetails.setPrefHeight(30);
        ListView<String> stepsView = new ListView<>(StepRecorder.getInstance().getMoves());
        stepsView.setPrefWidth(270);

        HBox hBox = new HBox();
        ChessPane chessPane = ChessPane.getInstance();
        hBox.getChildren().add(chessPane);
        hBox.getChildren().add(stepsView);

        VBox vBox = new VBox();
        vBox.getChildren().add(playerDetails);
        vBox.getChildren().add(gameInfo);
        vBox.getChildren().add(specialNotice);
        vBox.getChildren().add(hBox);
        vBox.setAlignment(Pos.CENTER);

        this.getChildren().add(vBox);
    }

    public void setGameInfo(String info){
        gameInfo.setText(info);
    }

    public void setSpecialNotice(String info){
       specialNotice.setText(info);
    }

    public static GamePlatformPane getInstance(@NotNull Player black, Player white){
        if(INSTANCE == null){
            INSTANCE = new GamePlatformPane(black, white);
            return INSTANCE;
        }
        throw new IllegalStateException();
    }

    public static GamePlatformPane getInstance(){
        if(INSTANCE != null){
            return INSTANCE;
        }
        throw new IllegalStateException();
    }
}
