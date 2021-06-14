package proyecto_2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Reportes {

    public static String reporte;

    //crea el archivo en disco, recibe como parámetro la lista de estudiantes
    public static void createFile(String pathname) {
        FileWriter flwriter = null;
        try {
            //crea el flujo para escribir en el archivo
            flwriter = new FileWriter(pathname);
            //crea un buffer o flujo intermedio antes de escribir directamente en el archivo
            BufferedWriter bfwriter = new BufferedWriter(flwriter);

            // Escribe los datos en el archivo
            bfwriter.write(reporte);

            //cierra el buffer intermedio
            bfwriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {//cierra el flujo principal
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //body
    public static String generateHTMLForMat(String[][] mat) {
        String tabla = "<table>";

        for (int i = 0; i < mat.length; i++) {
            String row = "<tr>";
            for (int j = 0; j < mat[0].length; j++) {

                row += "<td>" + mat[i][j] + "</td>";

            }
            row += "</tr>";
            tabla += row;
        }
        tabla += "</table>";

        return tabla;
    }

    public void Alumnos() {

        // TODO code application logic here
        int cont = 0;
        for (int i = 1; i < CargaAlumno.id.length; i++) {
            if (CargaAlumno.id[i] != 0) {
                cont++;
            }
        }
        String[][] mat = new String[cont][4];
        mat[0][0] = "Carne";
        mat[0][1] = "Nombre";
        mat[0][2] = "Edad";
        mat[0][3] = "Genero";

        for (int i = 1, conta = 1; i < mat.length; conta++, i++) {
            if (CargaAlumno.id[conta] == 0) {
                conta++;
            }
            for (int j = 0; j < 4; j++) {

                if (j == 0) {

                    mat[i][j] = String.valueOf(CargaAlumno.carnet[conta]);

                }
                if (j == 1) {

                    mat[i][j] = CargaAlumno.nombre[conta];
                }
                if (j == 2) {
                    mat[i][j] = String.valueOf(CargaAlumno.edad[conta]);
                }
                if (j == 3) {
                    mat[i][j] = CargaAlumno.genero[conta];
                }

            }
        }

        String nombreReporte = "Reporte DE Alumnos";
        String htmlBody = generateHTMLForMat(mat);
        System.out.println(htmlBody);
        reporte = "<html><head><link rel=\"stylesheet\"href=\"css/styles.css\"><title>Reporte</title><h1>" + nombreReporte + "</h1>"
                + "</head><body>" + htmlBody + "</body></html>";

        createFile("C:\\Users\\lopez\\Desktop\\reporte.html");
        System.out.println("Reporte generado exitosamente ");

    }

    public void ReporteAsignacionAlumnos() {
    }

    public void AsignacionProfesores() {

    }

    public void ReporteGeneralCursos() {
        
        
    }

    public void Reportecursoespecifico() {
    }

    public void Top5() {
    }

}
