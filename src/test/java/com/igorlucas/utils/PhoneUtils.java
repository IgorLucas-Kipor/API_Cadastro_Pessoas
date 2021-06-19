package com.igorlucas.utils;

import com.igorlucas.dto.request.PhoneDTO;
import com.igorlucas.entities.Phone;
import com.igorlucas.enums.PhoneType;

public class PhoneUtils {
	
	private static final String PHONE_NUMBER = "3198989-8989";
	private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
	private static final long PHONE_ID = 1L;
	
	public static PhoneDTO createFakeDTO() {
		return PhoneDTO.builder()
				.number(PHONE_NUMBER)
				.type(PHONE_TYPE)
				.build();
	}
	
	public static Phone createFakeEntity() {
		return Phone.builder()
				.id(PHONE_ID)
				.number(PHONE_NUMBER)
				.type(PHONE_TYPE)
				.build();
	}

}
