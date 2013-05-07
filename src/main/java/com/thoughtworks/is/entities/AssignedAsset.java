package com.thoughtworks.is.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.type.AbstractLobType;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "ASSIGNED_ASSETS")
@AllArgsConstructor
@NoArgsConstructor
public @Data class AssignedAsset {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    @Column(name = "assetTag")
    private String assetTag;

    @Column(name = "identifier")
    private String identifier;

    @Column(name = "identifier_type")
    private String identifierType;

    @Column(name = "assigned_date", columnDefinition = "date")
    private Date assignedDate;

    @Column(name = "returned_date", columnDefinition = "date")
    private Date returnedDate;
}
