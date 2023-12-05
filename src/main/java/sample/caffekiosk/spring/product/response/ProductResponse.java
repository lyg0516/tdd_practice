package sample.caffekiosk.spring.product.response;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import sample.caffekiosk.spring.product.Product;
import sample.caffekiosk.spring.product.ProductSellingStatus;
import sample.caffekiosk.spring.product.ProductType;

@Getter
public class ProductResponse {

    private Long id;
    private String productNumber;
    private ProductType type;
    private ProductSellingStatus sellingStatus;
    private String name;
    private int price;

    public static ProductResponse of(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .type(product.getType())
                .sellingStatus(product.getSellingStatus())
                .productNumber(product.getProductNumber())
                .price(product.getPrice())
                .build();
    }


    @Builder
    private ProductResponse(Long id, String productNumber, ProductType type, ProductSellingStatus sellingStatus, String name, int price) {
        this.id = id;
        this.productNumber = productNumber;
        this.type = type;
        this.sellingStatus = sellingStatus;
        this.name = name;
        this.price = price;
    }
}
