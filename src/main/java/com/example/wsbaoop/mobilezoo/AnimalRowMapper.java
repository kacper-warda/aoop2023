package com.example.wsbaoop.mobilezoo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnimalRowMapper implements RowMapper<Animal> {
    @Override
    public Animal mapRow(ResultSet rs, int rowNum) throws SQLException {
        Animal animal = new Animal();
        animal.id = rs.getLong("id");
        animal.specie = rs.getString("specie");
        animal.name = rs.getString("name");
        animal.alive = rs.getBoolean("alive");
        return animal;
    }
}
