package machich.profilmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import machich.profilmanagement.domain.Kunde;

public interface KundeRepository extends JpaRepository<Kunde, Long>{

}
