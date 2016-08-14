package name.az170.ojrandomizer;

import java.text.MessageFormat;
import java.util.Map;

public class CardsResult {

    private Map<Card, Integer> cardsMap;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cardsMap.keySet()) {
            if (cardsMap.get(card) > 0) {
                sb.append(MessageFormat.format("[{0}] = {1}\n", card.getCardName(), cardsMap.get(card)));
            }
        }
        return sb.toString();
    }

    public CardsResult() {
    }

    public CardsResult(Map<Card, Integer> cardsMap) {
        this.cardsMap = cardsMap;
    }

    public Map<Card, Integer> getCardsMap() {
        return cardsMap;
    }

    public void setCardsMap(Map<Card, Integer> cardsMap) {
        this.cardsMap = cardsMap;
    }
    
}
