package name.az170.ojrandomizer;

import java.util.HashMap;
import java.util.Map;

public enum Card {

    DASH("Dash!", false),
    SAKIS_COOKIE("Saki's Cookie", false),
    FLIP_OUT("Flip Out", false),
    LONG_DISTANCE_SHOT("Long-Distance Shot", false),
    NICE_JINGLE("Nice Jingle", true),
    NICE_PRESENT("Nice Present", true),
    STIFF_CRYSTAL("Stiff Crystal", true),
    PUDDING("Pudding", false),
    EXTEND("Extend", true),
    PRINCESSS_PRIVILEGE("Princess's Privilege", true),
    LONELY_CHARIOT("Lonely Chariot", false),
    AMBUSH("Ambush", false),
    PASSIONATE_RESEARCH("Passionate Research", true),
    PRESIDENTS_PRIVILEGE("President's Privilege", false),
    MIMIC("Mimic", false),
    IM_ON_FIRE("I'm on Fire!", false),
    RBITS("Rbits", false),
    RAINBOW_COLORED_CIRCLE("Rainbow-Colored Circle", false),
    BIG_MAGNUM("Big Magnum", false),
    SHIELD("Shield", false),
    FINAL_BATTLE("Final Battle", true),
    REVERSE_ATTRIBUTE_FIELD("Reverse Attribute Field", true),
    TACTICAL_RETREAT("Tactical Retreat", false),
    SHIELD_COUNTER("Shield Counter", true),
    BAD_PUDDING("Bad Pudding", false),
    MIMYUUS_HAMMER("Mimyuu's Hammer", false),
    DANGEROUS_PUDDING("Dangerous Pudding", false),
    PIGGY_BANK("Piggy Bank", false),
    INVASION("Invasion", false),
    GO_AWAY("Go Away", false),
    HEAT_300("Heat 300%", false),
    ASSAULT("Assault", false),
    TRAGEDY_IN_THE_DEAD_OF_NIGHT("Tragedy in the Dead of Night", false),
    EXCHANGE("Exchange", true),
    FLAMETHROWER("Flamethrower", false),
    SKY_RESTAURANT_PURES("Sky Restaurant 'Pures'", true),
    FOR_THE_FUTURE_OF_THE_TOY_STORE("For the Future of the Toy Store", true),
    PIYOPIYO_PROCESSION("Piyopiyo Procession", true),
    SEALED_MEMORIES("Sealed Memories", false),
    HERE_AND_THERE("Here and There", false),
    CLOUD_OF_SEAGULLS("Cloud of Seagulls", false),
    HOLY_NIGHT("Holy Night", true),
    OUT_OF_AMMO("Out of Ammo", false),
    GIFT_EXCHANGE("Gift Exchange", false),
    WE_ARE_WARUDA("We Are Waruda", false),
    DINNER("Dinner" ,false),
    SUPER_ALL_OUT_MODE("Super All-Out Mode", false),
    FORCED_REVIVAL("Forced Revival", false),
    LITTLE_WAR("Little War", true),
    OH_MY_FRIEND("Oh My Friend", true),
    SEALED_GUARDIAN("Sealed Guardian", true),
    MIX_PHENOMENON("Mix Phenomenon", true),
    SCARY_SOLICITATION("Scary Solicitation", true);
    
    private static Map<Card, Integer> indexMap = new HashMap<>();
    
    static {
        for (int i = 0; i < values().length; i++) {
            indexMap.put(values()[i], i);
        }
    }

    private String cardName;
    private boolean max1;
    
    public static int indexOf(Card card) {
        return indexMap.get(card);
    }

    private Card(String cardName, boolean max1) {
        this.cardName = cardName;
        this.max1 = max1;
    }
    
    public int getIndex() {
        return indexOf(this);
    }

    public String getCardName() {
        return cardName;
    }
    
    public boolean isMax1() {
        return max1;
    }
    
}
