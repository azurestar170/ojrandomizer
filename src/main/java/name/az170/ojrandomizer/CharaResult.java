package name.az170.ojrandomizer;

public class CharaResult {

    private Character chara;
    private CharaConfig config;

    public CharaResult() {
    }

    public CharaResult(Character chara, CharaConfig config) {
        this.chara = chara;
        this.config = config;
    }

    public Character getChara() {
        return chara;
    }

    public void setChara(Character chara) {
        this.chara = chara;
    }

    public CharaConfig getConfig() {
        return config;
    }

    public void setConfig(CharaConfig config) {
        this.config = config;
    }

}
