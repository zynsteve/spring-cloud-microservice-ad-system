package org.yinan.ad.service;

import org.yinan.ad.exception.AdException;
import org.yinan.ad.vo.CreateUserRequest;
import org.yinan.ad.vo.CreateUserResponse;

public interface IUserService {
    CreateUserResponse createUser(CreateUserRequest request) throws AdException;
}
