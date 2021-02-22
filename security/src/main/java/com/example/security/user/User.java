package com.example.security.user;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;
    private String email;
    private String role;

    @CreationTimestamp
    private LocalDateTime createdDate;
}
