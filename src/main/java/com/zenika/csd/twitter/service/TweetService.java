package com.zenika.csd.twitter.service;

import java.util.List;

import com.zenika.csd.twitter.model.Tweet;

public interface TweetService {

	List<Tweet> findAll();

	Tweet save(Tweet tweet);

	void delete(Integer id);

}