package spring.tutorial.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

@Embeddable
public class ReservableRoomIdModel implements Serializable {
	private Integer roomId;

	private LocalDate reservedDate;

	public ReservableRoomIdModel(Integer roomId, LocalDate reservedDate) {
		this.roomId = roomId;
		this.reservedDate = reservedDate;
	}

	public ReservableRoomIdModel() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.reservedDate == null) ? 0 : this.reservedDate.hashCode());
		result = prime * result + ((this.roomId == null) ? 0 : this.roomId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservableRoomIdModel other = (ReservableRoomIdModel) obj;
		if (this.reservedDate == null) {
			if (other.reservedDate != null)
				return false;
		} else if (!this.reservedDate.equals(other.reservedDate))
			return false;
		if (roomId == null) {
			if (other.roomId != null)
				return false;
		} else if (!roomId.equals(other.roomId))
			return false;
		return true;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public LocalDate getReservedDate() {
		return reservedDate;
	}

	public void setReservedDate(LocalDate reservedDate) {
		this.reservedDate = reservedDate;
	}
}
