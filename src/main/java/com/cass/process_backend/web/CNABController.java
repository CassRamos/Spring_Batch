package com.cass.process_backend.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("cnab")
public class CNABController {
    @PostMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        return "Process initialized!";
    }
}
