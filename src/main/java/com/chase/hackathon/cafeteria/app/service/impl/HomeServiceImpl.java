package com.chase.hackathon.cafeteria.app.service.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;

import com.chase.hackathon.cafeteria.app.model.Item;
import com.chase.hackathon.cafeteria.app.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public String myOrder() {
		try {
			Map<String, Object> resMap = null;

			resMap = jdbcTemplate.queryForMap(
					"select order_json,order_time from ORDERS where order_status=? and confirmationToken=?", "C",
					"Sh@1475779583817");

			System.out.println(resMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String userOrder() {

		final String orderJSON = getMyOrder();
		String name = "Shirish";

		final String confToken = getToken(name);

		boolean ex = jdbcTemplate.execute("insert into ORDERS(confirmationToken,order_json,order_status) values(?,?,?)",
				new PreparedStatementCallback<Boolean>() {

					public Boolean doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {

						ps.setString(1, confToken);
						ps.setString(2, orderJSON);
						ps.setString(3, "P");

						return ps.execute();

					}
				});

		ackOrder(confToken, "30");
		return "" + ex;

	}

	public String ackOrder(final String confToken, final String time) {

		jdbcTemplate.execute("update  ORDERS set order_status=?,order_time=? where confirmationToken=?",
				new PreparedStatementCallback<Boolean>() {

					public Boolean doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {

						ps.setString(1, "C");
						ps.setString(2, time);
						ps.setString(3, confToken);

						return ps.execute();

					}
				});

		return null;
	}

	private String getToken(String name) {
		char[] nameArr = name.toCharArray();
		String confToken = "" + nameArr[0] + nameArr[nameArr.length - 1] + "@" + new Date().getTime();

		System.out.println(confToken);
		return confToken;

	}

	private String getMyOrder() {
		List<Item> list = new ArrayList<Item>();

		Item i1 = new Item("burger", "12.00", 3);

		Item i2 = new Item("burger2", "11.00", 4);

		list.add(i1);

		list.add(i2);

		ObjectMapper mapper = new ObjectMapper();
		String listJson = null;
		try {
			listJson = mapper.writeValueAsString(list);

			System.out.println(listJson);

			List<Item> listX = mapper.readValue(listJson, TypeFactory.collectionType(List.class, Item.class));
			System.out.println(listX);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listJson;

	}

	public void pollFromMerchant() {
		List<Map<String, Object>> resMap = null;
		resMap = jdbcTemplate.queryForList("select confirmationToken,order_json from ORDERS where order_status=?", "P");

	}

	public void pollFromUser() {
		Map<String, Object> resMap = null;

		resMap = jdbcTemplate.queryForMap(
				"select order_json,order_time from ORDERS where order_status=? and confirmationToken=?", "C",
				"Sh@1475779583817");

	}

}
