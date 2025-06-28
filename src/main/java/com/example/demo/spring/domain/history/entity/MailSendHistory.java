package com.example.demo.spring.domain.history.entity;

import com.example.demo.spring.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mail_send_history")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MailSendHistory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "from_email")
    private String fromEmail;

    @Column(name = "to_email")
    private String toEmail;

    @Column(name = "subject")
    private String subject;

    @Column(name = "content")
    private String content;
}
