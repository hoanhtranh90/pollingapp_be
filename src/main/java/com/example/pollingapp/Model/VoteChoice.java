package com.example.pollingapp.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteChoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long totalVote;

    @Lob
    private String name;

    @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "vote_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Vote vote;

}
