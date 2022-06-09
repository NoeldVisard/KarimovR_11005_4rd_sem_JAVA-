package ru.kpfu.itis.form;

import lombok.Builder;
import lombok.Data;
import ru.kpfu.itis.models.User;

@Data
@Builder
public class ResumeForm {

    private String title;
    private User user;
}
