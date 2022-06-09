package ru.kpfu.itis.form;

import lombok.Builder;
import lombok.Data;
import ru.kpfu.itis.models.Resume;

@Data
@Builder
public class ProjectForm {

    private String title;
    private String description;
    private Resume resume;

}
