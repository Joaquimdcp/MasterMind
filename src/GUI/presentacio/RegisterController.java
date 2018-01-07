package GUI.presentacio;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    private ControllerPresentacio controller;

    public TextField usernameText;
    public PasswordField passwordText;
    public PasswordField passwordText2;
    public ImageView errorImage;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        controller = new ControllerPresentacio();
    }

    public void registerPressed(ActionEvent actionEvent) throws IOException {
        String username = usernameText.textProperty().get();
        String password = passwordText.textProperty().get();
        String password2 = passwordText2.textProperty().get();
        if(username.equals("") || password.equals("") || password2.equals("")){
            Image image = new Image("/GUI/assets/fillfields.png");
            errorImage.setImage(image);
        }

        else{
            if(!password.equals(password2)) {
                Image image = new Image("/GUI/assets/passwordsdontmatch.png");
                errorImage.setImage(image);
            }
            else{
                if (controller.registerUser(username, password)){
                    Parent logInParent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                    Scene logInScene = new Scene(logInParent);

                    Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                    window.setScene(logInScene);
                    window.show();
                }
                else {
                    Image image = new Image("/GUI/assets/userexists.png");
                    errorImage.setImage(image);
                }
            }
        }
        passwordText.textProperty().set("");
        passwordText2.textProperty().set("");
    }

    public void loginPressed(ActionEvent actionEvent) throws IOException {
        Parent registerParent = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        Scene registerScene = new Scene(registerParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(registerScene);
        window.show();
    }
}