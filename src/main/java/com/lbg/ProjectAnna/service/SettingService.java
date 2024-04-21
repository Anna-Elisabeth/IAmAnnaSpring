package com.lbg.ProjectAnna.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.ProjectAnna.domain.Person;
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

	public ResponseEntity<Setting> getSettingById(int id) {
		
Optional<Setting> found = this.repo.findById(id);
		
		if (found.isEmpty()) {
			return new ResponseEntity<Setting>(HttpStatus.NOT_FOUND);
		}

		Setting body = found.get();

		return ResponseEntity.ok(body);

	}

	public boolean deleteSetting(int id) {
		
		this.repo.deleteById(id);
		return !this.repo.existsById(id);

	}

	public ResponseEntity<Setting> updateSetting(int id, Setting updateSetting) {
	
		 Optional<Setting> found = this.repo.findById(id);

		    if (found.isEmpty()) {
		        return new ResponseEntity<Setting>(HttpStatus.NOT_FOUND);
		    }

		    Setting existing = found.get();

		    
		    if (updateSetting.getLocation() != null) {
		        existing.setLocation(updateSetting.getLocation());
		    }

		    Setting updated = this.repo.save(existing);

		    return ResponseEntity.ok(updated);
		}

	
}
