package ariservice.izay.blog.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import ariservice.izay.blog.entity.Blog;

@Transactional
public interface BlogRepository extends JpaRepository<Blog, Long>{
	
	List<Blog> findBySlug(String slug);
	
}
