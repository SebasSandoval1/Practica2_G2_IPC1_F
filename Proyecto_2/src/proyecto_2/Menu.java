package proyecto_2;

import java.util.Scanner;

public class Menu {

    Scanner opcion = new Scanner(System.in);
    //llamado de clases 
    Login llamado = new Login();
    //variable privada para el menu de las clases
    private int eleccion;
    private boolean menu;

    //clase menu para los admin
    public void MenuAdmin() {

        System.out.println("==== Elija una de las siguientes opciones: ");
        System.out.println("|1.|Carga de alumnos.");
        System.out.println("|2.|Carga de Profesores.");
        System.out.println("|3.|Carga de Cursos.");
        System.out.println("|4.|Asignar alumnos.");
        System.out.println("|5.|Adignar Profesores.");
        System.out.println("|6.|Carga de Notas.");
        System.out.println("|7.|Agregar Usuarios al sistema.");
        System.out.println("|8.|Cerrar secion.");
        eleccion = opcion.nextInt();

        switch (eleccion) {

            case 1:
                CargaAlumno carga = new CargaAlumno();
                carga.MetodoCarga();
                llamado.Ingreso();
                ;
                break;
            case 2:
                CargaProfesores subir = new CargaProfesores();
                subir.MetodoCarga();
                llamado.Ingreso();
                
                ;
                break;
            case 3:
                CargaCursos cursos = new CargaCursos();
                cursos.MetodoCarga();
                llamado.Ingreso();
                ;
                break;
            case 4:
                AsiganrAlumnos asig = new AsiganrAlumnos();
                asig.MetodoCarga();
                llamado.Ingreso();
                
                ;
                break;
            case 5:;
                break;
            case 6:
                
                CargarNotas uwu = new CargarNotas();
                uwu.MetodoCarga();
                
                ;
                break;
            case 7:
                
                AgregarUsuario entrada = new AgregarUsuario();
                
                entrada.Creacion();
                
                ;
                break;
            case 8:
                llamado.Ingreso();
                ;
                break;
            default:
                System.out.println("No ingreso una opcion valida.");
                ;
                break;
        }

    }

    public void MenuUsuario() {

        System.out.println("==== Elija una de las siguientes opciones: ");
        System.out.println("|1.|Reporte de alumnos.");
        System.out.println("|2.|Reporte de Profesores.");
        System.out.println("|3.|Reporte de Asignasion de alumnos.");
        System.out.println("|4.|Reporte de asignación de profesores.");
        System.out.println("|5.|Reporte general de cursos.");
        System.out.println("|6.|Reporte de un curso específico");
        System.out.println("|7.|TOP 5 mejores alumnos de un curso");
        System.out.println("|8.|Reporte de alumnos");
        System.out.println("|9.|Cerrar secion.");
        eleccion = opcion.nextInt();

        switch (eleccion) {

            case 1:;
            Reportes marielos = new Reportes();
            marielos.Alumnos();
                break;
            case 2:;
                break;
            case 3:
                Reportes marielos2 = new Reportes();
                marielos2.ReporteAsignacionAlumnos();
                ;
                break;
            case 4:;
                break;
            case 5:
                
                ;
                break;
            case 6:
                CargarNotas uwu = new CargarNotas();
                uwu.CargadeNotas();
                
                ;
                break;
            case 7:;
                break;
            case 8:;
                break;
            case 9:llamado.Ingreso();
                ;
                break;
            default:
                System.out.println("No ingreso una opcion valida.");
                ;
                break;
        }

    }

}
