public class ValidatorCPF implements Validator<String> {

    public boolean validate(String cpf) {
        return cpf != null && cpf.matches("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}");
    }
}
