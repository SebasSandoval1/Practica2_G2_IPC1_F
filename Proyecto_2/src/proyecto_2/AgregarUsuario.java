package proyecto_2;

import java.util.Scanner;

public class AgregarUsuario {

    public static String[] usuario = new String[5];
    public static String[] password = new String[5];
    public static int contador = 1;
    public static String newus;
    public static String newpas;
    public static String newpas2;

    public static void Creacion() {

        Scanner ingreso = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {

            if (usuario[i] == null) {

                System.out.println("Ingrese el nuevo usuario");
                newus = ingreso.nextLine();

                for (int j = 0; j < i; j++) {

                    if (newus.equals(usuario[j])) {
                        System.out.println("Este usuario ya existe!.");
                        System.out.println("Ingrese el nuevo usuario");
                        newus = ingreso.nextLine();
                    } else {
                        j = i;
                    }
                }
                usuario[i] = newus;

                int c1 = 0;
                int c2 = 1;
                System.out.println("Ingreso la contraseña: ");
                newpas = ingreso.nextLine();
                System.out.println("Confirmar contraseña: ");
                newpas2 = ingreso.nextLine();

                if (newpas2.equals(newpas)) {
                    password[i] = newpas;
                } else {
                    while (c1 != c2) {

                        System.out.println("ERROR:Las conntraseña no concuerdan. ");
                        System.out.println("Ingreso la contraseña: ");
                        newpas = ingreso.nextLine();
                        System.out.println("Confirmar contraseña: ");
                        newpas2 = ingreso.nextLine();
                        if (newpas2.equals(newpas)) {
                            c1 = c2;
                        }
                    }
                }

                Menu llamado = new Menu();
                llamado.MenuAdmin();

            }

        }
        int ev = 0;
        for (int i = 0; i < 5; i++) {

            if (usuario[i] != null) {

                ev++;

            }

        }

        if (ev == 5) {
            System.out.println("usuarios llenos ");
            Menu llamado = new Menu();
            llamado.MenuAdmin();
        }

    }

}
