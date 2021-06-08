package rva.ctrls;

import java.util.Collection;

import javax.transaction.Transactional;

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
import rva.jpa.Preduzece;
import rva.jpa.Sektor;
import rva.repository.SektorRepository;

@CrossOrigin
@RestController
@Api(tags = {"Sektor CRUD operacije"})
public class SektorRestController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SektorRepository sektorRepository;
	
	
	@GetMapping("sektor")
	@ApiOperation(value = "Vraæa kolekciju svih sektora iz baze podataka")
	public Collection<Sektor> getSektors()
	{
		return sektorRepository.findAll();
	}

	@GetMapping("sektor/{id}")
	@ApiOperation(value = "Vraæa sektor po ID sektora")
	public Sektor getSektor(@PathVariable("id") Integer id)
	{
		return sektorRepository.getOne(id);
	}
	
	@GetMapping("sektorNaziv/{naziv}")
	@ApiOperation(value = "Vraæa sektore po nazivu sektora")
	public Collection<Sektor> getSektorByNaziv(@PathVariable("naziv") String naziv)
	{
		return sektorRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@PostMapping("sektor")
	@ApiOperation(value = "Dodaje novi sektor")
	public ResponseEntity<Sektor> insertSektor(@RequestBody Sektor sektor )
	{
		if(!sektorRepository.existsById(sektor.getId()))
		{
			sektorRepository.save(sektor);
			return new ResponseEntity<Sektor>(HttpStatus.OK);
		}
		return new ResponseEntity<Sektor>(HttpStatus.CONFLICT);
		
	}
	
	@PutMapping("sektor")
	@ApiOperation(value = "Ažurira postojeæi sektor")
	public ResponseEntity<Sektor> updateSektor(@RequestBody Sektor sektor)
	{
		if(!sektorRepository.existsById(sektor.getId()))
		{
			return new ResponseEntity<Sektor>(HttpStatus.NO_CONTENT);
		}
		
		sektorRepository.save(sektor);
		return new ResponseEntity<Sektor>(HttpStatus.OK);
	}
	
	@Transactional
	@DeleteMapping("sektor/{id}")
	@ApiOperation(value = "Briše postojeæi sektor")
	public ResponseEntity<Sektor> deleteSektor(@PathVariable("id") Integer id)
	{
		if(!sektorRepository.existsById(id))
		{
			return new ResponseEntity<Sektor>(HttpStatus.NO_CONTENT);
		}
		
		jdbcTemplate.execute("delete from radnik where sektor=" + id);
		sektorRepository.deleteById(id);
		if(id==-100 )
		{
			jdbcTemplate.execute(
					"insert into \"sektor\" (\"id\", \"naziv\", \"oznaka\", \"preduzece\") "
							+ "values (-100, 'Sektor test', 'testS', 1)"
					
					);
		}
		return new ResponseEntity<Sektor>(HttpStatus.OK);
	}
	
	
	
	
	

}
