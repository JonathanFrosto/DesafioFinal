# DesafioFinal
Desafio final Academia Java Junior - Gama Academy

**(Dependencies used in the project)**


**Dependências usadas no projeto:**

 - Spring WEB
 - Spring JPA
 - Spring security
 - H2 Database
 
## APIs 

### **Create producer**
Forneça nome, email e senha para criar um usuário.
**route: /api/producer/register**




![createProducer]( https://github.com/JonathanFrosto/DesafioFinal/blob/main/img/create%20producer.jpg )

```json
{
	"name":"Erico",
	"email":"erico@gmail.com",
	"password":"eri123"
}
```
    name: String
    email: String
    password: String


### **Create performer**
Forneça nome, email, senha, salário, avaliação do usuário (stars), se o usuário está disponível para contratação (status), ator ou atriz (gender), e os gêneros de atuação (genre).
**route: /api/performer/register**


![createPerformer](https://github.com/JonathanFrosto/DesafioFinal/blob/main/img/create%20performer.jpg)

```json
{
	"name":"Carminha",
	"email":"carminha@gmail.com",
	"password":"car123",
	"salary":2500,
	"stars":55.8,
	"status":true,
	"gender":"FEMALE",
	"genre": [
		"Romance",
		"Action"
	]
}
```
    name: String
    email: String
    password: String
	salary: Double
	stars: Double
	gender: "MALE" or "FEMALE"
	genre: Array of strings

### **Create reservation**
Crie uma novo contrato (reserva) entre um ator/atriz e um produtor.
**route: /api/reservation/register**

![Createreservation](https://github.com/JonathanFrosto/DesafioFinal/blob/main/img/create%20reservation.jpg)

```json
{
	"startDate":"2020-11-03T15:30:00.9483536",
	"finishDate":"2020-11-03T19:45:00.9483536",
	"emailProducer":"erico@gmail.com",
	"emailPerformer":"carminha@gmail.com"
}
```
    startDate: LocalDateTime
	finishDate: LocalDateTime
    emailProducer: String
    emailPerformer: String

### **Get ReservationProducer**
Receba uma lista com todas as reservas de um produtor passando seu id na rota.
**route: /api/reservation/producer/{id}**

![GetReservationProducer](https://github.com/JonathanFrosto/DesafioFinal/blob/main/img/Get%20ReservationProducer.jpg)

### **Get ReservationPerformer**
Receba uma lista com todas as reservas de um ator/atriz passando seu id na rota.
**route: /api/reservation/performer/{id}**

![GetReservationPerformer](https://github.com/JonathanFrosto/DesafioFinal/blob/main/img/Get%20ReservationPerformer.jpg)

### **Find performers by**
Rota no qual pode receber uma lista de ator/atriz filtrado por status, avaliação e salário.
**route: /api/performer/getAllBy?status={boolean}&stars={double}&salary={double}**

![GetAllPerformersBy](https://github.com/JonathanFrosto/DesafioFinal/blob/main/img/Get%20All%20Performers%20By.jpg)

### **Get performers for a show**
Rota no qual um produtor insere a data de inicio da sua obra, o gênero, o número de profissionais que precisa e o orçamento máximo e recebe uma lista dos atores e atrizes mais indicados.
**route: /api/performer/searchPerformerBy?budget={double}&genre={String}&quantity={int}&date={LocalDateTime ex: 2018-07-14T17:45:55.9483536}**

![SearchPerformerBy](https://github.com/JonathanFrosto/DesafioFinal/blob/main/img/search%20Performer%20By.jpg)

### **Reservation Dashboard**
Rota na qual vai passar o id do produtor e receber o número de reservas realizadas até o momento, datas com mais reservas e o atores/atrizes mais reservados daquele produtor.
**route: /api/reservation/dashboard/{id}**

![ReservationDashboard](https://github.com/JonathanFrosto/DesafioFinal/blob/main/img/Reservation%20Dashboard.jpg)
