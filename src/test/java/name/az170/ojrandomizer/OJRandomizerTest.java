package name.az170.ojrandomizer;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class OJRandomizerTest {

    private static Logger logger = LogManager.getLogger();
    
    @Test
    public void testRandomizeChara() {
        OJRandomizer randomizer = new OJRandomizer();
        CharaConfig config = new CharaConfig();
        for (int i = 0; i < CharaConfig.MAX_AMOUNT; i++) {
            config.setCharaEnabled(i, true);
            config.setChosenTime(i, 0);
            config.setProbability(i, 1.0);
        }
        
        Map<Character, Integer> countMap = new LinkedHashMap<>();
        for (Character chara : Character.values()) {
            countMap.put(chara, 0);
        }
        
        CharaResult charaResult = new CharaResult();
        charaResult.setConfig(config);
        
        for (int i = 0; i < 100000; i++) {
            charaResult = randomizer.randomizeChara(charaResult.getConfig());
            Character chara = charaResult.getChara();
            countMap.put(chara, countMap.get(chara) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        for (Entry<Character, Integer> entry : countMap.entrySet()) {
            sb.append(MessageFormat.format("{0}: {1}\n", entry.getKey().getCharaName(), entry.getValue()));
        }
        logger.info("\n" + sb.toString());
    }
    
    @Test
    public void testRandomizeChara2() {
        OJRandomizer randomizer = new OJRandomizer();
        CharaResult charaResult = randomizer.randomizeChara();
        logger.info(charaResult.getChara().getCharaName());
    }
    
    @Test
    public void testRandomizeCards() {
        OJRandomizer randomizer = new OJRandomizer();
        CardsResult cardsResult = randomizer.randomizeCards();
        logger.info("\n" + cardsResult.toString());
    }
    
    @Test
    public void testRandomizeCards2() {
        OJRandomizer randomizer = new OJRandomizer();
        Map<Card, Integer> cardCounts = new LinkedHashMap<>();
        for (int i = 0; i < Card.values().length; i++) {
            cardCounts.put(Card.values()[i], 0);
        }
        
        for (int i = 0; i < 100000; i++) {
            CardsResult cardsResult = randomizer.randomizeCards();
            for (Card card : cardsResult.getCardsMap().keySet()) {
                if (cardsResult.getCardsMap().get(card) > 0) {
                    cardCounts.put(card, cardCounts.get(card) + cardsResult.getCardsMap().get(card));
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (Card card : cardCounts.keySet()) {
            sb.append(MessageFormat.format("[{0}] = {1}\n", card.getCardName(), cardCounts.get(card)));
        }
        
        logger.info("\n" + sb.toString());
    }
    
}
