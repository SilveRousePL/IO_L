package entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "room_number")
    private Integer roomNumber;

    @Column(name = "amount_of_persons")
    private Integer amountOfPersons;

    private BigDecimal cost;

    @OneToMany(mappedBy = "client")
    private List<Reservation> reservations;

    private Integer status;

    private Boolean lock;
}
