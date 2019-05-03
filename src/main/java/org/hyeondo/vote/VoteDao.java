package org.hyeondo.vote;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class VoteDao{
	/**
	 * 목록 가져오는 sql
	 */
	static final String LIST_VOTES = "SELECT pollId,userId,name, choice FROM vote WHERE pollId=?";

	/**
	 * 글 등록하는 sql
	 */
	static final String ADD_VOTE = "INSERT vote(pollId, userId, name, choice) VALUES(?,?,?,?)";

	static final String GET_AVERAGE_CHOICE = "SELECT avg(choice) FROM vote WHERE pollId=?";
	
	RowMapper<Vote> voteRowMapper = new BeanPropertyRowMapper<>(Vote.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * 글 목록
	 */
	public List<Vote> listVotes(String pollId) {
		return jdbcTemplate.query(LIST_VOTES, voteRowMapper, pollId);
	}

	/**
	 * 글 등록
	 */
	public int addVote(Vote vote) {
		return jdbcTemplate.update(ADD_VOTE, vote.getPollId(),
				vote.getUserId(), vote.getName(), vote.getChoice());
	}

	public double getAverage(String pollId) {
		return jdbcTemplate.queryForObject(GET_AVERAGE_CHOICE, Double.class, pollId);
	}

	
}
