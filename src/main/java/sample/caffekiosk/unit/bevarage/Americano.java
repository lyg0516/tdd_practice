package sample.caffekiosk.unit.bevarage;

public class Americano implements Beverage {
    @Override
    public int getPrice() {
        return 3000;
    }

    @Override
    public String getName() {
        return "아메리카노";
    }
}
