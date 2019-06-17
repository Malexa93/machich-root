package machich.matching.domain.gesuch;

import org.springframework.data.jpa.repository.JpaRepository;

import machich.matching.domain.Id;;

public interface GesuchRepository extends JpaRepository<Gesuch, Id>{
	//Gesuch gesuchFuer(final Id id);

	Gesuch save(final Gesuch proposal);
}
