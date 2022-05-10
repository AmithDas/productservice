package com.amith.springcloud.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.amith.springcloud.model.Coupon;

@FeignClient("GATEWAY-SERVICE")
public interface CouponClient {
	
	@GetMapping("/couponapi/coupons/{code}")
	Coupon getCoupon(@PathVariable("code") String code);

}
