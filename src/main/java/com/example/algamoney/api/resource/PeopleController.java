package com.example.algamoney.api.resource;

import com.example.algamoney.api.event.ResourceCreatedEvent;
import com.example.algamoney.api.model.PeopleEntity;
import com.example.algamoney.api.service.PeopleService;
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
@RequestMapping(PeopleController.URI_PEOPLE)
public class PeopleController {
    public static final String URI_PEOPLE = "/people";

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<PeopleEntity> list() {
        return peopleService.findAllPeople();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PeopleEntity> insert(@Valid @RequestBody PeopleEntity peopleEntity, HttpServletResponse response) {
        peopleService.savePeople(peopleEntity);
        publisher.publishEvent(new ResourceCreatedEvent(this, response, peopleEntity.getCode()));

        return ResponseEntity.status(HttpStatus.CREATED).body(peopleEntity);
    }

    @RequestMapping(value = "{code}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity update(@Valid @RequestBody PeopleEntity peopleEntity, @PathVariable(value = "code") int code) {
        peopleService.updatePeople(peopleEntity, code);
        return new ResponseEntity<String>(HttpStatus.OK);

    }

    @RequestMapping(value = "{code}", method = RequestMethod.DELETE)
    public ResponseEntity delete (@PathVariable (value = "code") int code){
        peopleService.deletePeople(code);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PeopleEntity findByCode(@PathVariable (value = "code") int code){
        return peopleService.findByCode(code);
    }
}
