package pl.michalboguski.HMS.Room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    private Long id;
    private Long rommNumber;
    private Double width;
    private Double height;
    private Integer floor;

    private Boolean isBooked;
    private Boolean isOcupate;
    private Boolean isServis;
}

