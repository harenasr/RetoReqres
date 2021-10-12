package com.entelgy.harenas;

import static org.junit.jupiter.api.Assertions.*;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.entelgy.harenas.bean.Data;
import com.entelgy.harenas.bean.DataResponse;
import com.entelgy.harenas.bean.Support;
import com.entelgy.harenas.bean.Users;
import com.entelgy.harenas.controller.ReqresController;
import com.entelgy.harenas.proxy.InfoData;
import com.entelgy.harenas.proxy.InfoDataImpl;
import com.entelgy.harenas.service.ReqresServices;

@SpringBootTest
class ReqresControllerTest {

	InfoData infoDataMock = Mockito.mock(InfoDataImpl.class);
	
	@Autowired
	ReqresServices reqresServices;
	
	@Autowired
	ReqresController reqresController = new ReqresController();
	
	
	@BeforeEach
	void setUpBeforeClass() throws Exception {
		Users mockUsers = new Users();
		Support mocksupport = new Support();
		Data mockData =  new Data();
		List<Data> mockListData = new ArrayList<Data>();  ;
		mockUsers.setPage(1);
		mockUsers.setPer_page(6);
		mockUsers.setTotal(12);
		mockUsers.setTotal_pages(2);
		mocksupport.setUrl("https://reqres.in/#support-heading");
		mocksupport.setText("To keep ReqRes free, contributions towards server costs are appreciated!");
		mockData.setId(1);
		mockData.setFirst_name("George");
		mockData.setEmail("george.bluth@reqres.in");
		mockData.setLast_name("Bluth");
		mockData.setAvatar("https://reqres.in/img/faces/1-image.jpg");
		mockListData.add(mockData);
		mockUsers.setSupport(mocksupport);
		mockUsers.setData(mockListData);
		Mockito.when(infoDataMock.obtenerData()).thenReturn(mockUsers);
	}

	@Test
	void test() {
		DataResponse dataResponse;
		dataResponse = reqresController.LogCrear();
		
		assertEquals("1|Bluth|george.bluth@reqres.in,2|Weaver|janet.weaver@reqres.in,3|Wong|emma.wong@reqres.in,4|Holt|eve.holt@reqres.in,5|Morris|charles.morris@reqres.in,6|Ramos|tracey.ramos@reqres.in,", dataResponse.getData());
	}

}
