package com.test.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.test.helper.LocalDateTimeAttributeConverter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "proxies", schema = "speedyhugo", indexes = {
        @Index(name = "proxies_created_idx", columnList = "created"),
        @Index(name = "proxies_updated_idx", columnList = "updated"),
        @Index(name = "proxies_enabled_idx", columnList = "enabled"),
        @Index(name = "proxies_status_idx", columnList = "status")
}, uniqueConstraints = @UniqueConstraint(columnNames = {"name", "status"}))
public class Proxy {

    @Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @Type(type = "pg-uuid")
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(name = "updated", insertable = false)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime updated;

    @Column(name = "created", updatable = false, nullable = false)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime created;

    @PreUpdate
    protected void onUpdate() {
        this.updated = LocalDateTime.now();
    }

    @NotEmpty
    @Size(min = 5, max = 100)
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty
    @Column(name = "proxy_list", nullable = false)
    private String proxyList;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @NotNull
    @Column(name = "enabled")
    @ColumnDefault(value = "true")
    private Boolean enabled = true;

    @Column(name = "status")
    @ColumnDefault(value = "true")
    private Boolean status = true;


    @OneToMany(mappedBy = "proxy", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ProxyBlackList> blackList;

    public List<ProxyBlackList> getBlackList() {
        return blackList;
    }

    public void setBlackList(List<ProxyBlackList> blackList) {
        this.blackList = blackList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProxyList() {
        return proxyList;
    }

    public void setProxyList(String proxyList) {
        this.proxyList = proxyList;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @PrePersist
    protected void onCreate() {
        if (this.created == null) {
            this.created = LocalDateTime.now();
        }
    }
}
