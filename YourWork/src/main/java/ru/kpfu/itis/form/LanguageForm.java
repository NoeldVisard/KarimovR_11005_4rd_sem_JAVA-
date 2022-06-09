package ru.kpfu.itis.form;

import lombok.Builder;
import lombok.Data;
import ru.kpfu.itis.models.Resume;

@Data
@Builder
public class LanguageForm {

    private String language;
    private String level;
    private Resume resume;

}
