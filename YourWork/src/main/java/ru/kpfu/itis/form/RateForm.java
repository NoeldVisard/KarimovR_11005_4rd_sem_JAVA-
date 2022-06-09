package ru.kpfu.itis.form;

import lombok.Builder;
import lombok.Data;
import ru.kpfu.itis.models.Resume;
import ru.kpfu.itis.models.User;

@Data
@Builder
public class RateForm {

    private User user;
    private Resume resume;
    private Integer rate;
}
