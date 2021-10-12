package com.entelgy.harenas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entelgy.harenas.bean.Data;
import com.entelgy.harenas.bean.DataResponse;
import com.entelgy.harenas.bean.Users;
import com.entelgy.harenas.proxy.InfoData;

@Service
public class ReqresServices {

	@Autowired
	InfoData infoData;
	
	public DataResponse ObtenerData() {
		DataResponse dataResponse = new DataResponse();
		String cadena = "";
		try {
		Users users = infoData.obtenerData();
		for (Data item : users.getData()) {
			cadena = cadena + String.valueOf(item.getId())+ "|" + item.getLast_name() + "|" + item.getEmail() + ",";
		}
		}catch (Exception e) {
		}
		dataResponse.setData(cadena);
		
		return dataResponse;
	}
}
