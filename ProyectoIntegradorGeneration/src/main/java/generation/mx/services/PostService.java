package generation.mx.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import generation.mx.models.PostModel;
import generation.mx.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	PostRepository postRepository;
	
	public ArrayList<PostModel> getPosts() {
		return (ArrayList<PostModel>) postRepository.findAll();
	}
	
	public PostModel savePost(PostModel post) {
		return postRepository.save(post);
	}
	
	public Optional<PostModel> getPostById(long id) {
		return postRepository.findById(id);
	}
	
	public ArrayList<PostModel> getPostsByTitle(String title) {
		return postRepository.findByTitleContaining(title);
	}
	
	public ArrayList<PostModel> getByTitleContainingOrderByIdDesc(String title) {
		return postRepository.findByTitleContainingOrderByIdDesc(title);
	}
}
