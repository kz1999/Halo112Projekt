package com.example.halo112_generic.rest;

import com.example.halo112_generic.domain.Station;
import com.example.halo112_generic.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stanice")
public class StationsController {

	public static class MemberId {
		Long member_id;

		private Long getId() {
			return member_id;
		}

		private void setId(Long id) {
			this.member_id = id;
		}
	}

	@Autowired
	private StationService stationService;

	@GetMapping("")
	// @Secured("ROLE_ADMIN")
	public List<Station> listStations() throws Exception {
		return stationService.listAll();
	}

	@PostMapping("")
	public Station createStation(@RequestBody Station station) throws Exception {
		return stationService.createStation(station);
	}

	@GetMapping("/{id}")
	// @Secured("ROLE_ADMIN")
	public Optional<Station> findById(@PathVariable Long id) throws Exception {
		return stationService.findById(id);
	}

	@PostMapping("/{id}")
	// @Secured("ROLE_ADMIN")
	public Optional<Station> editStation(@PathVariable Long id, @RequestBody Station station) throws Exception {
		return stationService.editStation(id, station);
	}

	@PostMapping("/{id}/members/")
	// @Secured("ROLE_ADMIN")
	public Station addMember(@PathVariable Long id, @RequestBody Long member_id) throws Exception {
		return stationService.addMember(id, member_id);
	}

}
