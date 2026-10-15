package ra.edu.ptit_cntt2_it211_practice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ra.edu.ptit_cntt2_it211_practice.exception.ResourceNotFoundException;
import ra.edu.ptit_cntt2_it211_practice.model.dto.request.MedicationDTO;
import ra.edu.ptit_cntt2_it211_practice.model.entity.Medication;
import ra.edu.ptit_cntt2_it211_practice.repository.MedicationRepository;
import ra.edu.ptit_cntt2_it211_practice.service.MedicationService;

@Service
@RequiredArgsConstructor
public class MedicationServiceImpl implements MedicationService {

    private final MedicationRepository medicationRepository;

    @Override
    public Page<Medication> getMedications(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return medicationRepository.findAll(pageable);
    }

    @Override
    public Medication insertMedication(MedicationDTO medicationDTO) {
        Medication medication = new Medication();
        medication.setName(medicationDTO.getName());
        medication.setManufacturer(medicationDTO.getManufacturer());
        medication.setPrice(medicationDTO.getPrice());
        medication.setStatus(medicationDTO.getStatus());
        return medicationRepository.save(medication);
    }

    @Override
    public Medication putMedication(MedicationDTO medicationDTO, Long medicationId) {
        Medication foundMedication = medicationRepository.findById(medicationId).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy thuốc có ID: " + medicationId));
        foundMedication.setName(medicationDTO.getName());
        foundMedication.setManufacturer(medicationDTO.getManufacturer());
        foundMedication.setPrice(medicationDTO.getPrice());
        foundMedication.setStatus(medicationDTO.getStatus());
        medicationRepository.save(foundMedication);
        return null;
    }

    @Override
    public Medication patchMedication(MedicationDTO medicationDTO, Long medicationId) {
        Medication foundMedication = medicationRepository.findById(medicationId).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy thuốc có ID: " + medicationId));
        if (medicationDTO.getName() != null && !medicationDTO.getName().isBlank()) {
            foundMedication.setName(medicationDTO.getName());
        }
        if (medicationDTO.getManufacturer() != null && !medicationDTO.getManufacturer().isBlank()) {
            foundMedication.setManufacturer(medicationDTO.getManufacturer());
        }
        if (medicationDTO.getPrice() != null) {
            if (medicationDTO.getPrice() <= 0) throw new IllegalArgumentException("Giá bán phải lớn hơn 0");
            foundMedication.setPrice(medicationDTO.getPrice());
        }
        if (medicationDTO.getStatus() != null) {
            foundMedication.setStatus(medicationDTO.getStatus());
        }
        medicationRepository.save(foundMedication);
        return null;
    }

    @Override
    public void deleteMedication(Long medicationId) {
        Medication foundMedication = medicationRepository.findById(medicationId).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy thuốc có ID: " + medicationId));
        foundMedication.setIsDelete(false);
        medicationRepository.save(foundMedication);
    }
}
