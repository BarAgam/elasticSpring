package com.example.demo;


import java.util.Objects;

public class SomeModel {

    private String sector;
    private String word;


    private SomeModel() {
    }


    public SomeModel(String sector, String word) {
        this.sector = sector;
        this.word = word;
    }

    public String getSector() {
        return sector;
    }

    public String getWord() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SomeModel someModel = (SomeModel) o;
        return Objects.equals(sector, someModel.sector) &&
                Objects.equals(word, someModel.word);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sector, word);
    }

    @Override
    public String toString() {
        return "SomeModel{" +
                "sector='" + sector + '\'' +
                ", word='" + word + '\'' +
                '}';
    }
}
