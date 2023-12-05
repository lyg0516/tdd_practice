package sample.caffekiosk.spring.service.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sample.caffekiosk.spring.controller.order.request.OrderCreateRequest;
import sample.caffekiosk.spring.order.Order;
import sample.caffekiosk.spring.order.OrderRepository;
import sample.caffekiosk.spring.product.Product;
import sample.caffekiosk.spring.product.ProductRepository;
import sample.caffekiosk.spring.service.order.response.OrderResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderResponse createOrder(OrderCreateRequest request, LocalDateTime registeredDateTime) {
        List<String> productNumbers = request.getProductNumbers();
        List<Product> products = findProductsBy(productNumbers);

        Order order = Order.create(products, registeredDateTime);
        Order savedOrder = orderRepository.save(order);
        return OrderResponse.of(savedOrder);
    }

    private List<Product> findProductsBy(List<String> productNumbers) {
        List<Product> products = productRepository.findAllByProductNumberIn(productNumbers);
        Map<String, Product> productMap = products.stream()
                .collect(Collectors.toMap(Product::getProductNumber, p -> p));

        List<Product> duplicateProducts = productNumbers.stream()
                .map(productMap::get)
                .collect(Collectors.toList());
        return duplicateProducts;
    }
}
