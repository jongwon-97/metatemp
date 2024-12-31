package com.metalearnin.KDT.KDTcontroller;

import com.metalearnin.KDT.KDTservice.KdtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class KDTController {
    private final KdtService kdtService;
}
