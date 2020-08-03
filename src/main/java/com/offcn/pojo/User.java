package com.offcn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "uname",nullable = true,length = 30)
    private String uname;

    @Column(name = "uage",nullable = true)
    private Integer uage;
}
