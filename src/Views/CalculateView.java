package Views;

import Main.RekentrainerApplication;
import Models.CalculateModel;
import Models.ResultModel;
import Models.SettingsModel;
import Models.UserModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CalculateView extends Scene {
    private Stage primaryStage;
    private double width;
    private double height;
    private UserModel userModel;
    private SettingsModel settingsModel;
    private Label numOneLabel = new Label("");
    private Label symbolLabel = new Label("");
    private Label numTwoLabel = new Label("");
    private Label equalsLabel = new Label("=");
    private Label goodAnswerLabel = new Label("Aantal sommen goed: ");
    private Label wrongAnswerLabel = new Label("Aantal sommen fout: ");
    private Label toGoLabel = new Label("Nog 12 sommen te maken");
    private Button nextBtn = new Button("Volgende som");
    private TextField resultField = new TextField("");
    private List<CalculateModel> allSums;
    private int currentSumIndex = 0;
    private int goodAnswers = 0;
    private int wrongAnswers = 0;
    private int high;
    private int low;

    public CalculateView(SettingsModel settingsModel, UserModel userModel, Stage primaryStage, Parent root, double width, double height) throws Exception {
        super(root, 600, 400);
        this.primaryStage = primaryStage;
        this.userModel = userModel;
        this.settingsModel = settingsModel;
        this.width = width;
        this.height = height;
        this.allSums = this.generateSums(settingsModel);
        this.updateLabels((CalculateModel)this.allSums.get(this.currentSumIndex));
        Label welcomeLabel = new Label("Welkom " + userModel.getName() + ", Vul het antwoord van de volgende som in:");
        primaryStage.setTitle("Rekentrainer - Opdrachten scherm");
        welcomeLabel.setLayoutX(60);
        welcomeLabel.setLayoutY(30);
        this.numOneLabel.setLayoutX(100);
        this.numOneLabel.setLayoutY(130);
        this.symbolLabel.setLayoutX(170);
        this.symbolLabel.setLayoutY(130);
        this.numTwoLabel.setLayoutX(240);
        this.numTwoLabel.setLayoutY(130);
        this.equalsLabel.setLayoutX(310);
        this.equalsLabel.setLayoutY(130);
        this.resultField.setLayoutX(380);
        this.resultField.setLayoutY(140);
        this.goodAnswerLabel.setLayoutX(430);
        this.goodAnswerLabel.setLayoutY(300);
        this.wrongAnswerLabel.setLayoutX(430);
        this.wrongAnswerLabel.setLayoutY(320);
        this.toGoLabel.setLayoutX(430);
        this.toGoLabel.setLayoutY(340);
        this.nextBtn.setLayoutX(170);
        this.nextBtn.setLayoutY(250);
        welcomeLabel.setFont(new Font(15));
        this.numOneLabel.setFont(new Font(60));
        this.symbolLabel.setFont(new Font(60));
        this.numTwoLabel.setFont(new Font(60));
        this.equalsLabel.setFont(new Font(60));
        this.resultField.setFont(new Font(25));
        this.resultField.setMaxSize(100, 100);
        this.resultField.setMinHeight(60);
        this.nextBtn.setMinWidth(250);
        this.resultField.setAlignment(Pos.CENTER);

        this.nextBtn.setOnAction((e) -> {
            if (!RekentrainerApplication.isEmpty(this.resultField.getText())) {
                if (((CalculateModel)this.allSums.get(this.currentSumIndex)).getAnswer() == Integer.parseInt(this.resultField.getText())) {
                    ++this.goodAnswers;
                } else {
                    ++this.wrongAnswers;
                }

                if (this.currentSumIndex < this.allSums.size() - 1) {
                    this.updateLabels((CalculateModel)this.allSums.get(++this.currentSumIndex));
                } else {
                    primaryStage.setScene(new ResultView(new ResultModel(this.goodAnswers, this.wrongAnswers), userModel, new Pane(), primaryStage, width, height));
                }

            }
        });
        ((Pane)root).getChildren().addAll(new Node[]{welcomeLabel, this.numOneLabel, this.symbolLabel, this.numTwoLabel, this.equalsLabel, this.resultField, this.nextBtn, this.goodAnswerLabel, this.wrongAnswerLabel, this.toGoLabel});
    }

    private List<CalculateModel> generateSums(SettingsModel settingsModel) throws Exception {
        List<CalculateModel> List = new ArrayList();
        Random r = new Random();
        String symbol = "";

        for(int i = 0; i < settingsModel.getSumAmount(); ++i) {
            int high = 10;
            int low = 0;
            symbol = "+";
            int num1 = r.nextInt(high - low) + low;
            int num2 = r.nextInt(high - low) + low;
            List.add(new CalculateModel(num1, symbol, num2, this.getResult(num1, symbol, num2)));
        }

        return List;
    }

    private void updateLabels(CalculateModel calculateModel) {
        this.resultField.setText("");
        this.numOneLabel.setText(Integer.toString(calculateModel.getNum1()));
        this.symbolLabel.setText(calculateModel.getSymbol());
        this.numTwoLabel.setText(Integer.toString(calculateModel.getNum2()));
        this.goodAnswerLabel.setText("Aantal sommen goed: " + this.goodAnswers);
        this.wrongAnswerLabel.setText("Aantal sommen fout: " + this.wrongAnswers);
        this.toGoLabel.setText("Nog " + (this.settingsModel.getSumAmount() - this.currentSumIndex) + " sommen te maken");
    }

    private Integer getResult(int num1, String symbol, int num2) throws Exception {
        byte var5 = -1;
        switch(symbol.hashCode()) {
            case 42:
                if (symbol.equals("*")) {
                    var5 = 2;
                }
                break;
            case 43:
                if (symbol.equals("+")) {
                    var5 = 0;
                }
            case 44:
            case 46:
            default:
                break;
            case 45:
                if (symbol.equals("-")) {
                    var5 = 1;
                }
                break;
            case 47:
                if (symbol.equals("/")) {
                    var5 = 3;
                }
        }

        switch(var5) {
            case 0:
                return num1 + num2;
            case 1:
                return num1 - num2;
            case 2:
                return num1 * num2;
            case 3:
                return num1 / num2;
            default:
                throw new Exception("symbol unknown");
        }
    }
}
