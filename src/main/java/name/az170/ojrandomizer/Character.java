package name.az170.ojrandomizer;

import java.util.HashMap;
import java.util.Map;

public enum Character {

    QP("QP"),
    YUKI("Yuki"),
    ARU("Aru"),
    SUGURI("Suguri"),
    HIME("Hime"),
    SORA("Sora"),
    MARC("Marc"),
    FELNET("Fernet"),
    PEAT("Peat"),
    KAI("Kai"),
    MARIE_POPPO("Marie Poppo"),
    TOMOMO("Tomomo"),
    CHICKEN("Chicken"),
    ROBO_BALL("Robo Ball"),
    SEAGULL("Seagull"),
    STORE_MANAGER("Store Manager"),
    SHIFU_ROBOT("Shifu Robot"),
    FLYING_CASTLE("Flying Castle"),
    SYURA("Syura"),
    NANAKO("Nanako"),
    QP_DANGEROUS("QP (Dangerous)"),
    SAKI("Saki"),
    KYOUSUKE("Kyousuke"),
    KRILA("Krila"),
    KAE("Kae"),
    ALTE("Alte"),
    KYOKO("Kyoko"),
    MARIE_POPPO_MIXED("Marie Poppo (Mixed)"),
    SHAM("Sham"),
    SHERRY("Sherry"),
    SORA_MILITARY("Sora (Military)"),
    STAR_BREAKER("Star Breaker"),
    SWEET_BREAKER("Sweet Breaker");
    
    private static Map<Character, Integer> indexMap = new HashMap<>();
    
    static {
        for (int i = 0; i < values().length; i++) {
            indexMap.put(values()[i], i);
        }
    }
    
    private String charaName;
    
    public static int indexOf(Character chara) {
        return indexMap.get(chara);
    }

    private Character(String charaName) {
        this.charaName = charaName;
    }
    
    public int getIndex() {
        return indexOf(this);
    }

    public String getCharaName() {
        return charaName;
    }
    
}
