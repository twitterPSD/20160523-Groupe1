package com.zenika.csd.twitter.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zenika.csd.twitter.model.Tweet;
import com.zenika.csd.twitter.repository.TweetRepository;

@RestController
@RequestMapping("/tweet")
public class TweetResource {

	@Autowired
	private TweetRepository tweetService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Tweet> findAuthors() {
		return tweetService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Tweet addTweet(@RequestBody Tweet tweet) {
		tweet.setId(null);
		return tweetService.save(tweet);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Tweet updateTweet(@RequestBody Tweet updatedtweet,
			@PathVariable Integer id) {
		updatedtweet.setId(id);
		return tweetService.save(updatedtweet);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteTweet(@PathVariable Integer id) {
		tweetService.delete(id);
	}

}
