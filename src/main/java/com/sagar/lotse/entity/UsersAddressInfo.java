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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_address_info_gen")
    @SequenceGenerator(name = "users_address_info_gen", sequenceName = "users_adress_info_seq", allocationSize = 1)
    private String temporaryAddress;
    private String personalAddress;
    private String currentAddress;
    private String email;
    private String alternateEmail;
    private String mobileNumber;
    private String alternateMobileNumber;
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "users_basic-info", foreignKey = @ForeignKey(name = "fk_users_basic_info_id"), referencedColumnName = "id")
    private UsersBasicInfo usersBasicInfo;
}
