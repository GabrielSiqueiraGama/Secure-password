package zhant.securepassword.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class PasswordService {

	public List<String> listOfFails(String password){
		List<String> failures = new ArrayList<String>();
		
		validateIsNotNull(password,failures);
		if (!failures.isEmpty()) {//Para não retornar exceção é preciso já retornar a badrequest, se não dar erro no servidor
			return failures;
		}
		validateLength(password, failures);
		validateUppercaseLetter(password, failures);
		validateLowercaseLetter(password, failures);
		validateNumber(password, failures);
		validateEspecialCaracter(password, failures);
		
		
		return failures;
	}

	private void validateUppercaseLetter(String password, List<String> failures) {
		if(!Pattern.matches(".*[A-Z].*", password)) {
			failures.add("A senha deve conter pelo menos uma letra maiuscula.");
		}
	}
	
	private void validateLowercaseLetter(String password, List<String> failures) {
		if(!Pattern.matches(".*[a-z].*", password)) {
			failures.add("A senha deve conter pelo menos uma letra minuscula.");
		}
	}
	
	private void validateNumber(String password, List<String> failures) {
		if(!Pattern.matches(".*[0-9].*", password)) {
			failures.add("A senha deve conter pelo menos um numero.");
		}
	}
	
	private void validateEspecialCaracter(String password, List<String> failures) {
		if(!Pattern.matches(".*[\\W].*", password)) {
			failures.add("A senha deve conter pelo menos um caractere especial.");
		}
	}
	
	private void validateIsNotNull(String password, List<String> failures) {
		if(password == null || password == "" || password.isEmpty()) {
			failures.add("A senha não pode ser nula.");
		}
	}

	private void validateLength(String password, List<String> failures) {
		if(password.length() < 8) {
			failures.add("Senha possui que menos 8 digitos.");
		}
	}
	
}
