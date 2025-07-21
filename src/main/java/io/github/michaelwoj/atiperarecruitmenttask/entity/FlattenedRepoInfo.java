package io.github.michaelwoj.atiperarecruitmenttask.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FlattenedRepoInfo {

    @JsonProperty("name")
    private String flattenedRepoName;

    @JsonProperty("login")
    private String flattenedOwnerLogin;

    private List<FlattenedBranchInfo> branch;
}
