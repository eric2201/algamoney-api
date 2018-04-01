package com.example.algamoney.api.web.rest;

import com.example.algamoney.api.event.ResourceCreatedEvent;
import com.example.algamoney.api.model.PeopleEntity;
import com.example.algamoney.api.service.PeopleService;
import com.example.algamoney.api.service.dto.PeopleDTO;
import com.example.algamoney.api.service.mapper.PeopleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(PeopleResource.URI_PEOPLE)
public class PeopleResource {
    public static final String URI_PEOPLE = "/people";

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private PeopleMapper peopleMapper;

    @Autowired
    private ApplicationEventPublisher publisher;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<PeopleEntity> list() {
        return peopleService.findAllPeople();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PeopleDTO> insert(@Valid @RequestBody PeopleDTO peopleDTO, HttpServletResponse response) {
        peopleService.savePeople(peopleMapper.toEntity(peopleDTO));
        publisher.publishEvent(new ResourceCreatedEvent(this, response, peopleDTO.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(peopleDTO);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity update(@Valid @RequestBody PeopleDTO peopleDTO, @PathVariable(value = "id") Long id) {
        peopleService.updatePeople(peopleMapper.toEntity(peopleDTO), id);
        return new ResponseEntity<String>(HttpStatus.OK);

    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete (@PathVariable (value = "id") Long id){
        peopleService.deletePeople(id);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PeopleEntity findByCode(@PathVariable (value = "id") Long id){
        return peopleService.findByCode(id);
    }
}
