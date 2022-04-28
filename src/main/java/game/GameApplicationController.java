package game;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import utils.GameUtils;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameApplicationController implements Initializable {

    @FXML
    private TextArea mainArea;

    @FXML
    private TextArea menuArea;

    @FXML
    private MenuItem itemBag;

    @FXML
    private MenuItem player;

    @FXML
    private Button straight;

    @FXML
    private Button left;

    @FXML
    private Button right;

    @FXML
    private ImageView compass;

    public static final ExecutorService SERVICE = Executors.newSingleThreadExecutor();

    private static volatile double vCmp = .0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        mainArea.setText("Впереди Лес");

        right.setOnAction(actionEvent -> {
            SERVICE.execute(() -> smoothRotate(1));
        });
        left.setOnAction(actionEvent -> {
            SERVICE.execute(() -> smoothRotate(-1));
        });
    }

    private synchronized void smoothRotate(double v) {
        int degree = 0;
        while (degree < 90) {
            vCmp += v;
            GameUtils.waitFor(5);
            compass.setRotate(vCmp);
            degree++;
        }
    }
}