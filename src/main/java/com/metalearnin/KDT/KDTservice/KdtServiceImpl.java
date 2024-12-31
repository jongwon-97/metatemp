package com.metalearnin.KDT.KDTservice;

import com.metalearnin.KDT.KDTdto.KDTCourseDto;
import com.metalearnin.KDT.KDTdto.KDTSessionDto;
import com.metalearnin.KDT.KDTentity.KDTCourseEntity;
import com.metalearnin.KDT.KDTentity.KDTSessionEntity;
import com.metalearnin.KDT.KDTrepository.KDTCourseRepository;
import com.metalearnin.KDT.KDTrepository.KDTSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KdtServiceImpl implements KdtService {

    private final KDTCourseRepository kdtCourseRepository;
    private final KDTSessionRepository kdtSessionRepository;


    //국비과정 등록하는 메서드임
    @Override
    public int kdtcoursesave(KDTCourseDto kdtCourseDto) {
        try {
            // 중복 확인 사용하는거임
            boolean exists = kdtCourseRepository.existsByKDTCourseTitle(kdtCourseDto.getKDTCourseTitle());
            if (exists) {
                return 2;
            }
            KDTCourseEntity kdtCourseEntity = KDTCourseEntity.builder()
                    .KDTCourseTitle(kdtCourseDto.getKDTCourseTitle())
                    .KDTCourseStatus(kdtCourseDto.isKDTCourseStatus())
                    .build();
            kdtCourseRepository.save(kdtCourseEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int kdtsessionsave(KDTSessionDto kdtSessionDto) {
        try {
            boolean exists = kdtSessionRepository.existsByKDTSessionNum(kdtSessionDto.getKDTSessionNum());

            if (exists) {
                return 2;
            }
            KDTSessionEntity kdtSessionEntity = KDTSessionEntity.builder()
                    .KDTSessionId(kdtSessionDto.getKDTSessionId())
                    .kdtCourseEntity(KDTCourseEntity.builder().KDTCourseId(kdtSessionDto.getKDTCourseId()).build()) // 관계 설정
                    .KDTSessionNum(kdtSessionDto.getKDTSessionNum())
                    .KDTSessionTitle(kdtSessionDto.getKDTSessionTitle())
                    .KDTSessionDescript(kdtSessionDto.getKDTSessionDescript())
                    .KDTSessionStartDate(kdtSessionDto.getKDTSessionStartDate())
                    .KDTSessionEndDate(kdtSessionDto.getKDTSessionEndDate())
                    .KDTSessionCategory(kdtSessionDto.getKDTSessionCategory())
                    .KDTSessionMaxCapacity(kdtSessionDto.getKDTSessionMaxCapacity())
                    .KDTSessionThumbnail(kdtSessionDto.getKDTSessionThumbnail())
                    .KDTSessionStartTime(kdtSessionDto.getKDTSessionStartTime())
                    .KDTSessionEndTime(kdtSessionDto.getKDTSessionEndTime())
                    .KDTSessionPostcode(kdtSessionDto.getKDTSessionPostcode())
                    .KDTSessionAddress(kdtSessionDto.getKDTSessionAddress())
                    .KDTSessionAddressDetail(kdtSessionDto.getKDTSessionAddressDetail())
                    .KDTSessionOnline(kdtSessionDto.getKDTSessionOnline())
                    .build();

            kdtSessionRepository.save(kdtSessionEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


    //KDT 교육과정명 전체찾는 메서드임 =  courseall  중복해서 사용하면 댐
    @Override
    public List<KDTCourseDto> courseall() {
        List<KDTCourseEntity> courses = kdtCourseRepository.findAll();
        List<KDTCourseDto> courseDtos = courses.stream()
                .map(course -> new KDTCourseDto(
                        course.getKDTCourseId(),
                        course.getKDTCourseTitle(),
                        course.getKDTCourseStatus(),
                        course.getKDTCourseCreatedAt(),
                        course.getKDTCourseUpdatedAt()
                ))
                .collect(Collectors.toList());
        return courseDtos;
    }

    @Override
    public int getSessionNumByCourseId(Long courseId) {
        try {
            // courseId에 해당하는 마지막 세션을 찾기 (세션 번호가 큰 순서대로)
            Optional<KDTSessionEntity> lastSession = kdtSessionRepository.findTopByKdtCourseEntity_KDTCourseIdOrderByKDTSessionNumDesc(courseId);

            // 세션 번호를 찾을 수 없으면 0을 반환
            return lastSession.map(KDTSessionEntity::getKDTSessionNum).orElse(0); // Optional 처리
        } catch (Exception e) {
            // 예외 발생 시 로깅 (간단한 로깅 예시)
            e.printStackTrace();
            return 0;  // 예외가 발생한 경우 기본값 0 반환
        }
    }


}
