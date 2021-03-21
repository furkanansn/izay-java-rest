package ariservice.izay.documents.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ariservice.izay.documents.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long>{

}
