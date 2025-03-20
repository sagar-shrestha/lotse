package com.sagar.lotse.entity;

import com.sagar.lotse.common.entity.Details;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "organization_info")
@Getter
@Setter
public class OrganizationInfo extends Details implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organization_info_gen")
    @SequenceGenerator(name = "organization_info_gen", sequenceName = "organization_info_seq" , allocationSize = 1)
    private Integer id;
    private String name;
    private String address;
    private String panOrVat;
    private String president;
    private String charPerson;
    private String dean;
    private String Slogan;
}