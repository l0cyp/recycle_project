package com.trashformer.springboot_recycle.dto;

import lombok.Data;

@Data
public class ContactDTO {
    private String replyTo;
    private String name;
    private String subject;
    private String text;
}
