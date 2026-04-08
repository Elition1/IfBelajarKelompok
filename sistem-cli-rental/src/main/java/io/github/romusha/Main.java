package io.github.romusha;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Main extends Application {
    public int MAXHEIGHT = 800;
    public int MAXWIDTH = 800;

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();

        Scene scene = new Scene(root, Color.LIGHTBLUE);
        Image icon = new Image("icon_romusha.jpeg");
        Image car = new Image("mobil_xpander.jpg");
        ImageView imageView = new ImageView(car);
        imageView.setY(200);
        imageView.setX(100);
        imageView.setScaleX(2);
        imageView.setScaleY(2);

        Text text = new Text();
        text.setText("Femboy Berkualitas");
        text.setY(50);
        text.setX(50);

        root.getChildren().add(text);
        root.getChildren().add(imageView);
        stage.getIcons().add(icon);
        stage.setTitle("Just Rent n Go");
        stage.setHeight(MAXHEIGHT);
        stage.setWidth(MAXWIDTH);
        stage.setScene(scene);
        stage.show();
    }

    public void primaryStage(FXML primary) {

    }

    public static void main(String[] args) {
        launch(args);
    }

}