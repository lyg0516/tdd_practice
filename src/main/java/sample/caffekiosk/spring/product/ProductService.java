package sample.caffekiosk.spring.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sample.caffekiosk.spring.product.response.ProductResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductResponse> getSellingProduct(){
        List<Product> products = productRepository.findAllBySellingStatusIn(ProductSellingStatus.forDisplay());

        List<ProductResponse> response = products.stream().map(product -> ProductResponse.of(product))
                .collect(Collectors.toList());
        return response;
    }
}
