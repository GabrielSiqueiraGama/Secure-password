package zhant.securepassword.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {
	
    @Autowired
    private MessageSource messageSource;

    private String getMessage(String key) {
        return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    }

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
			failures.add(getMessage("password.uppercase"));
		}
	}

	
	private void validateLowercaseLetter(String password, List<String> failures) {
		if(!Pattern.matches(".*[a-z].*", password)) {
			failures.add(getMessage("password.lowercase"));
		}
	}
	
	private void validateNumber(String password, List<String> failures) {
		if(!Pattern.matches(".*[0-9].*", password)) {
			failures.add(getMessage("password.number"));
		}
	}
	
	private void validateEspecialCaracter(String password, List<String> failures) {
		if(!Pattern.matches(".*[\\W].*", password)) {
			failures.add(getMessage("password.special"));
		}
	}
	
	private void validateIsNotNull(String password, List<String> failures) {
		if(password == null || password == "" || password.isEmpty()) {
			failures.add(getMessage("password.null"));
		}
	}

	private void validateLength(String password, List<String> failures) {
		if(password.length() < 8) {
			failures.add(getMessage("password.length"));
		}
	}
	
}
