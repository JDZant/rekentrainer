package Models;

public class CalculateModel {
    int num1;
    String symbol;
    int num2;
    int answer;

    public CalculateModel(int num1, String symbol, int num2, int answer) {
        this.num1 = num1;
        this.symbol = symbol;
        this.num2 = num2;
        this.answer = answer;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getNum1() {
        return this.num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return this.num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getAnswer() {
        return this.answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
