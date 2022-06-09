package ru.kpfu.itis.form;

import lombok.Builder;
import lombok.Data;
import ru.kpfu.itis.models.Resume;

@Data
@Builder
public class EducationForm {

    private String title;
    private String workTimeInterval;
    private String place;
    private Resume resume;

}
