package spring.tutorial.api.controller;

import java.time.LocalDate;
import java.util.List;

import spring.tutorial.model.ReservableRoomModel;
import spring.tutorial.service.RoomService;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/rooms", produces = MediaType.APPLICATION_JSON_VALUE)
public class RoomsRestController {
	private final RoomService roomService;

	@RequestMapping(value = "{date}", method = RequestMethod.GET)
	String listRooms(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate date, Model model) {
		List<ReservableRoomModel> rooms = roomService.findReservableRooms(date);
		model.addAttribute("rooms", rooms);
		return "listRooms";
	}

	@RequestMapping(method = RequestMethod.GET)
	String listRooms(Model model) {
		LocalDate today = LocalDate.now();
		model.addAttribute("date", today);
		return listRooms(today, model);
	}

	@RequestMapping(method = RequestMethod.POST)
	public List<ReservableRoomModel> GetRooms() {
		LocalDate today = LocalDate.now();
		List<ReservableRoomModel> rooms = roomService.findReservableRooms(today);
		return rooms;
	}
}
