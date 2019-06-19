package machich.profilmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import machich.profilmanagement.domain.Macher;

public interface MacherRepository extends JpaRepository<Macher, Long>{
	

}
