package spring.tutorial.service;

import java.time.LocalDate;
import java.util.List;

import spring.tutorial.model.ReservableRoomModel;
import spring.tutorial.repository.ReservableRoomRepository;
import spring.tutorial.api.response.RoomsResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RoomService {
	private final ReservableRoomRepository reservableRoomRepository;

	public RoomsResponse findReservableRooms(LocalDate date) {
		final var reservableRooms = this.reservableRoomRepository
				.findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(date);
		return RoomsResponse.builder() //
				.reservableRooms(reservableRooms) //
				.build();
	}
}
