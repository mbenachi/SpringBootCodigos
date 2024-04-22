package com.codeinnova.BorradorSpringBoot.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity //Son los modelos
@Table(name = "Codigos")
public class Codigo {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String branch;
    private Integer pages;
    private Double price;
    private LocalDate releaseDate;
    private Boolean onLine;

    //Constructores{

    public Codigo() {
    }

    public Codigo(Long id, String title, String branch, Integer pages, Double price, LocalDate releaseDate, Boolean onLine) {
        this.id = id;
        this.title = title;
        this.branch = branch;
        this.pages = pages;
        this.price = price;
        this.releaseDate = releaseDate;
        this.onLine = onLine;
    }

    //Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getOnLine() {
        return onLine;
    }

    public void setOnLine(Boolean onLine) {
        this.onLine = onLine;
    }

}
