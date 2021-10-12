package com.entelgy.harenas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entelgy.harenas.bean.DataResponse;
import com.entelgy.harenas.service.ReqresServices;

@RestController
@RequestMapping("/api")
public class ReqresController {
	
	@Autowired
	ReqresServices reqresServices;
	
	@RequestMapping(value = "/v1/reestructure", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public DataResponse LogCrear() {
		DataResponse respuestaApi =  new DataResponse();
		
		try {
			respuestaApi = reqresServices.ObtenerData();
		} catch (Exception ex) {
			respuestaApi.setData(ex.getMessage());
		}
		
		return respuestaApi;
	}
}
