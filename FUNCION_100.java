import java.util.Scanner;

public class Main3 {
    public static String[] nombre = new String[100];
    public static float[] sueldo = new float[100];
    public static String[] cargo = new String[100];
    public static int contador = 0; 
    public static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion = 0;

        do {
            System.out.println("\n--- MENU DE EMPLEADOS ---");
            System.out.println("1. Registrar empleado");
            System.out.println("2. Ver todos los empleados");
            System.out.println("3. Modificar empleado ");
            System.out.println("4. Eliminar empleado");
            System.out.println("5. Salir");
            System.out.print("Elija una opcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine(); 

            switch (opcion) {
                case 1:
                    registrarEmpleado();
                    break;
                case 2:
                    verTodosLosDatos();
                    break;
                case 3:
                    actualizarEmpleado();
                    break;
                case 4:
                    eliminarEmpleado();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 5);
    }

    //Registra un nuevo empleado en la posicion actual
    public static void registrarEmpleado() {
        if (contador < 100) {
            System.out.println("\n--- Registrar Empleado #" + contador + " ---");
            System.out.print("Ingrese el nombre completo: ");
            nombre[contador] = entrada.nextLine();

            System.out.print("Escriba el cargo: ");
            cargo[contador] = entrada.nextLine();

            System.out.print("Ingrese el sueldo: ");
            sueldo[contador] = entrada.nextFloat();
            entrada.nextLine(); 

            contador++;
            System.out.println("Empleado guardado con exito.");
        } else {
            System.out.println("El arreglo esta lleno (maximo 100).");
        }
    }

    //Muestra los datos de una posición y su descuento EPS
    public static void verDatos(int nroEmpleado) {
        System.out.println("Posicion [" + nroEmpleado + "]");
        System.out.println("Nombre: " + nombre[nroEmpleado]);
        System.out.println("Cargo: " + cargo[nroEmpleado]);
        System.out.println("Sueldo: " + sueldo[nroEmpleado]);
        System.out.println("Descuento EPS: " + descuentoEPS(sueldo[nroEmpleado]));
        System.out.println("-----------------------------");
    }

    // Muestra todos los empleados registrados hasta el momento
    public static void verTodosLosDatos() {
        if (contador == 0) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        for (int i = 0; i < contador; i++) {
            verDatos(i);
        }
    }

    //Cambia los datos de una posicion seleccionada
    public static void actualizarEmpleado() {
        System.out.print("Ingrese la posicion a modificar (0 a " + (contador - 1) + "): ");
        int pos = entrada.nextInt();
        entrada.nextLine();

        if (pos >= 0 && pos < contador) {
            System.out.print("Nuevo nombre: ");
            nombre[pos] = entrada.nextLine();

            System.out.print("Nuevo cargo: ");
            cargo[pos] = entrada.nextLine();

            System.out.print("Nuevo sueldo: ");
            sueldo[pos] = entrada.nextFloat();
            entrada.nextLine();

            System.out.println("Datos actualizados.");
        } else {
            System.out.println("Posicion no valida.");
        }
    }

    //Reorganiza las posiciones desplazando los datos a la izquierda
    public static void eliminarEmpleado() {
        System.out.print("Ingrese la posicion a eliminar (0 a " + (contador - 1) + "): ");
        int pos = entrada.nextInt();
        entrada.nextLine();

        if (pos >= 0 && pos < contador) {
            for (int i = pos; i < contador - 1; i++) {
                nombre[i] = nombre[i + 1];
                cargo[i] = cargo[i + 1];
                sueldo[i] = sueldo[i + 1];
            }
            contador--;
            System.out.println("Empleado eliminado.");
        } else {
            System.out.println("Posicion no valida.");
        }
    }

    // Calculo del 17% de EPS como en tu codigo original
    public static float descuentoEPS(float sueldo) {
        return (float) (sueldo * 0.17);
    }
}
