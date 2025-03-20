package com.sagar.lotse.repository;

import com.sagar.lotse.entity.OrganizationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<OrganizationInfo, Integer> {
}
