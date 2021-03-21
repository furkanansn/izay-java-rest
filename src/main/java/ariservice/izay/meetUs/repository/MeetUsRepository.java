package ariservice.izay.meetUs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ariservice.izay.home.entity.Home;
import ariservice.izay.meetUs.entity.MeetUs;

public interface MeetUsRepository extends JpaRepository<MeetUs, Long>{
	 

}
