package Views;

import Main.RekentrainerApplication;
import Models.UserModel;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StartView extends Scene {
    Stage primaryStage;

    public StartView(Stage primaryStage, Parent root, double width, double height) {
        super(root, width, height);
        this.primaryStage = primaryStage;

        Label nameLabel = new Label("Vul hieronder je naam in om de rekentrainer te starten");
        TextField nameField = new TextField();
        Button startBtn = new Button("Start");
        Label promptLabel = new Label();

        promptLabel.setLayoutX(255);
        promptLabel.setLayoutY(75);

        nameLabel.setLayoutX(160);
        nameLabel.setLayoutY(50);

        nameField.setLayoutX(220);
        nameField.setLayoutY(100);
        nameField.setAlignment(Pos.CENTER);

        startBtn.setLayoutX(250);
        startBtn.setLayoutY(140);

        nameField.setMinSize(150, 20);
        startBtn.setMinSize(100, 20);

        startBtn.setOnAction((event) -> {
            try {
                String name = nameField.getText();
                if (!RekentrainerApplication.isEmpty(name)) {
                    primaryStage.setScene(new SettingsView(new UserModel(nameField.getText()), primaryStage, new Pane(), width, height));
                } else {
                    promptLabel.setText("Vul je naam in");
                }
            } catch (Exception var9) {
                nameField.setText("Voer je naam in");
            }

        });
        ((Pane)root).getChildren().addAll(new Node[]{nameLabel, nameField, startBtn, promptLabel});
    }
}
