package GUI.presentacio;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInController implements Initializable {

    private ControllerPresentacio controller;

    public TextField usernameText;
    public PasswordField passwordText;
    public ImageView errorImage;


    @Override
    public void initialize(URL location, ResourceBundle resources){
        controller = new ControllerPresentacio();
    }

    public void setController(ControllerPresentacio controller) {
        this.controller = controller;
    }
    
    public void loginPressed(ActionEvent actionEvent) throws IOException {
        String username = usernameText.textProperty().get();
        String password = passwordText.textProperty().get();
        if(username.equals("") || password.equals("")){
            Image image = new Image("/GUI/assets/fillfields.png");
            errorImage.setImage(image);
        }
        else if (controller.logIn(username, password)) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Menu.fxml"));
            Parent sceneParent = loader.load();
            Scene scene = new Scene(sceneParent);

            MenuController menuController = loader.getController();
            menuController.setController(this.controller);

            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        }

        else {
            Image image = new Image("/GUI/assets/incorrectuserpasswd.png");
            errorImage.setImage(image);
        }
    }

    public void registerPressed(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Register.fxml"));
        Parent sceneParent = loader.load();
        Scene scene = new Scene(sceneParent);

        RegisterController regController = loader.getController();
        regController.setController(this.controller);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}