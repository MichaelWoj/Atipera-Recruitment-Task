package io.github.michaelwoj.atiperarecruitmenttask.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepoInfo {
    
    @JsonProperty("name")
    private String repoName;

    @JsonProperty("fork")
    private boolean isFork;

    private Owner owner;

    private List<BranchInfo> branches;
}
