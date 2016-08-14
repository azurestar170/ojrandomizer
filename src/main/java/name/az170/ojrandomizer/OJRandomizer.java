package name.az170.ojrandomizer;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import name.az170.ojrandomizer.CardConfig.FixedCard;
import name.az170.ojrandomizer.CardConfig.RandomCard;

public class OJRandomizer {
    
    public static final String OJ_CHARA_SAV_FILE = "saves/ojchara.sav";
    public static final String OJ_CARD_SAV_FOLDER = "saves/ojcard";
    
    public Result randomize() {
        CharaResult charaResult = randomizeChara();
        CardsResult cardResult = randomizeCards(charaResult.getChara());
        Result result = new Result(charaResult, cardResult);
        return result;
    }
    
    public CharaResult randomizeChara() {
        return randomizeChara(new CharaConfig(new File(OJ_CHARA_SAV_FILE)));
    }
    
    public CharaResult randomizeChara(CharaConfig config) {
        List<Character> charas = new ArrayList<>();
        List<Double> probabilities = new ArrayList<>();
        List<Integer> chosenTimes = new ArrayList<>();
        for (int i = 0; i < CharaConfig.MAX_AMOUNT; i++) {
            if (config.isCharaEnabled(i)) {
                charas.add(Character.values()[i]);
                probabilities.add(config.getProbability(i));
                chosenTimes.add(config.getChosenTime(i));
            }
        }
        
        if (charas.size() == 0) {
            return null;
        }
        
        int minChosenTime = chosenTimes.get(0);
        for (int chosenTime : chosenTimes) {
            if (chosenTime < minChosenTime) {
                minChosenTime = chosenTime;
            }
        }
        
        for (int i = 0; i < probabilities.size(); i++) {
            probabilities.set(i, probabilities.get(i) / Math.pow(2, (chosenTimes.get(i) - minChosenTime)));
        }
        
        double probabilitySum = 0.0;
        for (double probability : probabilities) {
            probabilitySum += probability;
        }
        double random = Math.random() * probabilitySum;
        int index = 0;
        double tempSum = 0.0;
        do {
            tempSum += probabilities.get(index);
            if (random < tempSum) {
                break;
            }
            index++;
        } while (index < probabilities.size());
        
        Character chara = charas.get(index);
        
        CharaConfig resultConfig = config.clone();
        resultConfig.plusChosenTime(chara);
        resultConfig.saveConfig(new File(OJ_CHARA_SAV_FILE));

        CharaResult result = new CharaResult(chara, resultConfig);
        return result;
    }
    
    public CardsResult randomizeCards() {
        return randomizeCards(new CardConfig());
    }
    
    public CardsResult randomizeCards(Character chara) {
        // TODO
        return null;
    }
    
    public CardsResult randomizeCards(CardConfig config) {
        int total = 0;
        Map<Card, Integer> cardsCount = new LinkedHashMap<>();
        for (int i = 0; i < Card.values().length; i++) {
            cardsCount.put(Card.values()[i], 0);
        }
        
        // Fixed cards
        List<FixedCard> fixedCards = config.getFixedCards();
        for (FixedCard fixedCard : fixedCards) {
            cardsCount.put(fixedCard.getCard(), fixedCard.getAmount());
            total++;
        }
        
        // Random cards
        while (total < 10) {
            double rand = Math.random();
            Card card = null;
            if (rand < config.getMainProbability()) {
                card = randomizeRandomCard(config.getMainCards());
            } else {
                card = randomizeRandomCard(config.getSubCards());
            }
            int cardCount = cardsCount.get(card);
            if (cardCount == (card.isMax1() ? 1 : 3)) {
                config.getMainCards().remove(card);
                config.getSubCards().remove(card);
            } else {
                cardsCount.put(card, cardCount + 1);
                total++;
            }
        }
        
        CardsResult result = new CardsResult(cardsCount);
        return result;
    }
    
    private Card randomizeRandomCard(Map<Card, RandomCard> randomCards) {
        double probabilitySum = 0.0;
        for (RandomCard randomCard : randomCards.values()) {
            probabilitySum += randomCard.getProbability();
        }
        
        double random = Math.random() * probabilitySum;
        double tempSum = 0.0;
        Card card = null;
        for (Entry<Card, RandomCard> entry : randomCards.entrySet()) {
            tempSum += entry.getValue().getProbability();
            if (random < tempSum) {
                card = entry.getKey();
                break;
            }
        }
        
        return card;
    }
    
}
