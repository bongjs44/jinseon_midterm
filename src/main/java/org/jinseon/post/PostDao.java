package org.jinseon.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PostDao{

	//글쓰기
	static final String ADD_POST = "INSERT post(userId,name,content) VALUES(?,?,?)";
	
	//목록보기
	static final String LIST_POSTS = "SELECT postId,userId,name,content,sweet,cdate FROM post ORDER BY postId desc LIMIT ?,?";
	
	//좋아요
	static final String LIKE_POST = "UPDATE post SET sweet = sweet+1 WHERE postId=?";
	
	//글 조회
	static final String GET_POST = "SELECT postId, userId, name, content, sweet, cdate FROM post WHERE postId=?";
	
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	RowMapper<Post> postRowMapper = new BeanPropertyRowMapper<>(Post.class);
	
	//@Override
	public int addPost(Post post) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(ADD_POST, post.getUserId(), post.getName(), post.getContent());
	}

	//@Override
	public List<Post> listPosts(int offset, int count) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(LIST_POSTS, postRowMapper, offset,count);
	}

	//@Override
	public int likePost(String postId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(LIKE_POST,postId);
	}
	
	//@Override
	public Post getPost(String postId) {
		return jdbcTemplate.queryForObject(GET_POST, postRowMapper, postId); 
	}

}
