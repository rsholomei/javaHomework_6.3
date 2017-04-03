package com.geekhub.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_TYRES")
public class Tyres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "size")
    private Integer sizeTyres;

    @Column(name = "name")
    private String nameTyres;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSizeTyres() {
        return sizeTyres;
    }

    public void setSizeTyres(Integer sizeTyres) {
        this.sizeTyres = sizeTyres;
    }

    public String getNameTyres() {
        return nameTyres;
    }

    public void setNameTyres(String nameTyres) {
        this.nameTyres = nameTyres;
    }

    @Override
    public String toString() {
        return "Tyres{" +
                "id=" + id +
                ", sizeTyres=" + sizeTyres +
                ", nameTyres='" + nameTyres + '\'' +
                '}';
    }
}
