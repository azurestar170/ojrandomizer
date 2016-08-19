package name.az170.ojrandomizer.gui;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.ImageView;

public class CharaConfigRow {

    private ImageView pic;
    private SimpleStringProperty chara = new SimpleStringProperty();
    private SimpleStringProperty probability = new SimpleStringProperty();
    private SimpleIntegerProperty usedTimes = new SimpleIntegerProperty();
    private SimpleBooleanProperty enabled = new SimpleBooleanProperty();

    public ImageView getPic() {
        return pic;
    }

    public void setPic(ImageView pic) {
        this.pic = pic;
    }

    public String getChara() {
        return chara.get();
    }

    public void setChara(String chara) {
        this.chara.set(chara);
    }

    public String getProbability() {
        return probability.get();
    }

    public void setProbability(String probability) {
        this.probability.set(probability);
    }

    public int getUsedTimes() {
        return usedTimes.get();
    }

    public void setUsedTimes(int usedTimes) {
        this.usedTimes.set(usedTimes);
    }

    public boolean getEnabled() {
        return enabled.get();
    }

    public void setEnabled(boolean enabled) {
        this.enabled.set(enabled);
    }

}
