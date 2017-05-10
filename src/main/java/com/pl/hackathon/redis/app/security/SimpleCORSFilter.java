package com.pl.hackathon.redis.app.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class SimpleCORSFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest httpReq = (HttpServletRequest) req; //

		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
		response.setHeader("Access-Control-Allow-Origin", "*");
		if (httpReq.getMethod().equalsIgnoreCase("OPTIONS")) { //
			response.setHeader("Access-Control-Allow-Headers", //
					httpReq.getHeader("Access-Control-Request-Headers")); //
		}
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
		chain.doFilter(req, res);
	}

	public void init(FilterConfig filterConfig) {
		System.out.println("CORS Filter in action");
	}

	public void destroy() {
	}

}