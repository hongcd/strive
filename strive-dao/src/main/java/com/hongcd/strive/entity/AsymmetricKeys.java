package com.hongcd.strive.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "asymmetric_keys")
@EqualsAndHashCode(callSuper = true)
public class AsymmetricKeys extends BaseEntity {
    @Column(name = "public_key", nullable = false, length = 2048)
    private String publicKey;
    @Column(name = "private_key", nullable = false, length = 512)
    private String privateKey;
    @Column(name = "module", nullable = false, length = 64)
    private String module;
}