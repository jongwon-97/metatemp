package com.metalearnin.user.userdto;

import com.metalearnin.user.userentity.UserStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserSignUpDTO {
    private Long userId;
    private String userEmail;
    private String userPw;
    private String userRole;
    private String name;
    private String userGender;
    private LocalDate userBirth;
    private String userPhone;
    private String userPostcode;
    private String userAddress;
    private String userAddressDetail;
    private String userEduLevel;
    private Boolean userMarketingAgree;  // Boolean으로 변경
    private Boolean userPrivacyAgree;    // Boolean으로 변경
    private UserStatus userStatus;       // Enum으로 변경
    private LocalDateTime userCreatedAt;
    private LocalDateTime userUpdatedAt;
    private String userSns;
    private String userThumbnail;
    private LocalDateTime userLastLogin;
}
