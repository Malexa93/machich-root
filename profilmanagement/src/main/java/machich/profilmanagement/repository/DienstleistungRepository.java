package machich.profilmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import machich.profilmanagement.domain.Dienstleistung;

public interface DienstleistungRepository extends JpaRepository<Dienstleistung, Long> {

}
