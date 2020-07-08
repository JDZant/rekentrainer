package Main;

import Views.StartView;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RekentrainerApplication extends Application {
    public RekentrainerApplication() {
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Rekentrainer - Start Scherm");
        primaryStage.setScene(new StartView(primaryStage, new Pane(), 600, 250));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static boolean isEmpty(String value) {
        return value == null || "".equals(value);
    }
}
