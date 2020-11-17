package com.example.pollingapp.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizChoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean correct;

    @Lob
    private String answerText;

    @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "quiz_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Quiz quiz;
}
