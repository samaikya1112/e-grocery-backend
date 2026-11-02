package com.onlinegrocery.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.onlinegrocery.dto.DeliveryDto;
import com.onlinegrocery.service.DeliveryService;
public class DeliveryControllerTest {
 
        @Test
        public void testAddDeliverySlots() {

            DeliveryDto deliverydto = mock(DeliveryDto.class);            
            DeliveryService deliveryservice = mock(DeliveryService.class);
            when(deliveryservice.addDeliverySlots(deliverydto)).thenReturn(deliverydto);
            DeliveryDto result = deliveryservice.addDeliverySlots(deliverydto);
            assertEquals(result, deliverydto);
        }
    }
 
    
 


