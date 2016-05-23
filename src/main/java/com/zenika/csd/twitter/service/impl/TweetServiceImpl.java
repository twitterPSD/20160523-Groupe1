package com.zenika.csd.twitter.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zenika.csd.twitter.model.Tweet;
import com.zenika.csd.twitter.repository.TweetRepository;
import com.zenika.csd.twitter.service.TweetService;

@Service
@Transactional
public class TweetServiceImpl implements TweetService {

	private final Logger log = LoggerFactory.getLogger(TweetServiceImpl.class);

	@Inject
	private TweetRepository tweetRepository;

	@Override
	public List<Tweet> findAll() {

		log.debug("Request to get all tweet");
		List<Tweet> tweets = tweetRepository.findAll();
		return tweets;
	}

	@Override
	public Tweet save(Tweet tweet) {
		log.debug("Request to save Author : {}", tweet);
		Tweet savedtweet = tweetRepository.saveAndFlush(tweet);
		return savedtweet;
	}

	@Override
	public void delete(Integer id) {
		log.debug("test Request to delete tweet id : {}", id);
		tweetRepository.delete(id);
	}

}
