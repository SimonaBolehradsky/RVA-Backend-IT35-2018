package rva.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import rva.jpa.Obrazovanje;
import rva.jpa.Preduzece;
import rva.repository.PreduzeceRepository;

@CrossOrigin
@RestController
@Api(tags = {"Preduzece CRUD operacije"})
public class PreduzeceRestController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PreduzeceRepository preduzeceRepository;
	
	
	@GetMapping("preduzece")
	@ApiOperation(value = "Vraæa kolekciju svih preduzeæa iz baze podataka")
	public Collection<Preduzece> getPreduzeces()
	{
		return preduzeceRepository.findAll();
	}

	@GetMapping("preduzece/{id}")
	@ApiOperation(value = "Vraæa preduzeæe po ID preduzeæa")
	public Preduzece getPreduzece(@PathVariable("id") Integer id)
	{
		return preduzeceRepository.getOne(id);
	}
	
	@GetMapping("preduzeceNaziv/{naziv}")
	@ApiOperation(value = "Vraæa preduzeæa po nazivu preduzeæa")
	public Collection<Preduzece> getPreduzeceByNaziv(@PathVariable("naziv") String naziv)
	{
		return preduzeceRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@PostMapping("preduzece")
	@ApiOperation(value = "Dodaje novo preduzeæe")
	public ResponseEntity<Preduzece> insertPreduzece(@RequestBody Preduzece preduzece )
	{
		if(!preduzeceRepository.existsById(preduzece.getId()))
		{
			preduzeceRepository.save(preduzece);
			return new ResponseEntity<Preduzece>(HttpStatus.OK);
		}
		return new ResponseEntity<Preduzece>(HttpStatus.CONFLICT);
		
		
		
	}

	@PutMapping("preduzece")
	@ApiOperation(value = "Ažurira postojeæe preduzeæe")
	public ResponseEntity<Preduzece> updatePreduzece(@RequestBody Preduzece preduzece)
	{
		if(!preduzeceRepository.existsById(preduzece.getId()))
		{
			return new ResponseEntity<Preduzece>(HttpStatus.NO_CONTENT);
		}
		
		preduzeceRepository.save(preduzece);
		return new ResponseEntity<Preduzece>(HttpStatus.OK);
	}
	
	
	@DeleteMapping("preduzece/{id}")
	@ApiOperation(value = "Briše postojeæe preduzeæe")
	public ResponseEntity<Preduzece> deletePreduzece(@PathVariable("id") Integer id)
	{
		if(!preduzeceRepository.existsById(id))
		{
			return new ResponseEntity<Preduzece>(HttpStatus.NO_CONTENT);
		}
		
		preduzeceRepository.deleteById(id);
		if(id==-100 )
		{
			jdbcTemplate.execute(
					"insert into \"preduzece\" (\"id\", \"naziv\", \"pib\", \"sediste\",\"opis\") "
							+ "values (-100, 'Preduzece test', '8556', 'test NS','test')"
					
					);
		}
		return new ResponseEntity<Preduzece>(HttpStatus.OK);
	}
	
	
	
	
}
