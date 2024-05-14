package com.example.spaceplatformer;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView bg1;

    @FXML
    private ImageView bg2;

    @FXML
    private ImageView bg3;

    @FXML
    private ImageView comet1;

    @FXML
    private ImageView comet2;

    @FXML
    private ImageView comet3;

    @FXML
    public ImageView player, boom;

    private int bg_height = 578;
    ParallelTransition parallelTransition;
    public static boolean W = false;
    public static boolean A = false;
    public static boolean S = false;
    public static boolean D = false;
    private  double playerSpeed = 1;
    @FXML
            private Label labelLose;
    TranslateTransition enemy1Transition, enemy2Transition, enemy3Transition;
    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            if (W && player.getLayoutY() > 0) {
                player.setLayoutY(player.getLayoutY() - playerSpeed);//up
            }
            if (S && player.getLayoutY() < 467) {// if(right == true)
                player.setLayoutY(player.getLayoutY() + playerSpeed);//down
            }
            if (D && player.getLayoutX() < 324) {// if(right == true)
                player.setLayoutX(player.getLayoutX() + playerSpeed);//right
            }
            if (A && player.getLayoutX() > 0) {// if(right == true)
                player.setLayoutX(player.getLayoutX() - playerSpeed);//left
            }

            if (player.getBoundsInParent().intersects(comet1.getBoundsInParent()) || player.getBoundsInParent().intersects(comet2.getBoundsInParent()) || player.getBoundsInParent().intersects(comet3.getBoundsInParent())) {
                parallelTransition.pause();
                enemy1Transition.pause();
                enemy2Transition.pause();
                enemy3Transition.pause();
                playerSpeed = 0;
                labelLose.setVisible(true);

                boom.setLayoutX(player.getLayoutX() -55);
                boom.setLayoutY(player.getLayoutY() -30);
                boom.setVisible(true);
            }
        }
    };

    @FXML
    void initialize() {
        TranslateTransition bg1Animation = new TranslateTransition(Duration.millis(4000), bg1);
        bg1Animation.setFromY(0);
        bg1Animation.setToY(bg_height + 1);
        bg1Animation.setInterpolator(Interpolator.LINEAR);

        TranslateTransition bg2Animation = new TranslateTransition(Duration.millis(4000), bg2);
        bg2Animation.setFromY(0);
        bg2Animation.setToY(bg_height + 1);
        bg2Animation.setInterpolator(Interpolator.LINEAR);

        TranslateTransition bg3Animation = new TranslateTransition(Duration.millis(4000), bg3);
        bg3Animation.setFromY(0);
        bg3Animation.setToY(bg_height + 1);
        bg3Animation.setInterpolator(Interpolator.LINEAR);

        parallelTransition = new ParallelTransition(bg1Animation, bg2Animation, bg3Animation);
        parallelTransition.setCycleCount(Animation.INDEFINITE);
        parallelTransition.play();

        enemy1Transition = new TranslateTransition(Duration.millis(4100), comet1);
        enemy1Transition.setFromY(-500);
        enemy1Transition.setFromX(+30);
        enemy1Transition.setToY(bg_height + 200);
        enemy1Transition.setInterpolator(Interpolator.LINEAR);
        enemy1Transition.setCycleCount(Animation.INDEFINITE);
        enemy1Transition.play();

        enemy2Transition = new TranslateTransition(Duration.millis(3100), comet2);
        enemy2Transition.setFromY(0);
        enemy2Transition.setFromX(-110);
        enemy2Transition.setToY(bg_height + 200);
        enemy2Transition.setInterpolator(Interpolator.LINEAR);
        enemy2Transition.setCycleCount(Animation.INDEFINITE);
        enemy2Transition.play();

        enemy3Transition = new TranslateTransition(Duration.millis(5100), comet3);
        enemy3Transition.setFromY(-400);
        enemy3Transition.setFromX(-240);
        enemy3Transition.setToY(bg_height + 200);
        enemy3Transition.setInterpolator(Interpolator.LINEAR);
        enemy3Transition.setCycleCount(Animation.INDEFINITE);
        enemy3Transition.play();

        timer.start();
    }

}
