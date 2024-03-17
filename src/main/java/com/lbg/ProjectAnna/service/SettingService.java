package com.lbg.ProjectAnna.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.ProjectAnna.domain.Setting;
import com.lbg.ProjectAnna.repo.SettingRepo;

@Service
public class SettingService {

	private SettingRepo repo;

	public SettingService(SettingRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Setting> createSetting(Setting newSetting) {
		Setting created = this.repo.save(newSetting);
		return new ResponseEntity<Setting>(created, HttpStatus.CREATED);
	}

	public List<Setting> getSettings() {
		return this.repo.findAll();
	}
	
	
}
