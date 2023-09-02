import java.util.Random;


public class Caja {
    int numCaja;
    int NumClientes;
    int clientesAtendidos;
    public int IDClienteActual;
    public int Tiempo;
    static Random rand = new Random();

    public int getIDClienteActual() {
        return IDClienteActual;
    }

    public void setIDClienteActual(int IDClienteActual) {
        this.IDClienteActual = IDClienteActual;
    }

    public Caja(int numCaja)
    {
        this.numCaja = numCaja;
        Tiempo = 0;
        
    }

    public void setNumCaja(int numCaja) {
        this.numCaja = numCaja;
    }

    public int getNumCaja() {
        return numCaja;
    }

    Boolean ocupada = false; 

    public Boolean getOcupada() {
        return ocupada;
    }

    public void setOcupada(Boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Boolean  Atendiendo()
    {
        if (Tiempo > 0)
        {
            Tiempo -= 1;
        }
        return Tiempo == 0;
    }

    public void getNewClient(int ID_Cliente){
        NumClientes += 1;
        Tiempo = rand.nextInt(1,11);

        IDClienteActual = ID_Cliente;
        clientesAtendidos += 1;
    }

    

    @Override
    public String toString()
    {
        String output = "\nCaja " + numCaja + " terminará de atender en " + Tiempo + " unidades de tiempo. El cliente atendido es el cliente " + IDClienteActual;
        if (Tiempo == 0)
        {
            output += " FIN ";
        }

    output +=  "\nNúmero de clientes atendidos: "+NumClientes;
        return output;
    }

    

}
