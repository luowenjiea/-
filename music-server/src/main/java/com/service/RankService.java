package com.service;

import com.model.Rank;

public interface RankService {

    int rankOfSongListId(Long songListId);

    boolean addRank(Rank rank);
}
