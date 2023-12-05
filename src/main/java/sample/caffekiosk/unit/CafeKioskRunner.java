package sample.caffekiosk.unit;

import sample.caffekiosk.unit.bevarage.Americano;
import sample.caffekiosk.unit.bevarage.Latte;

public class CafeKioskRunner {

    public static void main(String[] args) {
        CafeKiosk caffeKiosk =new CafeKiosk();
        caffeKiosk.add(new Americano());
        System.out.println("아메리카노 추가");
        caffeKiosk.add(new Latte());
        System.out.println("라뗴 추가");

        int totalPrice = caffeKiosk.calculateTotalPrice();
        System.out.println("총 주문 가격: " + totalPrice);
    }
}