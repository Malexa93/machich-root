package machich.suche.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import machich.suche.domain.Gesuch;

public interface GesuchRepository extends JpaRepository<Gesuch, Long>{
	
	Gesuch findByGesuchsnummer(String gesuchsnummer);

}
