package name.az170.ojrandomizer;

public class Result {

    private CharaResult charaResult;
    private CardsResult cardResult;

    public Result() {
    }

    public Result(CharaResult charaResult, CardsResult cardResult) {
        this.charaResult = charaResult;
        this.cardResult = cardResult;
    }

    public CharaResult getCharaResult() {
        return charaResult;
    }

    public void setCharaResult(CharaResult charaResult) {
        this.charaResult = charaResult;
    }

    public CardsResult getCardResult() {
        return cardResult;
    }

    public void setCardResult(CardsResult cardResult) {
        this.cardResult = cardResult;
    }

}
