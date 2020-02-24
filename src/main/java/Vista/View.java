package Vista;

import java.util.Scanner;

public class View {

    public View() {
        init();
    }

   public static void init () {

      Scanner in = new Scanner (System.in);
        int select=0;
        System.out.println("1-Empleado");
        System.out.println("2-Empresa");
        System.out.println("3-Portatil"); 
        select = in.nextInt();
        switch(select){
            case 1:
                Empleado();
                break;
            case 2:

                Empresa();
                break;
            case 3:
                Portatil();
                break;
            default:
                System.out.println("Numero Erronio");

        }
    }

    public void messageErrorDefault(String text) {

        System.out.println(text);

    }

}
