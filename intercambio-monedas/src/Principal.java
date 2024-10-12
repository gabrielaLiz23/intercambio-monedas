import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConsultaApi consulta = new ConsultaApi();
        String moneda_base;
        String moneda_convertida;
        int op;
        Scanner lectura = new Scanner(System.in);
        try{
            do{
                System.out.println("************************************************");
                System.out.println("¡Sea Bienvenida/o al conversor de moneda!");
                System.out.println(" ");
                System.out.println("1) Dólar =>> Peso Argentino");
                System.out.println("2) Peso Argentino =>> Dólar");
                System.out.println("3) Dólar =>> Real Brasileño");
                System.out.println("4) Real brasileño =>> Dólar");
                System.out.println("5) Dólar =>> Peso Colombiano");
                System.out.println("6) Peso Colombiano =>> Dólar");
                System.out.println("7) Salir");
                System.out.println("Elija una opción válida: ");
                System.out.println("************************************************");

                op = lectura.nextInt();
                switch(op) {
                    case 1:
                        moneda_base = "USD";
                        moneda_convertida = "ARS";
                        consulta.calcularCambio(moneda_base, moneda_convertida, lectura);
                        break;
                    case 2:
                        moneda_base = "ARS";
                        moneda_convertida = "USD";
                        consulta.calcularCambio(moneda_base, moneda_convertida, lectura);
                        break;
                    case 3:
                        moneda_base = "USD";
                        moneda_convertida = "BRL";
                        consulta.calcularCambio(moneda_base, moneda_convertida, lectura);
                        break;
                    case 4:
                        moneda_base = "BRL";
                        moneda_convertida = "USD";
                        consulta.calcularCambio(moneda_base, moneda_convertida, lectura);
                        break;
                    case 5:
                        moneda_base = "USD";
                        moneda_convertida = "COP";
                        consulta.calcularCambio(moneda_base, moneda_convertida, lectura);
                        break;
                    case 6:
                        moneda_base = "COP";
                        moneda_convertida = "USD";
                        consulta.calcularCambio(moneda_base, moneda_convertida, lectura);
                        break;
                    case 7:
                        System.out.println("Salió del programa.");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            }while(op != 7);

        } catch (InputMismatchException e) {
            System.out.println("El valor ingresado no es una cantidad numérica");
            lectura.next();  // Limpiar el valor inválido del buffer
        }

    }
}
