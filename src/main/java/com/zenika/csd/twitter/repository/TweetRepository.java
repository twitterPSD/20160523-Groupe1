package com.zenika.csd.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zenika.csd.twitter.model.Author;
import com.zenika.csd.twitter.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Integer> {


}
