package com.example.pollingapp.Repository;

import com.example.pollingapp.Model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VoteRepository extends JpaRepository<Vote,Long> {

    @Query("select v from Vote v where v.id = :id")
    Vote findVById(Long id);
}
