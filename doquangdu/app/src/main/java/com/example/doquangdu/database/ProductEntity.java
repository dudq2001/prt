package com.example.doquangdu.database;

import android.icu.text.CaseMap;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity ( tableName = "Product")
public class ProductEntity {
    @PrimaryKey (autoGenerate = true)
    public int id;
    @ColumnInfo(name = "name")
    public String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @ColumnInfo( name = "quantity")
    public  int quantity;
}
