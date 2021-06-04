package com.example.jpashop.domain;

import com.example.jpashop.dto.OrderDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DELIVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    public static Delivery createDelivery(OrderDto.AddressDto request) {
        return Delivery.builder()
                .address(Address.builder()
                        .city(request.getCity()).street(request.getStreet()).zipcode(request.getZipcode())
                        .build())
                .status(DeliveryStatus.READY)
                .build();
    }

    public void cancelDelivery() {
        this.status = DeliveryStatus.CANCEL;
    }
}
