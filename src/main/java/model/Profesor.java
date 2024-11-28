package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonProperty;

import javax.security.auth.Subject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profesor implements Serializable {
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
    @BsonProperty("subjects")
    private List<String> subjects;
    @BsonProperty("title")
    private String title;

    @Override
    public String toString() {
        return "Profesor{" +
                "rating=" + rating +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", subjects=" + subjects +
                ", title='" + title + '\'' +
                '}';
    }
}
