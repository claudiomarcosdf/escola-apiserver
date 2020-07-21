package com.escolaapiserver.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class UserAuditing implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		//String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		return Optional.of("master");
	}
	
	

}
