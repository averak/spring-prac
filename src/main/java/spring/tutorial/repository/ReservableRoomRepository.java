package spring.tutorial.repository;

import java.time.LocalDate;
import java.util.List;

import spring.tutorial.model.ReservableRoomModel;
import spring.tutorial.model.ReservableRoomIdModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservableRoomRepository extends JpaRepository<ReservableRoomModel, ReservableRoomIdModel> {
	List<ReservableRoomModel> findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(LocalDate reservedDate);
}
