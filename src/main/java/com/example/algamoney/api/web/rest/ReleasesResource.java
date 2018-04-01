package com.example.algamoney.api.web.rest;

import com.example.algamoney.api.event.ResourceCreatedEvent;
import com.example.algamoney.api.service.dto.ReleasesDTO;
import com.example.algamoney.api.service.mapper.ReleasesMapper;
import com.example.algamoney.api.model.ReleasesEntity;
import com.example.algamoney.api.service.ReleasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ReleasesResource.URL_RELATIONSHIP)
public class ReleasesResource {

    public static final String URL_RELATIONSHIP ="/releases";

    @Autowired
    private ReleasesService releasesService;

    @Autowired
    private ReleasesMapper releasesMapper;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<ReleasesEntity> list(){
       return releasesService.listAllReleases();


    }
    @PostMapping
    public ResponseEntity<ReleasesDTO> insert(@Valid @RequestBody ReleasesDTO releasesDTO, HttpServletResponse response){
       releasesService.createReleases(releasesMapper.toEntity(releasesDTO));
        publisher.publishEvent(new ResourceCreatedEvent(this, response, releasesDTO.getId()));
       return ResponseEntity.status(HttpStatus.CREATED).body(releasesDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReleasesDTO> update(@Valid @RequestBody ReleasesDTO releasesDTO, @PathVariable (value = "id") Long id){
        releasesService.updateReleases(releasesMapper.toEntity(releasesDTO));
        return ResponseEntity.status(HttpStatus.OK).body(releasesDTO);
    }

    @DeleteMapping
    public ResponseEntity delete(@PathVariable (value = "id") Long id){
        releasesService.deleteReleases(id);
       return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }


}
