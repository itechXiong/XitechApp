package com.xitech.service.provider;

import org.springframework.stereotype.Service;

import com.xitech.service.StringResultService;

@Service("stringResultService")
public class StringResultServiceImpl implements StringResultService{

	@Override
	public String stringResult(String content) {
		// TODO Auto-generated method stub
		return "String result is "+content;
	}

}
