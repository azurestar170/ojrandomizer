package name.az170.ojrandomizer.gui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import name.az170.ojrandomizer.Card;
import name.az170.ojrandomizer.CardsResult;
import name.az170.ojrandomizer.CharaResult;
import name.az170.ojrandomizer.OJRandomizer;

public class OJRandomizerGUI extends Application {
    
    private static Logger logger = LogManager.getLogger();

    private OJRandomizer ojRandomizer = new OJRandomizer();
    
    private BorderPane root;
    private GridPane grid;
    private ToolBar toolBar;
    private ImageView[][] images = new ImageView[2][6];
    private HBox[][] hBoxes = new HBox[2][6];
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new BorderPane();
        
        initToolBar();
        initGrid();
        
        Scene scene = new Scene(root, 1000, 500);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("OJRandomizer");
        primaryStage.show();
    }
    
    private void initToolBar() {
        Button randomAllBtn = new Button("All");
        Button randomCharaBtn = new Button("Chara");
        Button randomCardsBtn = new Button("Cards");
        Button configBtn = new Button("Config");

        randomAllBtn.setOnAction(new RandomAllEventHandler());
        randomCharaBtn.setOnAction(new RandomCharaEventHandler());
        randomCardsBtn.setOnAction(new RandomCardsEventHandler());
        configBtn.setOnAction(new ConfigEventHandler());

        toolBar = new ToolBar(randomAllBtn, randomCharaBtn, randomCardsBtn);
        root.setTop(toolBar);
    }
    
    private void initGrid() {
        grid = new GridPane();
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                hBoxes[i][j] = new HBox();
                hBoxes[i][j].setAlignment(Pos.CENTER);
                images[i][j] = new ImageView();
                images[i][j].fitWidthProperty().bind(root.widthProperty().divide(6));
                images[i][j].fitHeightProperty().bind(
                        root.heightProperty().subtract(toolBar.heightProperty()).divide(2));
                images[i][j].setPreserveRatio(true);
                hBoxes[i][j].getChildren().add(images[i][j]);
                grid.add(hBoxes[i][j], j, i);
            }
        }
        
        for (int i = 0; i < 6; i++) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(1.0 / 6 * 100);
            grid.getColumnConstraints().add(columnConstraints);
        }

        for (int i = 0; i < 2; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(50.0);
            grid.getRowConstraints().add(rowConstraints);
        }
        
        root.setCenter(grid);
    }
    
    private void randomAll() {
        randomChara();
        randomCards();
    }
    
    private void randomChara() {
        CharaResult result = ojRandomizer.randomizeChara();
        Image image = new Image(getClass().getResourceAsStream("chara_" + result.getChara().name().toLowerCase() + ".jpg"));
        images[0][0].setImage(image);
    }
    
    private void randomCards() {
        CardsResult result = ojRandomizer.randomizeCards();
        int i = 0;
        for (Card card : result.getCardsMap().keySet()) {
            for (int j = 0; j < result.getCardsMap().get(card); j++) {
                Image image = new Image(getClass().getResourceAsStream("card_" + card.name().toLowerCase() + ".jpg"));
                int row = i / 5 == 0 ? 0 : 1;
                int column = i % 5 + 1;
                images[row][column].setImage(image);
                i++;
            }
        }
    }
    
    private void showConfigDialog() {
        // TODO
    }
    
    public class RandomAllEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            randomAll();
        }
        
    }
    
    public class RandomCharaEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            randomChara();
        }
        
    }
    
    public class RandomCardsEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            randomCards();
        }
        
    }
    
    public class ConfigEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            showConfigDialog();
        }
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
