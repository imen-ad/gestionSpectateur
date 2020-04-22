package isi.tn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import isi.tn.repository.BilletRepository;
import isi.tn.exception.ResourceNotFoundException;
import isi.tn.model.Billet;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class BilletController {
	@Autowired
	private BilletRepository billetRepository;

	@GetMapping("/billets")
	public List<Billet> getAllEmployees() {
		return billetRepository.findAll();
	}

	@GetMapping("/billets/{id}")
	public ResponseEntity<Billet> getEmployeeById(@PathVariable(value = "id") Long billetId)
			throws ResourceNotFoundException {
		Billet billet = billetRepository.findById(billetId)
				.orElseThrow(() -> new ResourceNotFoundException("Billet not found for this id :: " + billetId));
		return ResponseEntity.ok().body(billet);
	}

	@PostMapping("/billets")
	public Billet createBillet(@Valid @RequestBody Billet billet) {
		return billetRepository.save(billet);
	}

	@PutMapping("/billets/{id}")
	public ResponseEntity<Billet> updateBillet(@PathVariable(value = "id") Long billetId,
			@Valid @RequestBody Billet billetDetails) throws ResourceNotFoundException {
		Billet billet = billetRepository.findById(billetId)
				.orElseThrow(() -> new ResourceNotFoundException("Billet not found for this id :: " + billetId));

		billet.setCin(billetDetails.getCin());
		billet.setNumber(billetDetails.getNumber());
		billet.setLastName(billetDetails.getLastName());
		billet.setFirstName(billetDetails.getFirstName());
		final Billet updatedBillet = billetRepository.save(billet);
		return ResponseEntity.ok(updatedBillet);
	}

	@DeleteMapping("/billets/{id}")
	public Map<String, Boolean> deleteBillet(@PathVariable(value = "id") Long billetId)
			throws ResourceNotFoundException {
		Billet billet = billetRepository.findById(billetId)
				.orElseThrow(() -> new ResourceNotFoundException("Billet not found for this id :: " + billetId));

		billetRepository.delete(billet);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
