package com.example.ddd.order.application;

import com.example.ddd.order.application.dto.request.OrderRequest;
import com.example.ddd.order.domain.*;
import com.example.ddd.catalog.product.domain.Product;
import com.example.ddd.catalog.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderCommandService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrdererService ordererService;

    public void createOrder(OrderRequest orderRequest) {
        List<OrderLine> orderLines = getOrderLines(orderRequest);
        Orderer orderer = ordererService.createOrderer(orderRequest.getOrderer().getOrdererId());
        ShippingInfo shippingInfo = orderRequest.toShippingInfo();
        orderRepository.save(Order.from(orderer, shippingInfo, orderLines));
    }

    private List<OrderLine> getOrderLines(OrderRequest orderRequest) {
        return orderRequest.getProducts()
                .stream()
                .map(productRequest -> {
                    Product product = productRepository.findById(productRequest.getProductId())
                            .orElseThrow(IllegalArgumentException::new);
                    return OrderLine.to(product, productRequest.getQuantity());
                })
                .collect(Collectors.toList());
    }
}
