package com.example.algamoney.api.resource;

import com.example.algamoney.api.model.LaunchEntity;
import com.example.algamoney.api.service.LaunchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(LaunchController.URL_RELATIONSHIP)
public class LaunchController {

    public static final String URL_RELATIONSHIP ="/relationship";
    private LaunchService launchService;

    @GetMapping
    public List<LaunchEntity> list(){
        launchService.listAllLaunch();


    }


}
