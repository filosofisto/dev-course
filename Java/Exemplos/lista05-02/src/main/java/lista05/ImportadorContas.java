package lista05;

public class ImportadorContas extends ImportadorGenerico<Conta> {

    public void customizarItem(Conta item) {
        item.setSaldo(item.getSaldo()/100);
    }
}
