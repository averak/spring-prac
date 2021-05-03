package spring.tutorial.model;

import java.io.Serializable;
import java.time.LocalTime;
import javax.persistence.*;

@Entity
@Table(name = "reservation")
public class ReservationModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reservationId;

	private LocalTime startTime;
	private LocalTime endTime;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "reserved_date"), @JoinColumn(name = "room_id") })
	private ReservableRoomModel reservableRoom;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserModel user;

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public ReservableRoomModel getReservableRoom() {
		return reservableRoom;
	}

	public void setReservableRoom(ReservableRoomModel reservableRoom) {
		this.reservableRoom = reservableRoom;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}
}
