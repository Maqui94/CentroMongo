package DAO;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import database.MongoDBConnection;
import model.Alumno;
import model.Profesor;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class ProfesorDAO {
    MongoCollection coleccionProfesores;
    public ProfesorDAO(){
        coleccionProfesores=new MongoDBConnection().getProfesCollection();
    }
    public void insertarProfe(Profesor profesor){
        Document document=new Document().append("rating",profesor.getRating())
                .append("age",profesor.getAge())
                .append("name",profesor.getName())
                .append("gender",profesor.getGender())
                .append("email",profesor.getEmail())
                .append("phone",profesor.getPhone())
                .append("subjects",profesor.getSubjects())
                .append("title",profesor.getTitle());
        coleccionProfesores.insertOne(document);

    }
    public List<Profesor> obtenerTodos() {
        return (List<Profesor>) coleccionProfesores.find().into(new ArrayList<>());
    }
    public void actualizarProfesor(String email, double nuevaCalificacion) {
        Bson filtro = Filters.eq("email", email);
        Bson actualizacion = Updates.set("rating", nuevaCalificacion);
        coleccionProfesores.updateOne(filtro, actualizacion);
    }
    public List<Profesor> buscarPorRangoEdad(int minEdad, int maxEdad) {
        Bson filtro = Filters.and(
                Filters.gte("age", minEdad), // Mayor o igual que minEdad
                Filters.lte("age", maxEdad)  // Menor o igual que maxEdad
        );
        return (List<Profesor>) coleccionProfesores.find(filtro).into(new ArrayList<>());
    }
}
