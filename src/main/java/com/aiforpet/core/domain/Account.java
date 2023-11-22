package com.aiforpet.core.domain;

import com.aiforpet.core.controller.dto.MyAccountReq;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "account")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class Account {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private String address1;

    private String address2;

    @Column(name = "zip", nullable = false)
    private String zip;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public Account(String email, String firstName, String lastName, String password,
                   String address1, String address2, String zip) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.address1 = address1;
        this.address2 = address2;
        this.zip = zip;
    }

    public void updateMyAccount(MyAccountReq request) {
        this.address1 = request.address1();
        this.address2 = request.address2();
        this.zip = request.zip();
    }
}
