package com.entelgy.harenas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.entelgy.harenas.bean.Users;
import com.entelgy.harenas.exceptions.BaseException;
import com.entelgy.harenas.proxy.InfoData;

@SpringBootTest
class UsersTest {

	@Autowired
	InfoData infoData;
	
	@Test
	public void test() throws BaseException {
		Users users = infoData.obtenerData();
		int esperado = 1;
		assertEquals(esperado, users.getPage());
	}

}
