package Models;

public class ResultModel {
    private int goodAnswers;
    private int wrongAnswers;

    public ResultModel(int goodAnswers, int wrongAnswers) {
        this.goodAnswers = goodAnswers;
        this.wrongAnswers = wrongAnswers;
    }

    public int getGoodAnswers() {
        return this.goodAnswers;
    }

    public void setGoodAnswers(int goodAnswers) {
        this.goodAnswers = goodAnswers;
    }

    public int getWrongAnswers() {
        return this.wrongAnswers;
    }

    public void setWrongAnswers(int wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
    }
}
