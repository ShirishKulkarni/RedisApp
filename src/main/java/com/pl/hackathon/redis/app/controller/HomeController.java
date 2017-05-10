package com.pl.hackathon.redis.app.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pl.hackathon.redis.app.model.Item;

@RestController
@RequestMapping(value = "/order")
public class HomeController {



	@RequestMapping(value = "/get", method = RequestMethod.POST)
	@ResponseBody
	@Cacheable("item")
	public Item getOrder() {
		Item item = new Item("item1", "100", "10");
		try {
			Thread.sleep(2000);// calling some heavy service!!!
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	@CachePut("item")
	public Item updateOrder() {
		Item item = new Item("item2", "120", "7");
		return item;
	}

	@RequestMapping(value = "/del", method = RequestMethod.POST)
	@ResponseBody
	@CacheEvict("item")
	public void deleteOrder() {

		// nothing..... cache cleared..... long getOrder() is called!

	}
}
