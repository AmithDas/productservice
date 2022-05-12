package com.amith.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amith.springcloud.model.Coupon;
import com.amith.springcloud.model.Product;
import com.amith.springcloud.repos.ProductRepository;
import com.amith.springcloud.restclient.CouponClient;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/productapi")
@RefreshScope
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CouponClient couponClient;

	@Value("${com.amith.property}")
	private String prop;

	@PostMapping(value = "/products")
	@Retry(name = "product-api", fallbackMethod = "handleError")
	public Product create(@RequestBody Product product) {
		Coupon coupon = couponClient.getCoupon(product.getCouponCode());
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return productRepository.save(product);
	}
	
	@GetMapping(value = "/prop")
	public String getProp() {
		return this.prop;
	}
	
	public Product handleError(Product product, Exception exception) {
		System.out.println("Inside handle error method");
		return product;
	}

}
