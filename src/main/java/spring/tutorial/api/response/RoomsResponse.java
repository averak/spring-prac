package spring.tutorial.api.response;

import java.util.List;

import lombok.Builder;
import lombok.Value;

import spring.tutorial.model.ReservableRoomModel;;

@Value
@Builder
public class RoomsResponse {
    List<ReservableRoomModel> reservableRooms;
}
