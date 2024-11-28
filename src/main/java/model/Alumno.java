package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Alumno implements Serializable {
    @BsonProperty("rating")
    private double rating;
    @BsonProperty("age")
    private int age;
    @BsonProperty("name")
    private String name;
    @BsonProperty("gender")
    private String gender;
    @BsonProperty("email")
    private String email;
    @BsonProperty("phone")
    private String phone;
    @BsonProperty("calificaation")
    private int calificaation;
    @BsonProperty("higher_grade")
    private String higher_grade;

    @Override
    public String toString() {
        return "Alumno{" +
                "rating=" + rating +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", calificaation=" + calificaation +
                ", higher_grade='" + higher_grade + '\'' +
                '}';
    }
}
