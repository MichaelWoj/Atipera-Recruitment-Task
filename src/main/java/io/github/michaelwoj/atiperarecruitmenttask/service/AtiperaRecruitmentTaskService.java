package io.github.michaelwoj.atiperarecruitmenttask.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpHeaders;

import io.github.michaelwoj.atiperarecruitmenttask.entity.BranchInfo;
import io.github.michaelwoj.atiperarecruitmenttask.entity.RepoInfo;

@Service
public class AtiperaRecruitmentTaskService {
    
    private final RestTemplate restTemplate;

    public AtiperaRecruitmentTaskService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    private String baseUrl = "https://api.github.com";

    public List<RepoInfo> getUserRepos(String username){
        String reposUrl = baseUrl + "/users/"+username+"/repos";
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(List.of(MediaType.APPLICATION_JSON));
            HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

                        ResponseEntity<RepoInfo[]> response = restTemplate.exchange(
                        reposUrl,
                        HttpMethod.GET,
                        requestEntity,
                        RepoInfo[].class,
                        username
                );
            
            List<RepoInfo> allRepos = Arrays.asList(response.getBody());
            List<RepoInfo> nonForkedRepos = new ArrayList<>();

            for (RepoInfo repo : allRepos) {
                    if (!repo.isFork()) {
                        String branchUrl = String.format(baseUrl + "/repos/"+username+"/"+repo.getRepoName()+"/branches");

                        ResponseEntity<BranchInfo[]> branchResponse = restTemplate.exchange(
                                branchUrl,
                                HttpMethod.GET,
                                requestEntity,
                                BranchInfo[].class
                        );

                        repo.setBranches(Arrays.asList(branchResponse.getBody()));
                        nonForkedRepos.add(repo);
                    }
                }

                return nonForkedRepos;
        }catch (HttpClientErrorException.NotFound ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }
}
