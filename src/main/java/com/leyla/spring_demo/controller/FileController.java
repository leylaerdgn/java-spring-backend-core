package com.leyla.spring_demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/files")
public class FileController {

@PostMapping("/upload")
public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException{
    File klasor=new File("uploads");
    if(!klasor.exists()){
        klasor.mkdirs();
    }
    String name=file.getOriginalFilename();
    File hedefDosya = new File(klasor, name);
    file.transferTo(hedefDosya.toPath());
    double size=file.getSize();
    String body="Dosyanın adı: "+name+"Dosyanın Boyutu: "+size;
    return new ResponseEntity<String>(body, HttpStatus.OK);
}
}
