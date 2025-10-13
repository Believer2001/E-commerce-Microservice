<h1>Application de E-commerce Avec architecture microservice</h1>


<h2>Introduction</h2>
<p>
</p>

<h2> Les différents microservices</h2>
<ul>
<li>Service Utilisateur : Gère l'authentification, l'inscription et la gestion
</li>
</ul>

<h2>Technologies Utilisées</h2>

<h3>1. Customers Service</h3>

- Creation :
<p>
on crée un projet spring boot avec les dépendances suivants:
<ul>
<li>Spring web</li>
<li>Spring Data JPA</li>
<li>H2 Database</li>
<li>Spring Data Rest</li>
<li>Spring Boot DevTools</li>
<li>Lombok</li>
<li>Spring Boot Actuator</li>
<li>Spring cloud Eureka client</li>
<li> Spring cloud cloud configuration</li>
</ul>

Les trois dernieres dependancec sont pour la mise en placae du microservice discovery et la configuration centralisée. Quant aux restes il sont juste pour
la misev en placec d un projet spring boot classique.
</p>

<h4>execution de customers service</h4>

![image](./images/customer/img1.png)

![image](./images/customer/img2.png)

![image](./images/customer/img3.png)

- l'API avec  une serilistion contenant Id.
par defaut  lorsqu on a utiliser Spring data rest  pour la sérialisation des entités, les IDs de la classe sont ignorées par defaut , pour la definir on definit une classe de configuration  pour définir les attributs à serialiser :

[classe de configuration ](./customer-service/src/main/java/enset/ma/customerservice/config/RestRepositoryConfig.java)

![img_1.png](./images/customer/img4.png)

-  Création d'une projection :
Par defaut,  tous les attributs sont envoyer au client lorsqu'on utilise  spring data rest, Pour donner la possiblité au client de pouvoir choisir les attributs lors des requetes, on utilise les projections. Ainsi nous avons crée trois différentes projections pour l'entité Customer.
   - all : pour  envoyer tous les attributs
   - name : pour envoyer juste le nom 
   - email : pour envoyer juste l'email
 Cette projection est definit le package entiti : [all](./customer-service/src/main/java/enset/ma/customerservice/entities/CustomerProjection.java) ,
     [name](./customer-service/src/main/java/enset/ma/customerservice/entities/EmailProjection.java)





