public class Cliente {
    int ID_Cliente;
    public Cliente(int ID_Cliente)
    {
        this.ID_Cliente = ID_Cliente;
    }

    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public int getID_Cliente() {
        return ID_Cliente;
    }

    @Override

    public String toString()
    {
        String clientID = "Cliente "+String.valueOf(ID_Cliente) + "  ";
        return clientID;
    }



    
}
