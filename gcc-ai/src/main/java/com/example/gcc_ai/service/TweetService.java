package com.example.gcc_ai.service;

import com.example.gcc_ai.model.Tweet;
import com.example.gcc_ai.Repository.TweetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TweetService {

    private final TweetRepository tweetRepository;

    public TweetService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    public List<Tweet> getAllTweets() {
        return tweetRepository.findAll();
    }
}
