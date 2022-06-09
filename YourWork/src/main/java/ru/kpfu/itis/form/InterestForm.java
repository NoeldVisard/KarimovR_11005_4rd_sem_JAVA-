package ru.kpfu.itis.form;

import lombok.Builder;
import lombok.Data;
import ru.kpfu.itis.models.Resume;
import ru.kpfu.itis.models.User;

@Data
@Builder
public class InterestForm {

    private String title;
    private Resume resume;

}
