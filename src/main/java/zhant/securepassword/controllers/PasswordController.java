package zhant.securepassword.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import zhant.securepassword.services.PasswordService;

@RestController
public class PasswordController {

	@Autowired
	private PasswordService passwordService;
	
	@PostMapping(value="/validate-password")
	public ResponseEntity<FailureResponse> validatePassword(@RequestBody BodyRequest request){//Retorna o erro, caso não tenha erro e a senha esteja valida, vai apenas retornar sem conteudo.
		
		var failures = passwordService.listOfFails(request.password());
		if(failures.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.badRequest().body(new FailureResponse(failures));// retorna badrequest mostrando a lista de falhas.
	}
}
