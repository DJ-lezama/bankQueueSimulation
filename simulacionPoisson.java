import java.util.LinkedList;
import java.util.Queue;
import java.util.*;


public class simulacionPoisson {

    public static void PrintFila (Queue<Cliente> fila) {

        String filaClientes = " ";
        for (Cliente cliente : fila) {
            filaClientes += cliente.toString();
        }

        System.out.println("\n "+filaClientes);
    }

    public static boolean AllFinished(List<Caja> cajas)
    {
        for (Caja caja: cajas)
            {
                if (caja.Tiempo != 0)
                {
                    return false;
                }
            }

        return true;
    }

    public static void main(String[] args) {

        Queue<Cliente> queue  = new LinkedList<Cliente>();
        List<Caja> cajas = new LinkedList<Caja>();
        poissonRandom newPoissonRandom = new poissonRandom();
        int counterClientes = 0;

        for (int i = 0; i < 4 ; i++) //4 cajas
        {
            cajas.add(new Caja(i));
        } 


        int j = 0;
        int horas = 0;
        while (true){

            if (j%4 == 0 && j<=8*4 && j != 0)
            {
                horas ++;
                int arrivals = newPoissonRandom.poissonRandom(5);
                System.out.println("LLegaron "+ arrivals + " clientes.");
                for (int i = 0; i <arrivals; i++) //fila de máximo 10 personas 
                {
                    queue.add(new Cliente(counterClientes));
                    counterClientes += 1;
                }
            }

            System.out.println("Han pasado " + j + " unidades de tiempo con " + horas + " horas (4 u = 1 Hora)");

            PrintFila(queue);
            
            for (Caja caja : cajas) {

                System.out.println(caja.toString());

                if (caja.Atendiendo() && queue.size() > 0)
                {
                    caja.getNewClient(queue.remove().ID_Cliente);
                }
            }

            j += 1;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print("\033[H\033[2J"); 

           
            if (AllFinished(cajas) && horas >= 8  && queue.size() == 0){
                System.out.println("FIN");
                break;
            }
        }

        for (Caja caja: cajas)
        {
            System.out.println(caja.toString());
        }
    }  
}