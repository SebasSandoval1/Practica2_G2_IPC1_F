package proyecto_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AsiganrAlumnos {

    public static int idAlumno[] = new int[201];
    public static int idCurso[] = new int[201];
    public static String Lineasdocumento[];
    public static String Guardadofecha;
    public static int[][] datosporalumno = new int[101][16];
    static String[] error = new String[20];
    //public static int[] idAlumnoIdentificado;
    //public static int[] idACursoIdentificado;

    public static String getContentOfFile(String pathname) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(pathname);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            // Lectura del fichero
            String content = "";
            String linea;
            while ((linea = br.readLine()) != null) {
                content += linea + "\n";
            }
            return content;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    public static void addToEndFile(String pathname, String data) {
        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter(pathname, true); // True indica que se va a agregar datos al final
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            // Escribe los datos en el archivo
            bfwriter.write(data);
            bfwriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void MetodoCarga() {

        String ruta;

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese la ruta de archivo");
        ruta = leer.nextLine();
        String contenido = getContentOfFile(ruta);
        System.out.println("");
        Lineasdocumento = contenido.split("\n");

        try {
            for (int i = 1; i < Lineasdocumento.length; i++) {

                String Linea = Lineasdocumento[i].trim();
                String[] filas = Linea.split(";");
                for (int j = 0; j < filas.length; j++) {

                    if (j == 0) {

                        idAlumno[i] = Integer.parseInt(filas[j].trim());

                    }

                    if (j == 1) {

                        idCurso[i] = Integer.parseInt(filas[j].trim());

                    }

                }

            }
        } catch (Exception e) {
            for (int i = 0; i < 20; i++) {
                if (error[i] != null) {
                    addToEndFile("logs.log", "\n\n" + "Esto es un error: " + error[i]);
                }

            }

        }

        System.out.println(contenido);

        Date fecha = new Date();
        SimpleDateFormat formatodefecha = new SimpleDateFormat("dd/MM/YYYY");
        System.out.println("");
        Guardadofecha = formatodefecha.format(fecha);

        System.out.println(Guardadofecha);

    }

    //C:\Users\lopez\Desktop\.csv
    public void DatosAsignados() {
        /*
        for (int i = 1; i < CargaAlumno.Lineasdocumento.length; i++) {
             for (int j = 0; j < Lineasdocumento.length; j++) {
                if (CargaAlumno.id[i] == idAlumno[j]) {
                    datosporalumno[i][0] = idAlumno[j]; 
                }
            }
            
        }*/

        for (int i = 1; i < CargaAlumno.Lineasdocumento.length; i++) { //i=1
            int cont = 0;
            for (int j = 1; j < Lineasdocumento.length; j++) { //j=2
                if (CargaAlumno.id[i] == idAlumno[j]) {
                    // idAlumnoIdentificado[i] = idAlumno[j];
                    datosporalumno[i][cont] = idCurso[j];
                    cont++;

                }
            }
        }
        for (int i = 1; i < Lineasdocumento.length; i++) {
            for (int j = 0; j < Lineasdocumento.length; j++) {
                if (datosporalumno[i][0] != 0) {

                    System.out.print("" + datosporalumno[i][j]);
                }

            }
            System.out.println("");
        }

    }

}
