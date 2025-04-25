package com.example.gcc_ai.Repository;

import com.example.gcc_ai.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.gcc_ai.dto.ComplaintDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    @Query("SELECT new com.example.gcc_ai.dto.ComplaintDTO(c.ticketId, c.translatedText, c.isValidComplaint, c.sentiment, c.deptType, c.emailSent, c.timestamp, c.postUrl, c.status) FROM Tweet c WHERE c.isValidComplaint = true")
    List<ComplaintDTO> fetchAllComplaints();

    @Query("SELECT new com.example.gcc_ai.dto.ComplaintDTO(c.ticketId, c.translatedText, c.isValidComplaint, c.sentiment, c.deptType, c.emailSent, c.timestamp, c.postUrl, c.status) FROM Tweet c WHERE c.deptType = :deptType AND c.isValidComplaint = true")
    List<ComplaintDTO> fetchComplaintsByDeptType(String deptType);


}

