package com.example.ddd.order.command.application;

import com.example.ddd.catalog.product.domain.Product;
import com.example.ddd.catalog.product.domain.ProductRepository;
import com.example.ddd.order.command.application.dto.request.AddressRequest;
import com.example.ddd.order.command.application.dto.request.OrderRequest;
import com.example.ddd.order.command.domain.*;
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

    public void changeOrderAddress(Long orderId, AddressRequest addressRequest) {
//        Order order = findWithOptimisticLockByIdOrElseThrow(orderId);
        Order order = findWithOptimisticLockByIdOrElseThrow(orderId);
        order.changeOrderAddress(addressRequest.toAddress());
    }

    public void changeOrderState(Long orderId, String orderState) {
//        Order order = findWithOptimisticLockByIdOrElseThrow(orderId);
        Order order = findWithOptimisticLockByIdOrElseThrow(orderId);
        try {
            // 실험을 위해 10초 대기
            Thread.sleep(5000);
        } catch (Exception e) {
            throw new IllegalStateException();
        }
        order.changeOrderState(OrderState.valueOf(orderState.toUpperCase()));
    }

    private Order findWithPessimisticLockByIdOrElseThrow(Long orderId) {
        return orderRepository.findWithPessimisticLockById(orderId).orElseThrow();
    }

    private Order findWithOptimisticLockByIdOrElseThrow(Long orderId) {
        return orderRepository.findWithOptimisticLockById(orderId).orElseThrow();
    }
}
