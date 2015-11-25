package com.aggro.api.repository;

import com.aggro.api.entity.Badge;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by yeko on 18/10/15.
 */
public interface BadgeRepository extends MongoRepository<Badge, String> {

    Badge findByBadgeID(String badgeID);

}
