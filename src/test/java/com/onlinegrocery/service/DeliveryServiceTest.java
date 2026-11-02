
package com.onlinegrocery.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.onlinegrocery.dto.DeliveryDto;
import com.onlinegrocery.entity.Delivery;
import com.onlinegrocery.repo.DeliveryRepo;
import com.onlinegrocery.serviceImpl.DeliveryServiceImpl;

@ExtendWith(MockitoExtension.class)
public class DeliveryServiceTest {

    @Mock
    private DeliveryRepo deliveryRepo;

    @InjectMocks
    private DeliveryServiceImpl deliveryService;

    @Test
    void testAddDeliverySlots() {
        DeliveryDto deliveryDto = new DeliveryDto();

        Delivery savedDelivery = new Delivery();
        savedDelivery.setDeliveryId(deliveryDto.getDeliveryId());
        savedDelivery.setDeliveryDate(deliveryDto.getDeliveryDate());
        savedDelivery.setDeliveryTime(deliveryDto.getDeliveryTime());

        when(deliveryRepo.save(any(Delivery.class)))
                .thenReturn(savedDelivery);

        DeliveryDto result = deliveryService.addDeliverySlots(deliveryDto);

        assertEquals(deliveryDto.getDeliveryId(), result.getDeliveryId());
        assertEquals(deliveryDto.getDeliveryDate(), result.getDeliveryDate());
        assertEquals(deliveryDto.getDeliveryTime(), result.getDeliveryTime());

        verify(deliveryRepo).save(any(Delivery.class));
    }
}
