package DAO;

import com.mongodb.client.MongoCollection;
import database.MongoDBConnection;
import model.Alumno;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.*;

public class AlumnoDAO {
    MongoCollection coleccionAlumnos;
    public AlumnoDAO(){
        coleccionAlumnos=new MongoDBConnection().getAlumnosCollecion();
    }
    public void insertarAlumno(Alumno alumno){
        Document document=new Document().append("rating",alumno.getRating())
                .append("age",alumno.getAge())
                .append("name",alumno.getName())
                .append("gender",alumno.getGender())
                .append("email",alumno.getEmail())
                .append("calificaation",alumno.getCalificaation())
                .append("higher_grade",alumno.getHigher_grade());
        coleccionAlumnos.insertOne(document);

    }
    public List<Alumno> obtenerTodos() {
        return (List<Alumno>) coleccionAlumnos.find().into(new ArrayList<>());
    }
    public Alumno buscarPorEmail(String email) {
        return (Alumno) coleccionAlumnos.find(eq("email", email)).first();
    }
    public void eliminarPorCalificacion(int calificacionMinima) {
        coleccionAlumnos.deleteMany(lt("calificaation", calificacionMinima));
    }
}
