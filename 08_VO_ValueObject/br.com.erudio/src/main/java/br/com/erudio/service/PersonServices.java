package br.com.erudio.service;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.mapper.custom.PersonMapper;
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

    @Autowired
    PersonMapper mapper;

    public List<PersonVO> findAll(){

        logger.info("Finding all pepleo!");
        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id){
        logger.info("Finding one person!");
        var entity =  repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not records founds for this ID"));
        return DozerMapper.parseObject(entity, PersonVO.class);
    }


    public PersonVO create(PersonVO person) {
        logger.info("Create one person!");

        var entity = DozerMapper.parseObject(person, Person.class);
        return DozerMapper.parseObject(repository.save(entity), PersonVO.class);
    }

    public PersonVOV2 createV2(PersonVOV2 person) {
        logger.info("Service V2 - Create one person!");

        var entity = mapper.convertToVoEntity(person);
        return mapper.convertEntityToVO(repository.save(entity));
    }

    public PersonVO update(PersonVO person) {
        logger.info("Update one person!");

        var entity =  repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Not records founds for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return DozerMapper.parseObject(repository.save(entity), PersonVO.class);
    }

    public void delete(Long id) {
        logger.info("Delete one person!");

        var entity =  repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not records founds for this ID"));

       repository.delete(entity);
    }

}
