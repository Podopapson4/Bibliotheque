package com.podosoft.bibliotheque.Models.Joined;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CategoryVolumeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;

    // parent
    private Long volumeInfoId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getVolumeInfoId() {
        return volumeInfoId;
    }

    public void setVolumeInfoId(Long volumeInfoId) {
        this.volumeInfoId = volumeInfoId;
    }

}
