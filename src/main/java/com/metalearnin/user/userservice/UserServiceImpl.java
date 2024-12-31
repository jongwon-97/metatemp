package com.metalearnin.user.userservice;

import com.metalearnin.user.userdto.UserSignUpDTO;
import com.metalearnin.user.userentity.UserEntity;
import com.metalearnin.user.userrepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public boolean usersave(UserSignUpDTO userSignUpDTO) {
////        // 이메일 중복 체크
////        if (userRepository.findByUserEmail(userSignUpDTO.getUserEmail()) != null) {
////            return false;  // 이미 사용 중인 이메일이라면 회원가입 실패
//        }

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(userSignUpDTO.getUserPw());

        // UserEntity 객체 생성 후 저장
        UserEntity userEntity = UserEntity.builder()
                .userEmail(userSignUpDTO.getUserEmail()) // DTO에서 이메일 가져오기
                .userPw(encodedPassword) // 암호화된 비밀번호 설정
                .name(userSignUpDTO.getName())
                .userGender(userSignUpDTO.getUserGender())
                .userMarketingAgree(userSignUpDTO.getUserMarketingAgree())
                .userPrivacyAgree(userSignUpDTO.getUserPrivacyAgree())
                .userBirth(userSignUpDTO.getUserBirth())
                .userPhone(userSignUpDTO.getUserPhone()) // DTO에서 전화번호 가져오기
                .userRole("USER")  // 기본 역할을 USER로 설정
                .build();

        // UserEntity 저장
        userRepository.save(userEntity);

        return true;  // 회원가입 성공
    }
}
