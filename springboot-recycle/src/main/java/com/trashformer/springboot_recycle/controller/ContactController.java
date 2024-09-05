package com.trashformer.springboot_recycle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.trashformer.springboot_recycle.dto.ContactDTO;
import com.trashformer.springboot_recycle.service.ContactService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/contact/post")
    public void sendEmail(@ModelAttribute ContactDTO contactDTO,
                            @RequestParam("images") MultipartFile[] images) {
        contactService.sendSimpleMessage(
            contactDTO.getReplyTo(),
            contactDTO.getName(),
            contactDTO.getSubject(),
            contactDTO.getText(),
            images // 이미지 파일 전달
        );
    }
}
