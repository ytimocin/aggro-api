package com.aggro.api.service;

import com.aggro.api.entity.Badge;
import com.aggro.api.repository.BadgeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yeko on 20/10/15.
 */
@Service
public class BadgeService {

    @Autowired
    private BadgeRepository badgeRepository;

    public List<Badge> getAllBadges() {
        return badgeRepository.findAll();
    }

    // will be used internally
    public Badge add(Badge newBadge) {
        return badgeRepository.save(newBadge);
    }

}
