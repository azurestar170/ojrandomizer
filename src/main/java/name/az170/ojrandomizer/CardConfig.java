package name.az170.ojrandomizer;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CardConfig {
    
    public static final int MAX_AMOUNT = Card.values().length;
    
    private List<FixedCard> fixedCards = new ArrayList<>();
    private Map<Card, RandomCard> mainCards = new LinkedHashMap<>();
    private Map<Card, RandomCard> subCards = new LinkedHashMap<>();
    
    private double mainProbability;
    
    public CardConfig() {
        init();
    }
    
    public CardConfig(File fromFile) {
        // TODO
    }
    
    public void init() {
        fixedCards.clear();
        mainCards.clear();
        subCards.clear();
        for (int i = 0; i < MAX_AMOUNT; i++) {
            RandomCard randomCard = new RandomCard();
            randomCard.setCard(Card.values()[i]);
            randomCard.setProbability(1.0);
            subCards.put(Card.values()[i], randomCard);
        }
    }
    
    public void loadConfig(File fromFile) {
        // TODO
    }
    
    public void saveConfig(File toFile) {
        // TODO
    }
    
    public List<FixedCard> getFixedCards() {
        return fixedCards;
    }

    public void setFixedCards(List<FixedCard> fixedCards) {
        this.fixedCards = fixedCards;
    }

    public Map<Card, RandomCard> getMainCards() {
        return mainCards;
    }

    public void setMainCards(Map<Card, RandomCard> mainCards) {
        this.mainCards = mainCards;
    }

    public Map<Card, RandomCard> getSubCards() {
        return subCards;
    }

    public void setSubCards(Map<Card, RandomCard> subCards) {
        this.subCards = subCards;
    }

    public double getMainProbability() {
        return mainProbability;
    }

    public void setMainProbability(double mainProbability) {
        this.mainProbability = mainProbability;
    }

    public static class FixedCard {

        private Card card;
        private int amount;

        public Card getCard() {
            return card;
        }

        public void setCard(Card card) {
            this.card = card;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

    }
    
    public static class RandomCard {

        private Card card;
        private double probability;
        private int max;

        public Card getCard() {
            return card;
        }

        public void setCard(Card card) {
            this.card = card;
        }

        public double getProbability() {
            return probability;
        }

        public void setProbability(double probability) {
            this.probability = probability;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

    }

}
