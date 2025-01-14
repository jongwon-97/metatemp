package com.metalearnin.KDT.KDTdto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KDTCourseDto {

    private Long KDTCourseId;
    private String KDTCourseTitle;
    private boolean KDTCourseStatus; // Boolean으로 수정
//    private String KDTCourseType;
    private LocalDateTime KDTCourseCreatedAt; // 생성 날짜
    private LocalDateTime KDTCourseUpdatedAt; // 마지막 수정 날짜
}

