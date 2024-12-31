package com.metalearnin.KDT.KDTservice;

import com.metalearnin.KDT.KDTdto.KDTCourseDto;
import com.metalearnin.KDT.KDTdto.KDTSessionDto;

import java.util.List;

public interface KdtService {

    int kdtcoursesave(KDTCourseDto kdtCourseDto);

    int kdtsessionsave(KDTSessionDto kdtSessionDto);


    List<KDTCourseDto> courseall();

    int getSessionNumByCourseId(Long courseId);


}
