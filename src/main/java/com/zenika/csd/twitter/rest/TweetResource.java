package com.zenika.csd.twitter.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zenika.csd.twitter.model.Author;
import com.zenika.csd.twitter.model.Tweet;
import com.zenika.csd.twitter.repository.TweetRepository;
import com.zenika.csd.twitter.service.AuthorService;

@RestController
@RequestMapping("/tweet")
public class TweetResource {

	@Autowired
	private TweetRepository tweetService;

	@Autowired
	private AuthorService authorService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Tweet> findTweets() {
		return tweetService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Tweet addTweet(@RequestBody String message) {
		Tweet tweet = new Tweet();
		tweet.setId(null);
		tweet.setMessage(message);
		// TODO comment on passe l'author en paramètre ? + message erreur si author inconnu
		Author author = authorService.get(1);
		tweet.setAuthor(author);
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
