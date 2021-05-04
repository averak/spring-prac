package spring.tutorial.repository;

import java.util.List;

import spring.tutorial.model.ReservableRoomIdModel;
import spring.tutorial.model.ReservationModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationModel, Integer> {
	List<ReservationModel> findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(
			ReservableRoomIdModel reservableRoomId);
}
