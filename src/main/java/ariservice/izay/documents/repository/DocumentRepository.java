package ariservice.izay.documents.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import ariservice.izay.documents.entity.Document;

@Transactional
public interface DocumentRepository extends JpaRepository<Document, Long>{

	
	List<Document> findBySlug(String slug);
	
}
