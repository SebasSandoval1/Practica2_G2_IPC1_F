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

public class CargaProfesores {

    public static int id[] = new int[21];
    public static int registro[] = new int[21];
    public static String nombre[] = new String[21];
    public static String fechaNacimiento[] = new String[21];
    public static String fechaContrato[] = new String[21];
    public static String genero[] = new String[21];
    public static String Lineasdocumento[];
    public static String Guardadofecha;
    static String[] error = new String[20];

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

                        id[i] = Integer.parseInt(filas[j]);

                    }
                    if (j == 1) {

                        registro[i] = Integer.parseInt(filas[j]);

                    }
                    if (j == 2) {

                        nombre[i] = filas[j];

                    }
                    if (j == 3) {

                        fechaNacimiento[i] = filas[j];

                    }
                    if (j == 4) {

                        fechaContrato[i] = filas[j];

                    }
                    if (j == 5) {

                        genero[i] = filas[j];

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

        Date fecha = new Date();
        SimpleDateFormat formatodefecha = new SimpleDateFormat("dd/MM/YYYY");

        Guardadofecha = formatodefecha.format(fecha);

        System.out.println(Guardadofecha);

    }

}
