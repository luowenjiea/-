package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.model.Rank;
import com.service.impl.RankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Controller
public class RankController {

    @Autowired
    private RankServiceImpl rankService;

//    提交评分
    @ResponseBody
    @RequestMapping(value = "/rank/add", method = RequestMethod.POST)
    @CrossOrigin
    public Object addRank(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        String songListId = req.getParameter("songListId").trim();
        String consumerId = req.getParameter("consumerId").trim();
        String score = req.getParameter("score").trim();

        Rank rank = new Rank();
        rank.setSongListId(Long.parseLong(songListId));
        rank.setConsumerId(Long.parseLong(consumerId));
        rank.setScore(Integer.parseInt(score));

        boolean res = rankService.addRank(rank);
        if (res){
            jsonObject.put("code", 1);
            jsonObject.put("msg", "评价成功");
            return jsonObject;
        }else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "评价失败");
            return jsonObject;
        }
    }

//    获取指定歌单的评分
    @RequestMapping(value = "/rank", method = RequestMethod.GET)
    @CrossOrigin
    public Object rankOfSongListId(HttpServletRequest req){
        String songListId = req.getParameter("songListId");
        return rankService.rankOfSongListId(Long.parseLong(songListId));
    }
}
