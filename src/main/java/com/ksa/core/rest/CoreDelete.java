package com.ksa.core.rest;

import org.apache.http.client.methods.HttpPost;

public class CoreDelete extends HttpPost {

	public CoreDelete() {
		//default constructor
	}

	public CoreDelete(String url) {
		super(url);
	}

	@Override
	public String getMethod() {

		return "DELETE";
	}
}
