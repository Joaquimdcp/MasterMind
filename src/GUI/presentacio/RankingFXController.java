package GUI.presentacio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class RankingFXController implements Initializable {
    @FXML
    private Label user1 = new Label();
    @FXML
    private Label user2 = new Label();
    @FXML
    private Label user3 = new Label();
    @FXML
    private Label user4 = new Label();
    @FXML
    private Label user5 = new Label();
    @FXML
    private Label user6 = new Label();
    @FXML
    private Label user7 = new Label();
    @FXML
    private Label user8 = new Label();
    @FXML
    private Label user9 = new Label();
    @FXML
    private Label user10 = new Label();
    @FXML
    private Label score1 = new Label();
    @FXML
    private Label score2 = new Label();
    @FXML
    private Label score3 = new Label();
    @FXML
    private Label score4 = new Label();
    @FXML
    private Label score5 = new Label();
    @FXML
    private Label score6 = new Label();
    @FXML
    private Label score7 = new Label();
    @FXML
    private Label score8 = new Label();
    @FXML
    private Label score9 = new Label();
    @FXML
    private Label score10 = new Label();

    private ControllerPresentacio controller;

    private List<String> users = new ArrayList<String>() {{
        add("----");
        add("----");
        add("----");
        add("----");
        add("----");
        add("----");
        add("----");
        add("----");
        add("----");
        add("----");
    }};

    private List<String> scores = new ArrayList<String>() {{
        add("----");
        add("----");
        add("----");
        add("----");
        add("----");
        add("----");
        add("----");
        add("----");
        add("----");
        add("----");
    }};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateLists();

        user1.setText(users.get(0));
        user2.setText(users.get(1));
        user3.setText(users.get(2));
        user4.setText(users.get(3));
        user5.setText(users.get(4));
        user6.setText(users.get(5));
        user7.setText(users.get(6));
        user8.setText(users.get(7));
        user9.setText(users.get(8));
        user10.setText(users.get(9));

        score1.setText(scores.get(0));
        score2.setText(scores.get(1));
        score3.setText(scores.get(2));
        score4.setText(scores.get(3));
        score5.setText(scores.get(4));
        score6.setText(scores.get(5));
        score7.setText(scores.get(6));
        score8.setText(scores.get(7));
        score9.setText(scores.get(8));
        score10.setText(scores.get(9));
    }

    public void setController(ControllerPresentacio controller) {
        this.controller = controller;
    }

    public void showMenu (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Menu.fxml"));
        Parent rankingParent = loader.load();
        Scene rankingScene = new Scene(rankingParent);

        MenuController menuController = loader.getController();
        menuController.setController(this.controller);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(rankingScene);
        window.show();
    }

    public void updateLists() {
        Path path = Paths.get("ranking.txt");
        try (Stream<String> stream = Files.lines(path)) {
            int i = 0;
            for (String line : stream.toArray(String[]::new)) {
                StringTokenizer rankingLine = new StringTokenizer(line, "#");
                String username = rankingLine.nextToken();
                String score = rankingLine.nextToken();
                users.set(i, username);
                scores.set(i, score);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
