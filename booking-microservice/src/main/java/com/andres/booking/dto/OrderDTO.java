package com.andres.booking.dto;

import java.util.List;

import com.andres.booking.entity.OrderITem;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class OrderDTO {

	List<OrderITem> orderItems;
	
}
