package GUI.presentacio;

import domini.Controller;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Popup;

import java.io.IOException;





public class BoardFXController{

    Observable timer ;

    @FXML
    private Label timelabel;

    @FXML
    private Button green, target, blue;

    private int round = 1;

    final Popup popup_yesno;
    Label lb;

    private domini.Controller controller;




    public BoardFXController(){
        popup_yesno = new Popup(); popup_yesno.setX(800); popup_yesno.setY(400);

        // Vbox for group
        VBox vBox   = new VBox();
        Pane canvas = new Pane();
        canvas.setStyle("-fx-background-image: url(panelpopup.png);");
        canvas.setPrefSize(359,179);


        Button ok = new Button();
        ok.setPrefSize(69,71);
        ok.setStyle("-fx-background-image: url(acceptbutton.png); -fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent;");
        ok.setLayoutX(85);
        ok.setLayoutY(130);

        Button nok = new Button();
        nok.setPrefSize(69,71);
        nok.setStyle("-fx-background-image: url(cancelbutton.png); -fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent;");
        nok.setLayoutX(200);
        nok.setLayoutY(130);
        nok.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                popup_yesno.hide();
            }
        });


        lb = new Label();
        lb.setFont(new Font("Carter One",22));
        lb.setLayoutY(50);
        lb.setLayoutX(45);

        canvas.getChildren().add(lb);
        canvas.getChildren().add(ok);
        canvas.getChildren().add(nok);


        vBox.getChildren().add(canvas);

        popup_yesno.getContent().addAll(vBox);

    }

    public void setController(Controller controller) {
        this.controller = controller;
    }



    @FXML
    public void handleDragOver(DragEvent de){
        if(de.getDragboard().hasString()){
            de.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    public void handleTextDroped(DragEvent ev){

        String str = ev.getDragboard().getString();
        Object objectiu = ev.getSource();
        if (objectiu instanceof Button) {

            Button  but = (Button) objectiu;
            System.out.println("ID "+ but.getId());
            String rnd = String.valueOf(round);
            if( rnd.equals( (but.getId()).replaceAll("\\D+","")) )  {
                if (str.equals("green")) {
                    but.setStyle("-fx-background-image:  url(green.png); -fx-border-color:  transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; ");
                } else if (str.equals("blue")) {
                    but.setStyle("-fx-background-image:  url(blue.png); -fx-border-color:  transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; ");
                } else if (str.equals("red")) {
                    but.setStyle("-fx-background-image:  url(red.png); -fx-border-color:  transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; ");
                } else if (str.equals("orange")) {
                    but.setStyle("-fx-background-image:  url(orange.png); -fx-border-color:  transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; ");
                } else if (str.equals("yellow")) {
                    but.setStyle("-fx-background-image:  url(yellow.png); -fx-border-color:  transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; ");
                } else if (str.equals("purple")) {
                    but.setStyle("-fx-background-image:  url(purple.png); -fx-border-color:  transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; ");
                }
            }
        }

    }


    @FXML
    public void handleDragDetection(MouseEvent ev) {
        Object src = ev.getSource();
        if (src instanceof Button) {
            Button bsrc = (Button) src;
            Dragboard db = green.startDragAndDrop(TransferMode.ANY);

            ClipboardContent cb = new ClipboardContent();
            cb.putString(bsrc.getId());

            db.setContent(cb);
            ev.consume();
        }
    }

    @FXML
    public void showHint (ActionEvent event) throws IOException {
        lb.setText("Hint!");
        popup_yesno.show(green.getScene().getWindow());




    }

    @FXML
    public void saveGame (ActionEvent event) throws IOException {
        lb.setText("Do you want to save game?");
        popup_yesno.show(green.getScene().getWindow());


    }

    @FXML
    public void exitGame (ActionEvent event) throws IOException {
        lb.setText("Do you want to save\n before exit?");
        popup_yesno.show(green.getScene().getWindow());
    }


}
