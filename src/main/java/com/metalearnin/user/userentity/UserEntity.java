package com.metalearnin.user.userentity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@EntityListeners(AuditingEntityListener.class)
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_email", nullable = false, unique = true)
    private String userEmail;

    @Column(name = "user_pw", nullable = false)
    private String userPw;

    @Column(name = "user_role", nullable = false)
    private String userRole;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "user_gender", nullable = false)
    private String userGender;

    @Column(name = "user_birth", nullable = false)
    private LocalDate userBirth;

    @Column(name = "user_phone", nullable = false)
    private String userPhone;

    @Column(name = "user_postcode")
    private String userPostcode;

    @Column(name = "user_address")
    private String userAddress;

    @Column(name = "user_address_detail")
    private String userAddressDetail;

    @Column(name = "user_edu_level")
    private String userEduLevel;

    @Column(name = "user_marketing_agree", nullable = false)
    private Boolean userMarketingAgree;

    @Column(name = "user_privacy_agree", nullable = false)
    private Boolean userPrivacyAgree;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_status")
    private UserStatus userStatus;  // Enum으로 변경

    @CreatedDate
    @Column(name = "user_created_at", updatable = false)
    private LocalDateTime userCreatedAt;

    @LastModifiedDate
    @Column(name = "user_updated_at")
    private LocalDateTime userUpdatedAt;

    @Column(name = "user_sns")
    private String userSns;

    @Column(name = "user_thumbnail")
    private String userThumbnail;

    @Column(name = "user_last_login")
    private LocalDateTime userLastLogin;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_" + this.userRole));
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.userPw;
    }

    @Override
    public String getUsername() {
        return this.userEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.userStatus == UserStatus.ACTIVE;  // 활성 상태일 때만 enabled
    }
}
