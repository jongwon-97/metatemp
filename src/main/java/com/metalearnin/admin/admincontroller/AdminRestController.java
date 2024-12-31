package com.metalearnin.admin.admincontroller;

import com.metalearnin.KDT.KDTservice.KdtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/KDT/session")
public class AdminRestController {

    private final KdtService kdtService;


    @GetMapping("/getSessionNum")
    public ResponseEntity<Map<String, Integer>> getSessionNum(@RequestParam Long courseId) {

        int sessionNum = kdtService.getSessionNumByCourseId(courseId);
        int nextSessionNumber =  sessionNum +1;
        Map<String, Integer> response = new HashMap<>();
        response.put("sessionNum", nextSessionNumber);
        return ResponseEntity.ok(response);
    }

}
