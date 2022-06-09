package ru.kpfu.itis.form;

import lombok.Builder;
import lombok.Data;
import ru.kpfu.itis.models.Resume;

@Data
@Builder
public class ContactForm {

    private String title;
    private String contact;
    private Resume resume;
}
