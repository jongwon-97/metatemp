package com.metalearnin.KDT.KDTentity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "KDT_session")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@EntityListeners(AuditingEntityListener.class)
public class KDTSessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KDT_session_id")
    private Long KDTSessionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KDT_course_id", referencedColumnName = "KDT_course_id", nullable = false)
    private KDTCourseEntity kdtCourseEntity;

    @Column(name = "KDT_session_num", nullable = false)
    private int KDTSessionNum;

    @Column(name = "KDT_session_title", nullable = false)
    private String KDTSessionTitle;

    @Column(name = "KDT_session_descript")
    private String KDTSessionDescript;

    @Column(name = "KDT_session_start_date")
    private LocalDate KDTSessionStartDate;

    @Column(name = "KDT_session_end_date")
    private LocalDate KDTSessionEndDate;

    @Column(name = "KDT_session_category")
    private String KDTSessionCategory;

    @Column(name = "KDT_session_max_capacity")
    private int KDTSessionMaxCapacity;

    @Column(name = "KDT_session_thumbnail")
    private String KDTSessionThumbnail;

    @Column(name = "KDT_session_start_time")
    private LocalDateTime KDTSessionStartTime;

    @Column(name = "KDT_session_end_time")
    private LocalDateTime KDTSessionEndTime;

    @Column(name = "KDT_session_postcode")
    private String KDTSessionPostcode;

    @Column(name = "KDT_session_address")
    private String KDTSessionAddress;

    @Column(name = "KDT_session_address_detail")
    private String KDTSessionAddressDetail;

    @Column(name = "KDT_session_online")
    private Boolean KDTSessionOnline;
}
