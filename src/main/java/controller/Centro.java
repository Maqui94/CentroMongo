package controller;

import DAO.AlumnoDAO;
import DAO.ProfesorDAO;
import com.mongodb.client.MongoCollection;
import database.MongoDBConnection;
import model.Alumno;
import model.Profesor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Centro {
    AlumnoDAO alumnoDAO=new AlumnoDAO();
    ProfesorDAO profesorDAO=new ProfesorDAO();

    public void insertarAlumno() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el rating: ");
        double rating = scanner.nextDouble();
        System.out.print("Introduce el nombre: ");
        String name = scanner.next();
        System.out.print("Introduce la edad: ");
        int age = scanner.nextInt();
        System.out.print("Introduce el género: ");
        String gender = scanner.next();
        System.out.print("Introduce el telefono: ");
        String phone = scanner.next();
        System.out.print("Introduce el email: ");
        String email = scanner.next();
        System.out.print("Introduce la calificación: ");
        int calificaation = scanner.nextInt();
        System.out.print("Introduce Estudios más altos ");
        String higher_grade = scanner.next();

        Alumno alumno = new Alumno(rating, age,name, gender, email,phone, calificaation, higher_grade);
        alumnoDAO.insertarAlumno(alumno);
        System.out.println("Usuario insertado con éxito.");
    }
    public void insertarProfesor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el rating: ");
        double rating = scanner.nextDouble();
        System.out.print("Introduce el nombre: ");
        String name = scanner.next();
        System.out.print("Introduce la edad: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Introduce el género: ");
        String gender = scanner.nextLine();

        System.out.print("Introduce el teléfono: ");
        String phone = scanner.nextLine();

        System.out.print("Introduce el email: ");
        String email = scanner.nextLine();

        System.out.print("Introduce las asignaturas (separadas por comas): ");
        String[] subjects = scanner.nextLine().split(",");

        System.out.print("Introduce estudios más altos: ");
        String higher_grade = scanner.nextLine();

        Profesor profesor = new Profesor(rating, age,name, gender, email,phone, List.of(subjects), higher_grade);
        profesorDAO.insertarProfe(profesor);
        System.out.println("Usuario insertado con éxito.");
    }
    public void mostrarTodos() {
        List<Profesor> profesores = profesorDAO.obtenerTodos();
        List<Alumno> alumnos = alumnoDAO.obtenerTodos();
        System.out.println("=== Profesores ===");
        profesores.forEach(System.out::println);
        System.out.println("=== Alumnos ===");
        alumnos.forEach(System.out::println);
    }

    public void mostrarProfesores() {
        List<Profesor> profesores = profesorDAO.obtenerTodos();
        profesores.forEach(System.out::println);
    }

    public void mostrarAlumnos() {
        List<Alumno> alumnos = alumnoDAO.obtenerTodos();
        alumnos.forEach(System.out::println);
    }
    public void buscarAlumno() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el email del alumno: ");
        String email = scanner.nextLine();
        Alumno alumno = alumnoDAO.buscarPorEmail(email);
        System.out.println(alumno != null ? alumno : "Alumno no encontrado.");
    }
    public void buscarProfesor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el rango de edad (min y max separados por espacio): ");
        int min = scanner.nextInt();
        int max = scanner.nextInt();
        List<Profesor> profesores = profesorDAO.buscarPorRangoEdad(min, max);
        profesores.forEach(System.out::println);
    }

    public void actualizarProfesor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el email del profesor: ");
        String email = scanner.nextLine();
        System.out.print("Introduce el nuevo rating: ");
        double nuevaCalificacion = scanner.nextDouble();
        profesorDAO.actualizarProfesor(email, nuevaCalificacion);
        System.out.println("Profesor actualizado con éxito.");
    }

    public void darDeBajaAlumnos() {
        alumnoDAO.eliminarPorCalificacion(5);
        System.out.println("Alumnos dados de baja con éxito.");
    }
    public void menu(){
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("===== MENÚ PRINCIPAL =====");
            System.out.println("1. Insertar Alumno");
            System.out.println("2. Insertar Profesor");
            System.out.println("3. Mostrar Todos");
            System.out.println("4. Mostrar Profesores");
            System.out.println("5. Mostrar Alumnos");
            System.out.println("6. Buscar Alumno");
            System.out.println("7. Buscar Profesor");
            System.out.println("8. Actualizar Profesor");
            System.out.println("9. Dar de Baja Alumnos");
            System.out.println("10. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1 -> insertarAlumno();
                case 2 -> insertarProfesor();
                case 3 -> mostrarTodos();
                case 4 -> mostrarProfesores();
                case 5 -> mostrarAlumnos();
                case 6 -> buscarAlumno();
                case 7 -> buscarProfesor();
                case 8 -> actualizarProfesor();
                case 9 -> darDeBajaAlumnos();
                case 10 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
            }

            System.out.println();
        } while (opcion != 10);
    }
    }

