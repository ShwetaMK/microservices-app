package com.smk.booking.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.smk.booking.dto.OrdersDTO;
import com.smk.booking.service.BookingService;

@RestController
@RequestMapping("bookings")
public class BookingController {

	@Value("${order_url}")
	String orderUrl;
	@Value("${store_url}")
	String storeUrl;

//	@Autowired
//	BookingService bookingService;

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("orders")
	public ResponseEntity<OrdersDTO> getOrders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<OrdersDTO> l = restTemplate.exchange(orderUrl, HttpMethod.GET, entity, OrdersDTO.class);
		System.out.println(l);
//		l.status(HttpStatus.OK);
//		return l;
		return ResponseEntity.status(HttpStatus.OK).body(l.getBody());
//		return null;
	}

	@GetMapping("orders/{orderId}")
	public ResponseEntity<OrdersDTO> getOrder(Integer orderId) {
		String url = orderUrl;
		url = url + "/" + orderId;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<OrdersDTO> l = restTemplate.exchange(url, HttpMethod.GET, entity, OrdersDTO.class);
		System.out.println(l);
//		l.status(HttpStatus.OK);
//		return l;
		return ResponseEntity.status(HttpStatus.OK).body(l.getBody());
//		return null;
	}

}
