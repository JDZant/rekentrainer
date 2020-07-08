package Views;

import Main.RekentrainerApplication;
import Models.SettingsModel;
import Models.UserModel;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SettingsView extends Scene {
    Stage primaryStage;

    public SettingsView(UserModel userModel, Stage primaryStage, Parent root, double width, double height) {
        super(root, 600, 300);
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Rekentrainer - Keuze scherm");

        ToggleButton classThreeBtn = new ToggleButton();
        classThreeBtn.setId("3");
        ToggleButton classFourBtn = new ToggleButton();
        classFourBtn.setId("4");
        ToggleButton classFiveBtn = new ToggleButton();
        classFiveBtn.setId("5");
        ToggleButton classSixBtn = new ToggleButton();
        classSixBtn.setId("6");
        ToggleButton classSevenBtn = new ToggleButton();
        classSevenBtn.setId("7");
        ToggleButton classEightBtn = new ToggleButton();
        classEightBtn.setId("8");

        List<ToggleButton> toggleButtons = new ArrayList();

        toggleButtons.add(classThreeBtn);
        toggleButtons.add(classFourBtn);
        toggleButtons.add(classFiveBtn);
        toggleButtons.add(classSixBtn);
        toggleButtons.add(classSevenBtn);
        toggleButtons.add(classEightBtn);

        ToggleGroup yesNoGroup = new ToggleGroup();
        ToggleButton toggleYesButton = new ToggleButton();

        toggleYesButton.setId("yes");
        toggleYesButton.setToggleGroup(yesNoGroup);
        ToggleButton toggleNoButton = new ToggleButton();
        toggleNoButton.setSelected(true);
        toggleNoButton.setId("no");
        toggleNoButton.setToggleGroup(yesNoGroup);

        Button startButton = new Button("Start rekentrainer");
        TextField quantityField = new TextField();

        Label welcomeLabel = new Label("Welkom " + userModel.getName());
        Label gradeLabel = new Label("Kies je groep: ");
        Label gradeLabel3 = new Label("Groep 3");
        Label gradeLabel4 = new Label("Groep 4");
        Label gradeLabel5 = new Label("Groep 5");
        Label gradeLabel6 = new Label("Groep 6");
        Label gradeLabel7 = new Label("Groep 7");
        Label gradeLabel8 = new Label("Groep 8");
        Label quantityLabel = new Label("Hoeveel sommen wil je maken? ");
        Label randomLabel = new Label("Wil je de sommen door elkaar heen?");
        Label labelYes = new Label("Ja");
        Label labelNo = new Label("Nee");
        welcomeLabel.setFont(new Font(20));

        quantityField.setMaxWidth(40);
        classThreeBtn.setShape(new Circle(1.5));
        classThreeBtn.setMaxSize(15, 15);
        classThreeBtn.setMinSize(15, 15);

        classFourBtn.setShape(new Circle(1.5));
        classFourBtn.setMaxSize(15, 15);
        classFourBtn.setMinSize(15, 15);

        classFiveBtn.setShape(new Circle(1.5));
        classFiveBtn.setMaxSize(15, 15);
        classFiveBtn.setMinSize(15, 15);

        classSixBtn.setShape(new Circle(1.5));
        classSixBtn.setMaxSize(15, 15);
        classSixBtn.setMinSize(15, 15);

        classSevenBtn.setShape(new Circle(1.5));
        classSevenBtn.setMaxSize(15, 15);
        classSevenBtn.setMinSize(15, 15);

        classEightBtn.setShape(new Circle(1.5));
        classEightBtn.setMaxSize(15, 15);
        classEightBtn.setMinSize(15, 15);

        toggleYesButton.setShape(new Circle(1.5));
        toggleYesButton.setMaxSize(15, 15);
        toggleYesButton.setMinSize(15, 15);

        toggleNoButton.setShape(new Circle(1.5));
        toggleNoButton.setMaxSize(15, 15);
        toggleNoButton.setMinSize(15, 15);

        startButton.setMinWidth(200);

        quantityField.setLayoutX(430);
        quantityField.setLayoutY(48);

        welcomeLabel.setLayoutX(210);
        welcomeLabel.setLayoutY(10);

        gradeLabel.setLayoutX(70);
        gradeLabel.setLayoutY(50);

        gradeLabel3.setLayoutX(120);
        gradeLabel3.setLayoutY(78);

        gradeLabel4.setLayoutX(120);
        gradeLabel4.setLayoutY(103);

        gradeLabel5.setLayoutX(120);
        gradeLabel5.setLayoutY(128);

        gradeLabel6.setLayoutX(120);
        gradeLabel6.setLayoutY(153);

        gradeLabel7.setLayoutX(120);
        gradeLabel7.setLayoutY(178);

        gradeLabel8.setLayoutX(120);
        gradeLabel8.setLayoutY(203);

        quantityLabel.setLayoutX(250);
        quantityLabel.setLayoutY(50);

        randomLabel.setLayoutX(250);
        randomLabel.setLayoutY(100);

        labelYes.setLayoutX(480);
        labelYes.setLayoutY(105);

        labelNo.setLayoutX(480);
        labelNo.setLayoutY(135);

        classThreeBtn.setLayoutX(100);
        classThreeBtn.setLayoutY(80);

        classFourBtn.setLayoutX(100);
        classFourBtn.setLayoutY(105);

        classFiveBtn.setLayoutX(100);
        classFiveBtn.setLayoutY(130);

        classSixBtn.setLayoutX(100);
        classSixBtn.setLayoutY(155);

        classSevenBtn.setLayoutX(100);
        classSevenBtn.setLayoutY(180);

        classEightBtn.setLayoutX(100);
        classEightBtn.setLayoutY(205);

        toggleYesButton.setLayoutX(460);
        toggleYesButton.setLayoutY(105);

        toggleNoButton.setLayoutX(460);
        toggleNoButton.setLayoutY(135);

        startButton.setLayoutX(300);
        startButton.setLayoutY(200);

        startButton.setOnAction((event) -> {
            List<Integer> selectedGroups = (List)toggleButtons.stream().filter((button) -> {
                return button.isSelected();
            }).map((toggle) -> {
                return Integer.parseInt(toggle.getId());
            }).collect(Collectors.toList());
            boolean hussleQuestions = ((ToggleButton)yesNoGroup.getSelectedToggle()).getId().equals("yes");
            int sumAmount = RekentrainerApplication.isEmpty(quantityField.getText()) ? 1 : Integer.parseInt(quantityField.getText());
            System.out.println(selectedGroups);

            try {
                primaryStage.setScene(new CalculateView(new SettingsModel(selectedGroups, hussleQuestions, sumAmount), userModel, primaryStage, new Pane(), width, height));
            } catch (Exception var14) {
                var14.printStackTrace();
            }

        });
        ((Pane)root).getChildren().addAll(new Node[]{classThreeBtn, classFourBtn, classFiveBtn, classSixBtn, classSevenBtn, classEightBtn, toggleYesButton, toggleNoButton, startButton, gradeLabel, gradeLabel3, gradeLabel4, gradeLabel5, gradeLabel6, gradeLabel7, gradeLabel8, quantityLabel, randomLabel, labelYes, labelNo, welcomeLabel, quantityField});
    }
}
