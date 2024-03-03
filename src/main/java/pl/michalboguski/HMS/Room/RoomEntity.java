package pl.michalboguski.HMS.Room;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "rooms")
public class RoomEntity {
    @Id
    private Long id;
    private Long rommNumber;
    private Double width;
    private Double height;
    private Integer floor;

    private Boolean isBooked;
    private Boolean isOcupate;
    private Boolean isServis;
}
