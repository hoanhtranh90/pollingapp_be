package com.example.pollingapp.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    private String questionText;
    private String answerQuiz;



    @OneToMany( mappedBy = "quiz",cascade = CascadeType.ALL)
    private Set<QuizChoice> quizChoices = new HashSet<>();
    // áp dụng quy tắc S trong solid có thẻ tạo 1 class DTO
    // => không cần dùng đến jsonignore


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String title) {
        this.questionText = title;
    }

    public Set<QuizChoice> getQuizChoices() {
        return quizChoices;
    }
    public String getAnswerQuiz() {
        return answerQuiz;
    }

    public void setAnswerQuiz(String answerQuiz) {
        this.answerQuiz = answerQuiz;
    }
    //de tranh field vote trong voteChoice null
    public void setQuizChoices(Set<QuizChoice> quizChoices) {
        this.quizChoices = quizChoices;
        for(QuizChoice q:quizChoices)
        {
            q.setQuiz(this);
        }
    }
}
