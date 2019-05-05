package org.jinseon.post;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PostMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("post-context.xml");
		PostService postService = context.getBean("postService",PostService.class);
		
		postService.post();
		postService.list();
		postService.like();
		context.close();
	}

}
