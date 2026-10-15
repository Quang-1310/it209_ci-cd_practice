package ra.edu.ptit_cntt2_it211_practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.edu.ptit_cntt2_it211_practice.model.entity.Medication;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {
}
