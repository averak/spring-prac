package spring.tutorial.api.controller;

import java.time.LocalDate;
import java.util.List;

import spring.tutorial.model.ReservableRoomModel;
import spring.tutorial.service.RoomService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Meeting Room")
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

	@ApiOperation(
			value = "会議室一覧の取得", //
			notes = "会議室一覧を取得する。" //
	)
	@ApiResponses( //
			value = { //
					@ApiResponse(code = 200, message = "取得成功"), //
			} //
	)
	@RequestMapping(method = RequestMethod.POST)
	public List<ReservableRoomModel> GetRooms() {
		LocalDate today = LocalDate.now();
		List<ReservableRoomModel> rooms = roomService.findReservableRooms(today);
		return rooms;
	}
}
