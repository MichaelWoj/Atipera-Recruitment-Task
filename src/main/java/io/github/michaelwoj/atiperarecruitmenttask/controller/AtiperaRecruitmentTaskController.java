package io.github.michaelwoj.atiperarecruitmenttask.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.github.michaelwoj.atiperarecruitmenttask.entity.FlattenedRepoInfo;
import io.github.michaelwoj.atiperarecruitmenttask.service.AtiperaRecruitmentTaskService;


@RestController
public class AtiperaRecruitmentTaskController {

    private final AtiperaRecruitmentTaskService atiperaRecruitmentTaskService;

    public AtiperaRecruitmentTaskController(AtiperaRecruitmentTaskService atiperaRecruitmentTaskService ){
        this.atiperaRecruitmentTaskService = atiperaRecruitmentTaskService;
    }
    
    @GetMapping("/{username}/repos")
    public List<FlattenedRepoInfo> getUserRepos(@PathVariable String username) {
        return atiperaRecruitmentTaskService.getUserRepos(username);
    }
}
