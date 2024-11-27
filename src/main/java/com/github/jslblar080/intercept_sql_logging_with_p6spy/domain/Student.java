package com.github.jslblar080.intercept_sql_logging_with_p6spy.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @NonNull
    @Getter
    @Setter
    private String firstName;

    @NonNull
    @Getter
    @Setter
    private String lastName;
}
