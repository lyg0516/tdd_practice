package sample.caffekiosk.unit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sample.caffekiosk.unit.bevarage.Americano;
import sample.caffekiosk.unit.bevarage.Latte;
import sample.caffekiosk.unit.order.Order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CafeKioskTest {

    @Test
    void add(){
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(new Americano());

        System.out.println(">>> 담긴 음료 수: " + cafeKiosk.getBeverages().size());
        System.out.println(">>> 담긴 음료: "+ cafeKiosk.getBeverages().get(0).getName());
    }

    @DisplayName("주문 목록에 담긴 상품들의 총 금액을 계산할 수 있다.")
    @Test
    void addSeveralBeveragesTest(){
        //given
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.addSeveralBeverages(new Americano(), 2);

        //when
        assertThat(cafeKiosk.getBeverages().size()).isEqualTo(2);

        //then
        assertThatThrownBy(() -> cafeKiosk.addSeveralBeverages(new Americano(), 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음료는 1잔 이상 주문하실 수 있습니다.");
    }

    @Test
    void createOrderTest() {
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();

        cafeKiosk.add(americano);

        Order order = cafeKiosk.createOrder();

        assertThat(order.getBeverages()).hasSize(1);
        assertThat(order.getBeverages().get(0).getName()).isEqualTo("아메리카노");
    }

    @DisplayName("음료 한개 추가하면 주문 목록에 담긴다.")
    @Test
    void calculateTotalPriceTest(){
        CafeKiosk cafeKiosk = new CafeKiosk();
        Americano americano = new Americano();
        Latte latte = new Latte();

        cafeKiosk.add(americano);
        cafeKiosk.add(latte);

        int totalPrice = cafeKiosk.calculateTotalPrice();

        assertThat(totalPrice).isEqualTo(americano.getPrice() + latte.getPrice());

    }
}