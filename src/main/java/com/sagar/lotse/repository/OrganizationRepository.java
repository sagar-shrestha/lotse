package com.sagar.lotse.repository;

import com.sagar.lotse.entity.OrganizationInfo;
import com.sagar.lotse.pojo.common.response.OrganizationResponsePojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<OrganizationInfo, Integer> {

    @Query(value = "select * from organization_info where id= :id", nativeQuery = true)
    Optional<OrganizationInfo> findOrganizationById(@Param("id") int id);

    @Query(value = "select * from organization_info where (:id IS NULL or id = :id)", nativeQuery = true)
    List<OrganizationInfo> getAllOrganizations(Integer id);

    @Query(value = "select * from organization_info where id = coalesce(null, :id)", nativeQuery = true)
    List<OrganizationInfo> getOrganization(@Param("id") Integer id);
}
