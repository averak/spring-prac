package spring.tutorial.service;

import java.time.LocalDate;
import java.util.List;

import spring.tutorial.model.ReservableRoomModel;
import spring.tutorial.repository.ReservableRoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoomService {
	@Autowired
	ReservableRoomRepository reservableRoomRepository;

	public List<ReservableRoomModel> findReservableRooms(LocalDate date) {
		return this.reservableRoomRepository.findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(date);
	}
}
