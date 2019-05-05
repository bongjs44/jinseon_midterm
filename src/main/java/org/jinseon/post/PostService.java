package org.jinseon.post;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	
	@Autowired
	PostDao postDao;
	
	Logger logger = LogManager.getLogger();
	
	//글쓰기
	public void post() {

		Post post = new Post();
		post.setUserId("11");
		post.setName("봉진선");
		post.setContent("즐거운 어린이날.");
		postDao.addPost(post);
		logger.info("글을 등록했습니다");
	}
	
	//목록 최신 50개
	public void list() {
		List<Post> postList = postDao.listPosts(0, 50);
		logger.info(postList);
	}
	
	//좋아요
	public void like() {
		String postId = "122";
		postDao.likePost(postId);
		Post post = postDao.getPost(postId);
		logger.info(post);
	}

}
