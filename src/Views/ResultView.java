package Views;

import Models.ResultModel;
import Models.UserModel;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ResultView extends Scene {
    UserModel userModel;

    public ResultView(ResultModel resultModel, UserModel userModel, Parent root, Stage primaryStage, double width, double height) {
        super(root, 600, 300);
        this.userModel = userModel;

        Label messageLabelOne = new Label("Je hebt de opdracht afgerond " + userModel.getName());
        Label messageLabelTwo = new Label("Hieronder zie je wat je resultaat is: ");
        Label sumRightLabel = new Label("Aantal sommen goed: " + resultModel.getGoodAnswers());
        Label sumWrongLabel = new Label("Aantal sommen fout: " + resultModel.getWrongAnswers());
        Label scoreLabel = new Label("score: " + Double.toString(this.calculateScore(resultModel.getGoodAnswers(), resultModel.getWrongAnswers())) + " %");
        Button retryButton = new Button("Nog een keer");
        Button stopButton = new Button("Stoppen");

        messageLabelOne.setLayoutY(30);
        messageLabelOne.setLayoutX(200);
        messageLabelTwo.setLayoutY(100);
        messageLabelTwo.setLayoutX(100);

        sumRightLabel.setLayoutY(120);
        sumRightLabel.setLayoutX(100);
        sumWrongLabel.setLayoutY(140);
        sumWrongLabel.setLayoutX(100);

        scoreLabel.setLayoutY(160);
        scoreLabel.setLayoutX(100);

        retryButton.setLayoutY(260);
        retryButton.setLayoutX(20);

        stopButton.setLayoutY(260);
        stopButton.setLayoutX(480);
        stopButton.setMinWidth(100);

        stopButton.setOnAction((event) -> {
            primaryStage.close();
        });
        retryButton.setOnAction((event) -> {
            primaryStage.setScene(new SettingsView(userModel, primaryStage, new Pane(), height, width));
        });
        ((Pane)root).getChildren().addAll(new Node[]{messageLabelOne, messageLabelTwo, sumRightLabel, sumWrongLabel, scoreLabel, retryButton, stopButton});
    }

    public double calculateScore(int goodAnswer, int wrongAnswer) {
        double num1 = goodAnswer;
        double total = (goodAnswer + wrongAnswer);
        double percentage = num1 / total * 100;
        return percentage;
    }
}
