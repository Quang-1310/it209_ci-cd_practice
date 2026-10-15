package ra.edu.ptit_cntt2_it211_practice.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "medications")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String manufacturer;

    private Double price;

    private Status status;

    @Column(name = "is_delete")
    private Boolean isDelete;  // biến xoá tạm
}
