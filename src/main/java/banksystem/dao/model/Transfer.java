package banksystem.dao.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "transfer")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "fromCard", nullable = false)
    private String fromCard;

    @Column(name = "toCard", nullable = false)
    private String toCard;

    @Column(name = "amount", nullable = false)
    private Integer amount;
}
