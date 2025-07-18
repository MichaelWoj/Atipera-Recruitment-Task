package io.github.michaelwoj.atiperarecruitmenttask.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import io.github.michaelwoj.atiperarecruitmenttask.entity.RepoInfo;
import io.github.michaelwoj.atiperarecruitmenttask.service.AtiperaRecruitmentTaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class AtiperaRecruitmentTaskController {

    private AtiperaRecruitmentTaskService atiperaRecruitmentTaskService;

    public AtiperaRecruitmentTaskController(AtiperaRecruitmentTaskService atiperaRecruitmentTaskService ){
        this.atiperaRecruitmentTaskService = atiperaRecruitmentTaskService;
    }
    
    @GetMapping("/{username}/repos")
    public List<RepoInfo> getUserRepos(@PathVariable String username) {
        return atiperaRecruitmentTaskService.getUserRepos(username);
    }
}
