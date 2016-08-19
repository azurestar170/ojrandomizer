package name.az170.ojrandomizer.gui;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.TableColumn.CellEditEvent;

public class ConfigDialog extends Dialog<ConfigDialogResult> {

    public ConfigDialog() {
        super();
        
        initUI();
        
        getDialogPane().getButtonTypes().add(new ButtonType("Save", ButtonData.OK_DONE));
        getDialogPane().getButtonTypes().add(new ButtonType("Cancel", ButtonData.CANCEL_CLOSE));
        setResultConverter(param -> returnResult(param));
    }
    
    private void initUI() {
        TabPane tabPane = new TabPane(createCharaTab(), createCardTab());
        getDialogPane().setContent(tabPane);
    }
    
    @SuppressWarnings("unchecked")
    private Tab createCharaTab() {
        TableView<CharaConfigRow> charaTable = new TableView<>();
        charaTable.setEditable(true);
        TableColumn<CharaConfigRow, ImageView> picColumn = new TableColumn<>("Pic");
        picColumn.setCellValueFactory(new PropertyValueFactory<>("pic"));
        TableColumn<CharaConfigRow, String> charaColumn = new TableColumn<>("Chara");
        charaColumn.setCellValueFactory(new PropertyValueFactory<>("chara"));
        TableColumn<CharaConfigRow, String> probabilityColumn = new TableColumn<>("Probability");
        probabilityColumn.setCellValueFactory(new PropertyValueFactory<>("probability"));
        TableColumn<CharaConfigRow, Integer> usedTimesColumn = new TableColumn<>("Used Times");
        probabilityColumn.setCellFactory(TextFieldTableCell.<CharaConfigRow>forTableColumn());
        probabilityColumn.setOnEditCommit((CellEditEvent<CharaConfigRow, String> event) -> {
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setProbability(event.getNewValue());
        });
        usedTimesColumn.setCellValueFactory(new PropertyValueFactory<>("usedTimes"));
        TableColumn<CharaConfigRow, Boolean> enabledColumn = new TableColumn<>("Enabled");
        enabledColumn.setCellValueFactory(new PropertyValueFactory<>("enabled"));
        charaTable.getColumns().addAll(
                picColumn, charaColumn, probabilityColumn, usedTimesColumn, enabledColumn);
        
        // test
        ObservableList<CharaConfigRow> list = FXCollections.observableArrayList();
        CharaConfigRow row = new CharaConfigRow();
        Image image = new Image(getClass().getResourceAsStream("chara_qp.jpg"));
        ImageView imageView = new ImageView(image);
        Rectangle2D viewportRect = new Rectangle2D(43, 54, 256, 256);
        imageView.setViewport(viewportRect);
        imageView.setFitWidth(50);
        imageView.setPreserveRatio(true);
        row.setPic(imageView);
        row.setChara("QP");
        row.setProbability("1");
        row.setUsedTimes(0);
        row.setEnabled(true);
        list.add(row);
        charaTable.setItems(list);
        
        Tab charaTab = new Tab("Chara", charaTable);
        charaTab.setClosable(false);
        return charaTab;
    }
    
    private Tab createCardTab() {
        Tab cardTab = new Tab("Tab");
        cardTab.setClosable(false);
        return cardTab;
    }
    
    private ConfigDialogResult returnResult(ButtonType button) {
        ConfigDialogResult result = null;
        if (button.getButtonData().equals(ButtonData.OK_DONE)) {
            // TODO
        }
        return result;
    }

}
