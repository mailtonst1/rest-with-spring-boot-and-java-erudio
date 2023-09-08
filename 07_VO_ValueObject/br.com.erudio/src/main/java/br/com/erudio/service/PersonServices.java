package br.com.erudio.service;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll(){

        logger.info("Finding all pepleo!");
        return repository.findAll();
    }

    public  Person create(Person person) {
        logger.info("Create one person!");
        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Update one person!");

        var entity =  repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Not records founds for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return repository.save(person);
    }

    public void delete(Long id) {
        logger.info("Delete one person!");

        var entity =  repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not records founds for this ID"));

       repository.delete(entity);
    }

    public Person findById(Long id){
        logger.info("Finding one person!");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not records founds for this ID"));
    }

}
