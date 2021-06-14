package proyecto_2;

import java.util.Scanner;

public class Login {

    Scanner leer = new Scanner(System.in);
    //llamado clase menu

    //variables privadas del login para entrar
    private String usuario;
    private String password;

    //clase de ingreso
    public void Ingreso() {

        System.out.println("===========Bienvenido!===========");

        int c1 = 0;
        int c2 = 1;

        while (c1 != c2) {
            System.out.println("Ingrese su usuario:");
            usuario = leer.next();
            System.out.println("Ingrese su contraseña");
            password = leer.next();
            if (usuario.equals("admin") && password.equals("admin")) {
                Menu entrada = new Menu();
                entrada.MenuAdmin();

            } else {

                for (int i = 0; i < 5; i++) {

                    if (usuario.equals(AgregarUsuario.usuario[i]) && password.equals(AgregarUsuario.password[i])) {

                        Menu entrada = new Menu();
                        entrada.MenuUsuario();
                    }
                }
                //pide los datos en forma de error
                System.out.println("Usuario o contraseña invalida.");
                System.out.println("Ingrese su usuario:");
                usuario = leer.next();
                System.out.println("Ingrese su contraseña");
                password = leer.next();

                for (int i = 0; i < 5; i++) {
                    if (usuario.equals(AgregarUsuario.usuario[i]) && password.equals(AgregarUsuario.password[i])) {
                        c1 = 1;
                        c2 = 1;
                        Menu entrada = new Menu();
                        entrada.MenuUsuario();
                    }

                }
            }

        }

    }

}
