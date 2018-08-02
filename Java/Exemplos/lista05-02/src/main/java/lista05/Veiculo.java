package lista05;

public class Veiculo {

    @Substring(inicio = 0, fim = 8)
    private String placa;

    @Substring(inicio = 9, fim = 22)
    private String modelo;

    @Substring(inicio = 24, fim = 34)
    private String marca;

    @Substring(inicio = 35, fim = 39)
    private String ano;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", ano='" + ano + '\'' +
                '}';
    }
}
