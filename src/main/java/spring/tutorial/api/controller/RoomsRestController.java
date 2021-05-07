package spring.tutorial.api.controller;

import java.time.LocalDate;
import java.util.List;

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

import spring.tutorial.model.ReservableRoomModel;
import spring.tutorial.service.RoomService;
import spring.tutorial.api.response.RoomsResponse;

@Api(tags = "Meeting Room")
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/rooms", produces = MediaType.APPLICATION_JSON_VALUE)
public class RoomsRestController {
	private final RoomService roomService;

	@ApiOperation(value = "会議室一覧の取得", //
			notes = "会議室一覧を取得する" //
	)
	@ApiResponses( //
			value = { //
					@ApiResponse(code = 200, message = "取得成功", response = RoomsResponse.class), //
			} //
	)
	@RequestMapping(method = RequestMethod.POST)
	public RoomsResponse GetRooms() {
		LocalDate today = LocalDate.now();
		return roomService.findReservableRooms(today);
	}
}
