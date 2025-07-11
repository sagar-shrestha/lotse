package com.sagar.lotse.entity;

import com.sagar.lotse.common.entity.Details;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@Table(name = "users_address_info")
@AllArgsConstructor
@NoArgsConstructor
public class UsersAddressInfo extends Details {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_address_info_gen")
    @SequenceGenerator(name = "users_address_info_gen", sequenceName = "users_address_info_seq", allocationSize = 1)
    private Long id;
    private String temporaryAddress;
    private String personalAddress;
    private String currentAddress;
    private String email;
    @Column(nullable = false)
    private String alternateEmail;
    private String mobileNumber;
    private String alternateMobileNumber;
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "users_basic_info", foreignKey = @ForeignKey(name = "fk_users_basic_info_id"), referencedColumnName = "id")
    private UsersBasicInfo usersBasicInfo;
}
