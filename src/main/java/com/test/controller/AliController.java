package com.test.controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.test.model.request.AliModel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@RestController
public class AliController {
	@RequestMapping(value = "/enbankEnterNextPage", method = RequestMethod.POST)
	public void ali(@RequestBody AliModel aliModel, HttpSession session) throws UnirestException {
		HttpResponse<String> stringHttpResponse = Unirest.post("https://mobil.teb.com.tr/cepteteb/CheckSecondFactor.json")
				.header("Cookie", "JSESSIONID=wjUL6tl0tg06-FBauOjkXQVZvPwXgBMiWXekc_tsmr7fYFf9pk1J!-701421664")
				.body("{\"deviceOsVersion\" : \"4.4.2\",\"appVersion\" : \"\",\"sifreNetIndex\" : -1,\"parola\" : \"371281\"}")
				.asString();
		System.out.println(stringHttpResponse.getBody());
	}
}
