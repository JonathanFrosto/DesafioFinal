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

route: /api/producer/register


![createProducer]( https://github.com/JonathanFrosto/DesafioFinal/blob/main/img/create%20producer.jpg )


### **Create performer**

route: /api/performer/register


![createPerformer](https://github.com/JonathanFrosto/DesafioFinal/blob/main/img/create%20performer.jpg)


### **Create reservation**

route: /api/reservation/register

basic auth

![Createreservation](https://github.com/JonathanFrosto/DesafioFinal/blob/main/img/create%20reservation.jpg)

### **Get ReservationProducer**


route: /api/reservation/producer/{id}


![GetReservationProducer](https://github.com/JonathanFrosto/DesafioFinal/blob/main/img/Get%20ReservationProducer.jpg)

### **Get ReservationPerformer**

route: /api/reservation/performer/{id}


![GetReservationPerformer](https://github.com/JonathanFrosto/DesafioFinal/blob/main/img/Get%20ReservationPerformer.jpg)

### **Get All Performers By**

route: /api/performer/getAllBy?status={boolean}&stars={double}&salary={double}


![GetAllPerformersBy](https://github.com/JonathanFrosto/DesafioFinal/blob/main/img/Get%20All%20Performers%20By.jpg)

### **Reservation Dashboard**

route: /api/reservation/dashboard/{id}


![ReservationDashboard](https://github.com/JonathanFrosto/DesafioFinal/blob/main/img/Reservation%20Dashboard.jpg)

### **Search Performer By**

route: /api/performer/searchPerformerBy?budget={double}&genre={String}&quantity={int}&date={LocalDateTime ex: 2018-07-14T17:45:55.9483536}


![SearchPerformerBy](https://github.com/JonathanFrosto/DesafioFinal/blob/main/img/search%20Performer%20By.jpg)
