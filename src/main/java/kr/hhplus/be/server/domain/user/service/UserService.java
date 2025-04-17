package kr.hhplus.be.server.domain.user.service;

import kr.hhplus.be.server.domain.user.model.User;
import kr.hhplus.be.server.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    // 유저 정보 확인
    public boolean checkUserInfo(long userId) throws Exception{
        User checkUser = userRepository.getUserInfo(userId);
        if(checkUser.getId() == null) {
            throw new RuntimeException("존재하지 않는 유저입니다.");
        }
        return true;
    }
}
