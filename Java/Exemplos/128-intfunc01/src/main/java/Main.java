public class Main {

    public static void main(String[] args) {
        String cpf = "816.466.749-87";

        ValidatorCPF validatorCPF = new ValidatorCPF();

        if (validatorCPF.accept(cpf)) {
            System.out.println("CPF valido");
        } else {
            System.out.println("CPF invalido");
        }

        /*Validator<String> validatorCPFLambda = valor -> valor != null
                        && valor.matches("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}");

        if (validatorCPFLambda.accept(cpf)) {
            System.out.println("CPF valido");
        } else {
            System.out.println("CPF invalido");
        }*/
    }
}
