package ru.kpfu.itis.dto;

import lombok.Data;

@Data
public class ExperienceDto {

    private Long resumeId;
    private String title;
    private String place;
    private String time;
    private String description;
}
