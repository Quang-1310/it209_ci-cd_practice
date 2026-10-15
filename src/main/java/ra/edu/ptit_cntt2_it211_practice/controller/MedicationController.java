package ra.edu.ptit_cntt2_it211_practice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.edu.ptit_cntt2_it211_practice.model.dto.request.MedicationDTO;
import ra.edu.ptit_cntt2_it211_practice.model.dto.response.ApiDataResponse;
import ra.edu.ptit_cntt2_it211_practice.model.entity.Medication;
import ra.edu.ptit_cntt2_it211_practice.service.MedicationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/medications")
public class MedicationController {
    private final MedicationService medicationService;

    @GetMapping
    public ResponseEntity<ApiDataResponse<Page<Medication>>> getMedications(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "2") int size
    ){
        Page<Medication> pageMedication = medicationService.getMedications(page - 1, size);
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Lấy danh sách sản phẩm thành công",
                pageMedication,
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiDataResponse<Medication>> insertMedication(@Valid @RequestBody MedicationDTO medicationDTO){
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Thêm mới thuốc thành công",
                medicationService.insertMedication(medicationDTO),
                HttpStatus.CREATED
        ), HttpStatus.CREATED);
    }

    @PutMapping("/{medicationId}")
    public ResponseEntity<ApiDataResponse<Medication>> putMedication(@PathVariable Long medicationId, @Valid @RequestBody MedicationDTO medicationDTO){
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Cập nhật thông tin thuốc thành công",
                medicationService.putMedication(medicationDTO, medicationId),
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @PatchMapping("/{medicationId}")
    public ResponseEntity<ApiDataResponse<Medication>> pathchMedication(@PathVariable Long medicationId, @RequestBody MedicationDTO medicationDTO){
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Cập nhật 1 phần thông tin thuốc thành công",
                medicationService.patchMedication(medicationDTO, medicationId),
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @DeleteMapping("/{medicationId}")
    public ResponseEntity<ApiDataResponse<Medication>> deleteMedication(@PathVariable Long medicationId){
        medicationService.deleteMedication(medicationId);
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Xoá thuốc thành công",
                null,
                HttpStatus.OK // Xoá mềm nên trạng thái trả về là OK
        ), HttpStatus.OK);
    }

}
