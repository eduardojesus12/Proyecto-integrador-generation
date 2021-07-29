package generation.mx.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import generation.mx.models.PostModel;

@Repository
public interface PostRepository extends CrudRepository<PostModel, Long> {

	public abstract ArrayList<PostModel> findByTitleContaining(String title);
	
	public abstract ArrayList<PostModel> findByTitleContainingOrderByIdDesc(String title);
}
