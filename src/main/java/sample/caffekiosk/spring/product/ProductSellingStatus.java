package sample.caffekiosk.spring.product;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public enum ProductSellingStatus {

    SELLING("판매중"),
    HOLD("판매 보류"),
    STOP_SELLING("판매중지");

    public static List<ProductSellingStatus> forDisplay(){
        return List.of(SELLING, HOLD);
    };
    private final String text;
}
