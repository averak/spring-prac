package spring.tutorial.service;

import java.util.List;

import spring.tutorial.model.ReservationModel;
import spring.tutorial.model.ReservableRoomModel;
import spring.tutorial.model.ReservableRoomIdModel;
import spring.tutorial.repository.ReservationRepository;
import spring.tutorial.repository.ReservableRoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationService {
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	ReservableRoomRepository reservableRoomRepository;

	public List<ReservationModel> findReservations(ReservableRoomIdModel reservableRoomId) {
		return this.reservationRepository.findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(reservableRoomId);
	}
}
