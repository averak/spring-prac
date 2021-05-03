package spring.tutorial.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "reservable_room")
public class ReservableRoomModel implements Serializable {
	@EmbeddedId
	private ReservableRoomIdModel reservableRoomId;

	@ManyToOne
	@JoinColumn(name = "room_id", insertable = false, updatable = false)
	@MapsId("roomId")
	private MeetingRoomModel meetingRoom;

	public ReservableRoomModel(ReservableRoomIdModel reservableRoomId) {
		this.reservableRoomId = reservableRoomId;
	}

	public ReservableRoomModel() {
	}

	public ReservableRoomIdModel getReservableRoomId() {
		return this.reservableRoomId;
	}

	public void setReservableRoomId(ReservableRoomIdModel reservableRoomId) {
		this.reservableRoomId = reservableRoomId;
	}

	public MeetingRoomModel getMeetingRoom() {
		return this.meetingRoom;
	}

	public void setMeetingRoom(MeetingRoomModel meetingRoom) {
		this.meetingRoom = meetingRoom;
	}
}
