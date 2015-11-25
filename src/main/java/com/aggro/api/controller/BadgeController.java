package com.aggro.api.controller;

import com.aggro.api.entity.Badge;
import com.aggro.api.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yeko on 20/10/15.
 */
@RestController
@RequestMapping("/aggro/badge")
public class BadgeController {

    @Autowired
    private BadgeService badgeService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Badge register(@RequestBody Badge newBadge) {
        return badgeService.add(newBadge);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Badge> getAll() {
        return badgeService.getAllBadges();
    }

}
