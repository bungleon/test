package com.test.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "banks", schema = "speedyhugo", indexes = {
        @Index(name = "banks_swift_code_idx", columnList = "swift_code"),
        @Index(name = "banks_created_idx", columnList = "created"),
        @Index(name = "banks_updated_idx", columnList = "updated"),
        @Index(name = "banks_enabled_idx", columnList = "enabled"),
        @Index(name = "banks_status_idx", columnList = "status")
}, uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "status"}),
        @UniqueConstraint(columnNames = {"swift_code", "status"}),
        @UniqueConstraint(columnNames = {"priority", "status"})})
public class Bank {
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

    @PreUpdate
    protected void onUpdate() {
        this.updated = LocalDateTime.now();
    }
    @Size(min = 2, max = 100)
    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @Size(min = 2, max = 50)
    @NotEmpty
    @Column(name = "swift_code")
    private String swiftCode;

    @Column(name = "apk_no")
    private String apkNo;

    @Column(name = "priority")
    private Long priority;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ProxyBlackList> blackList;

    @NotNull
    @Column(name = "enabled")
    @ColumnDefault(value = "true")
    private Boolean enabled = true;

    @Column(name = "status")
    @ColumnDefault(value = "true")
    private Boolean status = true;

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

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getApkNo() {
        return apkNo;
    }

    public void setApkNo(String apkNo) {
        this.apkNo = apkNo;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
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
}
