package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Main extends Application {

    private final int SCREEN_WIDTH = 1000;
    private final int SCREEN_HEIGHT = 800;
    private final int FONT_SIZE = 30;
    private final String FONT_NAME = "verdana";
    private final Color BACKGROUND_COLOR = Color.BURLYWOOD;

    public Main() throws FileNotFoundException {

    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        Group root = new Group();
        Scene scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT, BACKGROUND_COLOR);
        final Canvas canvas = new Canvas(SCREEN_WIDTH,SCREEN_HEIGHT);

        CreateTextNodes(root);

        RevealInstructions(root);

        root.getChildren().add(canvas);

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                KeyCode pressed = keyEvent.getCode();
                if (pressed == KeyCode.Q) {
                    QuitGame(root);
                }
                else if (pressed == KeyCode.ENTER) {
                    Game game = null;
                    try {
                        game = new Game(primaryStage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    game.play();
                }
            }
        });

        primaryStage.setTitle("Ultimate Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void RevealInstructions(Group root) {
        Rectangle coverInstructions = new Rectangle(240, 235, 315, 165);
        coverInstructions.setFill(BACKGROUND_COLOR);
        root.getChildren().add(coverInstructions);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                coverInstructions.setY(coverInstructions.getY() + 0.3);
                coverInstructions.setHeight(coverInstructions.getHeight() - 0.3);
            }
        };
        timer.start();
    }

    public void QuitGame(Group root) {
        Rectangle rect = new Rectangle(SCREEN_WIDTH/4, SCREEN_HEIGHT/4 - 25, SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
        rect.setFill(Color.WHITE);
        Text quitMessage = Util.CreateTextNode(
                "Thanks for playing!",
                FONT_NAME, FontWeight.NORMAL, Color.BLACK, FONT_SIZE/2,
                SCREEN_WIDTH/4 + 25, SCREEN_HEIGHT/4
        );
        root.getChildren().add(rect);
        root.getChildren().add(quitMessage);

        AnimationTimer quitDelay = new AnimationTimer() {
            int counter = 0;
            @Override
            public void handle(long now) {
                counter += 1;
                if (counter > 500) {
                    System.exit(0);
                }
            }
        };
        quitDelay.start();
    }

    public void CreateTextNodes(Group root) {
        Text gameTitle = Util.CreateTextNode(
                "Ultimate Tic Tac Toe",
                FONT_NAME, FontWeight.BOLD, Color.WHITESMOKE, FONT_SIZE,
                325, 100
        );

        Text instructionsTitle = Util.CreateTextNode(
                "      Instructions",
                FONT_NAME, FontWeight.BOLD, Color.WHITESMOKE, FONT_SIZE,
                340, 200
        );

        Text commands = Util.CreateTextNode(
                "Enter - Start Game\n\n" +
                        "q - Quit Game\n\n",
                FONT_NAME, FontWeight.NORMAL, Color.WHITESMOKE, FONT_SIZE/2,
                340, 250
        );

        root.getChildren().add(gameTitle);
        root.getChildren().add(instructionsTitle);
        root.getChildren().add(commands);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
