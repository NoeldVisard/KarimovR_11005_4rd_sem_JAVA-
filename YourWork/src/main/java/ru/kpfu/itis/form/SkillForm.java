package ru.kpfu.itis.form;

import lombok.Builder;
import lombok.Data;
import ru.kpfu.itis.models.Resume;

@Data
@Builder
public class SkillForm {

    private String title;
    private Resume resume;

}
