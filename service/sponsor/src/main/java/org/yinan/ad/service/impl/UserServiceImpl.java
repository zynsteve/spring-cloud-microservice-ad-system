package org.yinan.ad.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yinan.ad.constant.Constants;
import org.yinan.ad.dao.UserRepository;
import org.yinan.ad.entity.User;
import org.yinan.ad.exception.AdException;
import org.yinan.ad.service.IUserService;
import org.yinan.ad.utils.CommonUtils;
import org.yinan.ad.vo.CreateUserRequest;
import org.yinan.ad.vo.CreateUserResponse;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public CreateUserResponse createUser(CreateUserRequest request) throws AdException {
        if (!request.validate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        User oldUser = userRepository.findByUsername(request.getUsername());
        if (oldUser != null) {
            throw new AdException(Constants.ErrorMsg.SAME_NAME_ERROR);
        }

        User newUser = userRepository.save(new User(
                request.getUsername(),
                CommonUtils.md5(request.getUsername())
        ));
        return new CreateUserResponse(
                newUser.getId(), newUser.getUsername(), newUser.getToken(),
                newUser.getCreateTime(), newUser.getUpdateTime()
        );
    }
}
