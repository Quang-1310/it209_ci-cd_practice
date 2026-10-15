package ra.edu.ptit_cntt2_it211_practice.service;

import org.springframework.data.domain.Page;
import ra.edu.ptit_cntt2_it211_practice.model.dto.request.MedicationDTO;
import ra.edu.ptit_cntt2_it211_practice.model.entity.Medication;

public interface MedicationService {
    Page<Medication> getMedications(int page, int size);
    Medication insertMedication(MedicationDTO medicationDTO);
    Medication putMedication(MedicationDTO medicationDTO, Long medicationId);
    Medication patchMedication(MedicationDTO medicationDTO, Long medicationId);
    void deleteMedication(Long medicationId);
}
