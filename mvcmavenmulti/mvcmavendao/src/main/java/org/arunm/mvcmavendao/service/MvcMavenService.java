package org.arunm.mvcmavendao.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



@Service
public class MvcMavenService {

	@Value("${mvc.property}")
	private String mvcproperty;

	public String getMvcproperty() {
		return mvcproperty;
	}
	
	
	
}
