package spring.tutorial.repository;

import spring.tutorial.model.MeetingRoomModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRoomRepository extends JpaRepository<MeetingRoomModel, Integer> {
}
