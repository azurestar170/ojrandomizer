package name.az170.ojrandomizer.gui;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ButtonBar.ButtonData;

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
    
    private Tab createCharaTab() {
        Tab charaTab = new Tab("Chara");
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
