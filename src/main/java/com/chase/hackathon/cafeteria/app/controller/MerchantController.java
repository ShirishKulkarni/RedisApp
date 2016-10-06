package com.chase.hackathon.cafeteria.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chase.hackathon.cafeteria.app.service.HomeService;
import com.test.Person;

@RestController
@RequestMapping(value = "/merchant")
public class MerchantController {

	@Autowired
	private HomeService homeService;

	@RequestMapping(value = "/pollfororder", method = RequestMethod.POST)
	@ResponseBody
	public String pollingOrder(@RequestBody Person person) {

		System.out.println(person);
		homeService.poll
	}

	@RequestMapping(value = "/confirmorder", method = RequestMethod.POST)
	@ResponseBody
	public String confirmOrder(@RequestBody Person person) {

		System.out.println(person);
		homeService.myOrder();
		return homeService.userOrder();
	}

}
