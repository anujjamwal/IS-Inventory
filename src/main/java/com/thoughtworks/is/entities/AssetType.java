package com.thoughtworks.is.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "ASSET_TYPE")
@AllArgsConstructor
@NoArgsConstructor
public @Data class AssetType {
    @Id
    @GeneratedValue (generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    @Column(name = "type")
    private String type;
}
