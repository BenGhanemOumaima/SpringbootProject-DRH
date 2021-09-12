package tn.formalab.DRH.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.formalab.DRH.models.Personnel;

public interface PersonelRepository extends JpaRepository<Personnel, Integer> {
    Personnel findByEmail(String email);
}
