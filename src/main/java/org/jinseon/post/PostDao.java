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
	static final String ADD_POST = "insert post(userid, name, content) values(?,?,?)";
	
	//목록보기
	static final String LIST_POSTS = "select postId,userId,name,context,sweet,cdate from post order by postId desc";
	
	//좋아요
	static final String LIKE_POST = "update post set sweet = sweet+1 when postId=?";
	
	//글 조회
	static final String GET_POST = "select postId,userId,name,content,sweet,cdate from where postId=?";
	
	
	
	//@Autowired
	JdbcTemplate jdbcTemplate;
	
	RowMapper<Post> postRowMapper = new BeanPropertyRowMapper<>(Post.class);
	
	//@Override
	public int addPost(Post post) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update
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
