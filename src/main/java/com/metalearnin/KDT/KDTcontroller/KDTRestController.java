package com.metalearnin.KDT.KDTcontroller;

import com.metalearnin.KDT.KDTservice.KdtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class KDTRestController {
    private final KdtService kdtService;



}



