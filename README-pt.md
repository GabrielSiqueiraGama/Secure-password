# Validador de Senhas Seguras

**API REST com Spring Boot** para validar senhas de acordo com requisitos de segurança comuns.  
Ela verifica se a senha atende às regras e retorna `204 No Content` para senha válida ou `400 Bad Request` para senha inválida, com uma lista mostrando as falhas.

Suporta **internacionalização (i18n)**.  
Definindo o header `Accept-Language` como `en` ou `pt`, as mensagens de erro serão retornadas em inglês ou português, respectivamente.

🌐 Idiomas disponíveis: [English](README.md) | [Português](README-pt.md)

---

## 📌 Funcionalidades
- API REST com um único endpoint: `/validate-password`
- Valida senhas de acordo com as seguintes regras:
  - Não pode ser nula ou vazia
  - Comprimento mínimo de **8 caracteres**
  - Pelo menos **uma letra maiúscula** (`A-Z`)
  - Pelo menos **uma letra minúscula** (`a-z`)
  - Pelo menos **um número** (`0-9`)
  - Pelo menos **um caractere especial** (`!@#$%^&*...`)

---

## ⚙️ Ferramentas
- Java
- Spring Boot

---

## 🚀 Executando o projeto

```bash
# Clone o repositório
git clone https://github.com/GabrielSiqueiraGama/Secure-password.git
cd secure-password
```
# Acesse aplicação Spring Boot
A API estará disponível em: POST http://localhost:8080/validate-password

Request body:
```bash
{
  "password": "YourPassword123!"
}
```


}

## 🛠️ Exemplo
```bash
http://localhost:8080/validate-password
  "Content-Type: application/json" \
  "Accept-Language: pt"
{
	"password": "Weak"
}

```

Response:
```bash
{
	"failures": [
		"Senha deve possuir pelo menos 8 digitos.",
		"A senha deve conter pelo menos um número.",
		"A senha deve conter pelo menos um caractere especial."
	]
}
```
