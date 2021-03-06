package com.order;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController extends BaseController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("/saveorder")
	@ResponseStatus(code=HttpStatus.CREATED)
	void createOrder( @Valid @RequestBody OrderVO orderVO) {
		System.out.println(orderVO.toString());
		orderService.saveOrder(orderVO);
		
		System.out.println(orderVO.getItem());
		System.out.println(orderVO.getPrice());
	}
	
	@GetMapping("/getOrder")
	List<OrderVO> getOrder(){
		
		return orderService.getOrder();
		
	}

}
