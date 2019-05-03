package org.hyeondo.vote;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VoteMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"vote-context.xml");
		VoteService voteService = context.getBean("voteService",
				VoteService.class);
		context.close();

		voteService.addVote();
		voteService.listVotes();
		context.close();
	}

}