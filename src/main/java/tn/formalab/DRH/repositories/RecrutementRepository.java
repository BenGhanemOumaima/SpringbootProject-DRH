package tn.formalab.DRH.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.formalab.DRH.models.Recrutement;

public interface RecrutementRepository extends JpaRepository<Recrutement, Integer> {
}
