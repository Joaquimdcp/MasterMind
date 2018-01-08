package GUI.presentacio;

import domini.AnswerToken;
import domini.Controller;
import domini.Game;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Popup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;


public class BoardFXController{

    Observable timer ;

    @FXML
    private Label timelabel;

    @FXML
    private Button green, blue, yellow, orange,red, purple, play;

    private int round = 1;

    final Popup popup_yesno;
    Label lb;

    private ControllerPresentacio controller;
    private int ncolors;
    private Map numbers = new Hashtable();
    private ArrayList<String> solution = new ArrayList<String>(Collections.nCopies(4, "green"));


    public BoardFXController(){
        numbers.put("second", 1);
        numbers.put("third" ,  2);
        numbers.put("forth" ,  3);
        numbers.put("five"  ,   4);

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

    public void setController(ControllerPresentacio controller) {
        this.controller = controller;
        Game cg = this.controller.getCurrentGame();
        this.ncolors = 4;
        System.out.println(this.ncolors);
        if(ncolors<6){ blue.setVisible(false); }
        if(ncolors<5){ purple.setVisible(false); }
        if(ncolors<4){ yellow.setVisible(false); }
        if(ncolors<3){ orange.setVisible(false); }
        if(ncolors<2){ red.setVisible(false); }
        if(ncolors<1){ green.setVisible(false); }
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
            System.out.println("RONDA " + rnd);
            if( rnd.equals( (but.getId()).replaceAll("\\D+","")) )  {
                String position = (but.getId()).replaceAll("[^A-Za-z]+", "");

                int pos = (int) numbers.get(position);
                System.out.println(pos);
                if (str.equals("green")) {

                    solution.set(pos-1,"green");
                    but.setStyle("-fx-background-image:  url(/GUI/assets/green.png); -fx-border-color:  transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; ");
                } else if (str.equals("blue")) {
                    solution.set(pos-1,"blue");
                    but.setStyle("-fx-background-image:  url(/GUI/assets/blue.png); -fx-border-color:  transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; ");
                } else if (str.equals("red")) {
                    solution.set(pos-1,"red");
                    but.setStyle("-fx-background-image:  url(/GUI/assets/red.png); -fx-border-color:  transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; ");
                } else if (str.equals("orange")) {
                    solution.set(pos-1,"orange");
                    but.setStyle("-fx-background-image:  url(/GUI/assets/orange.png); -fx-border-color:  transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; ");
                } else if (str.equals("yellow")) {
                    solution.set(pos-1,"yellow");
                    but.setStyle("-fx-background-image:  url(/GUI/assets/yellow.png); -fx-border-color:  transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; ");
                } else if (str.equals("purple")) {
                    solution.set(pos-1,"purple");
                    but.setStyle("-fx-background-image:  url(/GUI/assets/purple.png); -fx-border-color:  transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent; ");
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

    @FXML
    public void playRound (ActionEvent event) throws IOException {
        controller.setGuessTokensRound(solution);

        ArrayList<AnswerToken> resp = controller.getCurrentRound().getTokensAnswer();
        Node source = (Node) event.getSource();
        Scene sc = source.getScene();

        Button bt;
        String color;


        if(resp.size()>0) {
            String id1 = "#round" + round + "1";
            ;
            bt = (Button) sc.lookup(id1);
            color = resp.get(0).getColour();
            System.out.println(color);
            if (color == "White")
                bt.setStyle("-fx-background-image: url(/GUI/assets/whitedot.png); -fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent;");
            else if (color == "Black")
                bt.setStyle("-fx-background-image: url(/GUI/assets/blackdot.png); -fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent;");
            else
                bt.setStyle("-fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent;");
        }

        if(resp.size()>1) {
            String id2 = "#round" + round + "2";
            bt = (Button) sc.lookup(id2);
            color = resp.get(1).getColour();
            if (color == "White")
                bt.setStyle("-fx-background-image: url(/GUI/assets/whitedot.png); -fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent;");
            else if (color == "Black")
                bt.setStyle("-fx-background-image: url(/GUI/assets/blackdot.png); -fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent;");
            else
                bt.setStyle("-fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent;");
        }

        if(resp.size()>2) {
            String id3 = "#round" + round + "3";
            bt = (Button) sc.lookup(id3);
            color = resp.get(2).getColour();
            if (color == "White")
                bt.setStyle("-fx-background-image: url(/GUI/assets/whitedot.png); -fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent;");
            else if (color == "Black")
                bt.setStyle("-fx-background-image: url(/GUI/assets/blackdot.png); -fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent;");
            else
                bt.setStyle("-fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent;");
        }

        if(resp.size()>3) {
            String id4 = "#round" + round + "4";
            bt = (Button) sc.lookup(id4);
            color = resp.get(3).getColour();
            if (color == "White")
                bt.setStyle("-fx-background-image: url(/GUI/assets/whitedot.png); -fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent;");
            else if (color == "Black")
                bt.setStyle("-fx-background-image: url(/GUI/assets/blackdot.png); -fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent;");
            else
                bt.setStyle("-fx-border-color: transparent; -fx-border-width: 0; -fx-background-radius: 0; -fx-background-color: transparent;");
        }
        round++;

    }


}
