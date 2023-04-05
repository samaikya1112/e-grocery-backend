package com.onlinegrocery.service;

import com.onlinegrocery.dto.LoginResponseDto;
import com.onlinegrocery.entity.AppUser;

public interface AppUserService{
	LoginResponseDto login( String userName,String password);
	AppUser register(AppUser appUser);
}

