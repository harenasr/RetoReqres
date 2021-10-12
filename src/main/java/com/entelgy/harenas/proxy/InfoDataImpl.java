package com.entelgy.harenas.proxy;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.entelgy.harenas.bean.Users;
import com.entelgy.harenas.exceptions.BaseException;


@Service
public class InfoDataImpl implements InfoData{

	@Value("${url.reqres.in}")
	private String url;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public Users obtenerData() throws BaseException {
		ResponseEntity<Users> response;
		try {
			RestTemplate restTemplate = new RestTemplate();
	        HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
	        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	        response = restTemplate.exchange(url, HttpMethod.GET,entity,Users.class);
		}catch (Exception e) {
			throw new BaseException(e);
		}
		return response.getBody();
	}
}
