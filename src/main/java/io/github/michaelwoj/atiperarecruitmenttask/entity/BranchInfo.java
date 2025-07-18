package io.github.michaelwoj.atiperarecruitmenttask.entity;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BranchInfo {

    @JsonProperty("name")
    private String branchName;

    @JsonProperty("commit")
    private LastCommitSha lastCommitSha;

}
