package com.dhawal.petetite.Database.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "user_name")
    private String userName;

    private String password;

    @ColumnInfo(name = "pet's_name")
    private String petsName;

    @ColumnInfo(name="pet_type")
    private String petType;

    @ColumnInfo(name="pet's_age")
    private String petsAge;

    public User(String userName, String password, String petsName, String petType, String petsAge) {
        this.userName = userName;
        this.password = password;
        this.petsName = petsName;
        this.petType = petType;
        this.petsAge = petsAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPetsName() {
        return petsName;
    }

    public void setPetsName(String petsName) {
        this.petsName = petsName;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getPetsAge() {
        return petsAge;
    }

    public void setPetsAge(String petsAge) {
        this.petsAge = petsAge;
    }
}
