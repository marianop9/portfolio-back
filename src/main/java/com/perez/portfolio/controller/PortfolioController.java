package com.perez.portfolio.controller;

import java.util.List;

import com.perez.portfolio.dto.PortfolioDTO;
import com.perez.portfolio.model.Home;
import com.perez.portfolio.model.Skill;
import com.perez.portfolio.service.about.AboutService;
import com.perez.portfolio.service.home.HomeService;
import com.perez.portfolio.service.skill.SkillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class PortfolioController {
    @Autowired
    HomeService homeService;
    @Autowired
    AboutService aboutService;
    @Autowired
    SkillService skillService;

    // @GetMapping(path = "/home")
    // public Home getHome() {
    //     return homeService.getHome();
    // }

    @PostMapping(path = "/home")
    public Home createHome(@RequestBody Home home) {
        return homeService.createHome(home);
    }

    @GetMapping(path = "/portfolio/get")
    public PortfolioDTO getPortfolio() {
        return new PortfolioDTO(
            homeService.getHome(),
            aboutService.getAbout(),
            skillService.getAll()
        );
    }

    @GetMapping(path = "/test/skills")
    public List<Skill> getSkills() {
        return this.skillService.getAll();
    }
    
}
