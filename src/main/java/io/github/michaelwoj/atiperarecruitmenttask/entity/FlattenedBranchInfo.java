package io.github.michaelwoj.atiperarecruitmenttask.entity;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FlattenedBranchInfo {
    @JsonProperty("name")
    private String flattenedBranchName;

    @JsonProperty("sha")
    private String flattenedLastCommitSha;
}
