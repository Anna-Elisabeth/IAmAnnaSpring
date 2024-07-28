package com.lbg.ProjectAnna.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.ProjectAnna.domain.Person;
import com.lbg.ProjectAnna.domain.Setting;
import com.lbg.ProjectAnna.service.SettingService;

@RestController
@RequestMapping("/setting")
@CrossOrigin
public class SettingController {
	
	private SettingService service;

	public SettingController(SettingService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Setting> createSetting(@RequestBody Setting newSetting) {
		return this.service.createSetting(newSetting);
	}

	@GetMapping("/get")
	public List<Setting> getSettings() {
		return this.service.getSettings();
	}
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Setting> getSettingById(@PathVariable int id) {
		return this.service.getSettingById(id);
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteSetting(@PathVariable int id) {
		return this.service.deleteSetting(id);

	}

	@PatchMapping("/update/{id}")
	public ResponseEntity<Setting> updateSetting(@PathVariable int id, @RequestBody Setting updateSetting) {

		return this.service.updateSetting(id, updateSetting);

	}

}
