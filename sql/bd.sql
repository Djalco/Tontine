CREATE TABLE `user`(
	`id` 			VARCHAR(20) PRIMARY KEY,
	`login`			VARCHAR(100) NOT NULL,
	`firstname`		VARCHAR(100) NOT NULL,
	`lastname` 		VARCHAR(100) NOT NULL,
	`password` 		VARCHAR(100) NOT NULL,
	`mail` 			VARCHAR(100) NOT NULL,
	`phone` 		VARCHAR(100) NOT NULL,
	`role` 			int NOT NULL,
	`nb_person` 	int NOT NULL,
	`is_actif`  	int NOT NULL DEFAULT 1
);

CREATE TABLE `session`(
	`id` 			VARCHAR(20) PRIMARY KEY,
	`num_session` 	INT NOT NULL,
	`date_session` 	DATETIME NOT NULL,
	`is_actif`  	int NOT NULL DEFAULT 1
);

CREATE TABLE `ManagePayment`(
	`id` VARCHAR(20) PRIMARY KEY,
	`session` VARCHAR(20) NOT NULL,
	`user` VARCHAR(20) NOT NULL,
	`is_actif`  int NOT NULL DEFAULT 1,
	FOREIGN KEY (`user`) REFERENCES `user`(`id`),
	FOREIGN KEY (`session`) REFERENCES `session`(`id`)
);

CREATE TABLE `loan`(
	`id` VARCHAR(20) PRIMARY KEY,
	`amount` int NOT NULL,
	`session_sold` VARCHAR(20) NOT NULL,
	FOREIGN KEY (`id`) REFERENCES `ManagePayment`(`id`),
	FOREIGN KEY (`session_sold`) REFERENCES `session`(`id`)
);

CREATE TABLE `contribution`(
	`id` VARCHAR(20) PRIMARY KEY,
	`session_contributed` VARCHAR(20) NOT NULL,
	FOREIGN KEY (`id`) REFERENCES `ManagePayment`(`id`),
	FOREIGN KEY (`session_contributed`) REFERENCES `session`(`id`)
);

CREATE TABLE `sanction`(
	`id` VARCHAR(20) PRIMARY KEY,
	`infraction_payment` int NOT NULL,
	`session_start` VARCHAR(20) NOT NULL,
	`session_sold` VARCHAR(20) DEFAULT NULL,
	FOREIGN KEY (`session_start`) REFERENCES `session`(`id`),
	FOREIGN KEY (`session_sold`) REFERENCES `session`(`id`)
);

CREATE TABLE `setting`(
	`amount_cotisation` int,
	`type_payment_loan` VARCHAR(20),
	`amount_payment_loan` VARCHAR(20),
	`type_payment_infraction` VARCHAR(20),
	`amount_payment_infraction` VARCHAR(20)
);

/* Enregistrement*/

/* Table utilisateur*/
INSERT INTO `user` (`id`, `login`, `firstname`, `lastname`, `password`, `mail`, `phone`, `role`, `nb_person`) VALUES 
  ('usr-023-001', 'luffy', 'Luffy', 'Monkey D', '12345678', 'luffy@gmail.com', '6 90 18 53 35', 1, 3),
  ('usr-024-002', 'perona', 'Sama', 'Perona', 'Aqszaqsz0', 'perona@queen.com', '6 90 28 47 16', 1, 1),
  ('usr-024-3','Lyons','Lewis Ware','Brynn Oconnor','Aqszaqsz0#','mattis.cras@aol.ca','6 28 66 84 88',1,1),
  ('usr-024-4','Fisher','Baxter Cantu','William Mckenzie','Aqszaqsz0#','urna.nunc.quis@outlook.ca','6 33 22 58 82',1,1),
  ('usr-024-5','Oneal','Mira Cooper','Hayfa Brown','Aqszaqsz0#','in.dolor@outlook.com','6 11 87 73 69',1,2),
  ('usr-024-6','Welch','Ira Barrett','Miranda Armstrong','Aqszaqsz0#','lobortis.quis@yahoo.org','6 40 48 20 27',1,2),
  ('usr-024-7','Valenzuela','Amity Farley','Calista Alvarez','Aqszaqsz0#','nunc.interdum@google.ca','6 75 95 49 13',1,1),
  ('usr-024-8','Horton','Galvin Combs','Kato Petersen','Aqszaqsz0#','varius.ultrices@yahoo.couk','6 28 74 59 66',1,1),
  ('usr-024-9','Jackson','Scarlett Carlson','Jackson Mason','Aqszaqsz0#','id.blandit@aol.org','6 12 34 36 86',1,2),
  ('usr-024-10','Gordon','Marvin Kline','Fuller Rojas','Aqszaqsz0#','arcu.vivamus@protonmail.couk','6 79 27 28 21',1,2),
  ('usr-024-11','Cochran','Cole Flowers','Shana Bolton','Aqszaqsz0#','cras.lorem@aol.net','6 45 04 66 56',1,1),
  ('usr-024-12','Hines','Beck Olsen','Leonard Rosales','Aqszaqsz0#','ac@outlook.org','6 47 82 46 83',1,1),
  ('usr-024-13','Dunlap','Geoffrey Willis','Linus Dillon','Aqszaqsz0#','proin.dolor.nulla@icloud.ca','6 12 18 60 40',1,2),
  ('usr-024-14','Brown','Jamal Vasquez','Arthur Rodriguez','Aqszaqsz0#','praesent.interdum@hotmail.couk','6 52 52 30 72',1,2),
  ('usr-024-15','Stein','Meredith Goodman','Lucas Ratliff','Aqszaqsz0#','auctor@hotmail.org','6 74 16 52 27',1,1),
  ('usr-024-16','Barber','Leo Nichols','Deborah Hill','Aqszaqsz0#','montes.nascetur@yahoo.com','6 67 63 37 82',1,1),
  ('usr-024-17','Vaughn','Carolyn Leblanc','Sebastian Ochoa','Aqszaqsz0#','diam.duis@outlook.net','6 14 54 24 15',1,2),
  ('usr-024-18','Roach','Lillith Warren','Andrew Pollard','Aqszaqsz0#','in@hotmail.org','6 22 95 18 42',1,2),
  ('usr-024-19','Wagner','Kirby Gallegos','Barclay Lang','Aqszaqsz0#','vivamus.molestie@outlook.ca','6 13 83 57 81',1,1),
  ('usr-024-20','Skinner','Brenden Mcmahon','Harlan Vega','Aqszaqsz0#','donec.non@protonmail.ca','6 95 90 14 37',1,1),
  ('usr-024-21','Lambert','Lance Farmer','Maggy Jensen','Aqszaqsz0#','est@yahoo.org','6 12 83 84 75',1,2),
  ('usr-024-22','Griffith','Whitney Melendez','Oliver Miles','Aqszaqsz0#','lacus.ut@icloud.ca','6 54 18 94 22',1,2),
  ('usr-024-23','Gray','Quon Quinn','Cora Mathis','Aqszaqsz0#','ornare@outlook.net','6 50 73 84 65',1,1),
  ('usr-024-24','Kaufman','Holly Soto','Eugenia Melendez','Aqszaqsz0#','scelerisque.dui@google.org','6 58 11 88 73',1,1),
  ('usr-024-25','Finley','Yuri Baird','Troy Kelley','Aqszaqsz0#','in.dolor.fusce@aol.org','6 23 60 83 22',1,2),
  ('usr-024-26','Rogers','Tana Mayo','Alden Massey','Aqszaqsz0#','purus.maecenas@icloud.net','6 07 13 35 52',1,2),
  ('usr-024-27','Chandler','Justin Gilmore','Aidan Berry','Aqszaqsz0#','non.leo@protonmail.edu','6 43 17 47 81',1,1),
  ('usr-024-28','Hickman','Reese Delacruz','Camilla Zamora','Aqszaqsz0#','sem.mollis@protonmail.ca','6 58 51 34 15',1,1),
  ('usr-024-29','Randolph','Brittany Camacho','Aline Velazquez','Aqszaqsz0#','velit.egestas@outlook.ca','6 75 44 96 74',1,2),
  ('usr-024-30','Reid','Xavier Mann','Zoe Young','Aqszaqsz0#','a.auctor.non@outlook.edu','6 67 21 46 38',1,2),
  ('usr-024-31','Hamilton','Fitzgerald Guzman','Ria Simpson','Aqszaqsz0#','sit.amet@hotmail.com','6 58 69 57 24',1,1),
  ('usr-024-32','Mcgee','Fallon Vang','Chaney Castaneda','Aqszaqsz0#','lectus.a@yahoo.net','6 52 42 95 15',1,1),
  ('usr-024-33','Cook','Eliana Bond','Maryam Tyler','Aqszaqsz0#','leo.in.lobortis@google.org','6 66 95 14 37',1,2),
  ('usr-024-34','Ramos','Fitzgerald Humphrey','Aileen Francis','Aqszaqsz0#','justo@hotmail.net','6 11 93 51 58',1,2),
  ('usr-024-35','Key','Wayne Goodwin','Jolie Dunn','Aqszaqsz0#','ipsum@google.ca','6 46 66 42 26',1,1),
  ('usr-024-36','Hays','Geraldine Head','Emily Mendez','Aqszaqsz0#','suspendisse.tristique.neque@google.couk','6 37 21 22 36',1,1),
  ('usr-024-37','Ewing','Adrian Hancock','Eric Blackburn','Aqszaqsz0#','augue@aol.net','6 36 54 79 77',1,2),
  ('usr-024-38','Stephenson','Alika Jacobson','Lareina Beasley','Aqszaqsz0#','massa@protonmail.org','6 18 23 55 30',1,2),
  ('usr-024-39','Sargent','Shelby Moss','Coby Walsh','Aqszaqsz0#','diam.eu@outlook.com','6 94 67 90 97',1,1),
  ('usr-024-40','Delaney','Justina Vazquez','Darrel Hendricks','Aqszaqsz0#','nec.urna@hotmail.com','6 12 55 35 60',1,1),
  ('usr-024-41','Johns','Jonah Townsend','Joel Oliver','Aqszaqsz0#','pede.suspendisse@icloud.ca','6 80 63 02 55',1,2),
  ('usr-024-42','Nolan','Ariana Howell','Demetrius Brewer','Aqszaqsz0#','curabitur.sed@hotmail.net','6 67 44 88 49',1,2),
  ('usr-024-43','King','Hunter Mclaughlin','Cara Gamble','Aqszaqsz0#','commodo.hendrerit@aol.com','6 79 13 64 23',1,1),
  ('usr-024-44','Armstrong','Clementine Humphrey','Oprah Tran','Aqszaqsz0#','sed.hendrerit@yahoo.edu','6 64 57 31 46',1,1),
  ('usr-024-45','Hester','Denton Kirby','Nigel Cohen','Aqszaqsz0#','fringilla.cursus.purus@yahoo.com','6 64 34 38 01',1,2),
  ('usr-024-46','Middleton','Halee William','Minerva Howard','Aqszaqsz0#','dolor.donec.fringilla@hotmail.edu','6 47 41 53 87',1,2),
  ('usr-024-47','Bonner','Ivory Phillips','Lars Yang','Aqszaqsz0#','amet.massa.quisque@protonmail.couk','6 55 68 92 61',1,1),
  ('usr-024-48','Aguirre','Jesse Horne','Anjolie Brock','Aqszaqsz0#','amet@icloud.org','6 63 74 60 60',1,1),
  ('usr-024-49','Barrett','Macaulay Higgins','Mark Bolton','Aqszaqsz0#','vivamus.euismod.urna@aol.edu','6 10 28 76 30',1,2),
  ('usr-024-50','Rodgers','Kieran Potter','Mark Gonzales','Aqszaqsz0#','malesuada.fames.ac@protonmail.couk','6 75 21 56 25',1,2),
  ('usr-024-51','Riley','Maryam Maynard','Burke Daniel','Aqszaqsz0#','sed@yahoo.com','6 75 58 47 45',1,1),
  ('usr-024-52','Guerra','Nell Wiggins','Wang Griffin','Aqszaqsz0#','accumsan.laoreet@google.couk','6 50 15 35 19',1,1),
  ('usr-024-53','Hopkins','Madeline Moreno','Colorado Pruitt','Aqszaqsz0#','sed.sem@outlook.org','6 57 95 57 18',1,2),
  ('usr-024-54','Mann','Joy Castro','Tara Hoover','Aqszaqsz0#','blandit.mattis@protonmail.com','6 17 00 32 39',1,2),
  ('usr-024-55','Bradshaw','Andrew Petersen','Stella Buchanan','Aqszaqsz0#','nibh.lacinia.orci@hotmail.edu','6 12 67 66 25',1,1),
  ('usr-024-56','Mueller','Jena Cameron','Thomas Vincent','Aqszaqsz0#','ornare.in@icloud.com','6 14 63 55 42',1,1),
  ('usr-024-57','Oconnor','Tanya Henson','Acton Dalton','Aqszaqsz0#','dui.cum@yahoo.com','6 68 87 23 81',1,2),
  ('usr-024-58','Joyner','Boris Walter','Uma Collins','Aqszaqsz0#','ornare.placerat@aol.net','6 98 41 73 87',1,2),
  ('usr-024-59','Holloway','Paul Gray','Jessamine Reilly','Aqszaqsz0#','massa.rutrum.magna@icloud.couk','6 62 60 23 04',1,1),
  ('usr-024-60','Salinas','Whilemina Pacheco','Jared Maxwell','Aqszaqsz0#','sed.congue@icloud.org','6 53 80 37 36',1,1),
  ('usr-024-61','Ware','Dacey Hamilton','Marvin Robles','Aqszaqsz0#','conubia.nostra@google.com','6 05 37 29 38',1,2),
  ('usr-024-62','Manning','Bianca Herring','Hayes Merrill','Aqszaqsz0#','ridiculus.mus@yahoo.edu','6 36 81 35 64',1,2),
  ('usr-024-63','Lowe','Margaret Hooper','Henry Newman','Aqszaqsz0#','varius.orci.in@hotmail.org','6 59 82 58 52',1,1),
  ('usr-024-64','Key','Blossom Nieves','Geraldine Leonard','Aqszaqsz0#','pharetra@yahoo.ca','6 72 64 47 14',1,1),
  ('usr-024-65','Sloan','Hedley Duke','Aladdin Burns','Aqszaqsz0#','vivamus.sit.amet@hotmail.edu','6 28 28 38 33',1,2),
  ('usr-024-66','Vincent','Hayley Cooke','Blaze Velez','Aqszaqsz0#','montes.nascetur@protonmail.com','6 15 67 17 52',1,2),
  ('usr-024-67','Cooke','Stella Cole','Rhiannon Wood','Aqszaqsz0#','semper.pretium.neque@yahoo.net','6 20 88 12 82',1,1),
  ('usr-024-68','French','Amena Turner','Cara Reilly','Aqszaqsz0#','natoque.penatibus@yahoo.ca','6 63 24 43 25',1,1),
  ('usr-024-69','Hanson','Carly Rowland','Jordan Mccormick','Aqszaqsz0#','lacinia.at.iaculis@hotmail.org','6 31 12 27 25',1,2),
  ('usr-024-70','Ward','Ocean Bowers','Ishmael Bauer','Aqszaqsz0#','non.vestibulum.nec@aol.ca','6 79 52 97 85',1,2),
  ('usr-024-71','Nicholson','Tyrone Hendrix','Dante Holt','Aqszaqsz0#','ut.semper.pretium@google.ca','6 26 04 54 12',1,1),
  ('usr-024-72','Bartlett','Chaney Carpenter','Claire Woods','Aqszaqsz0#','egestas.blandit.nam@icloud.couk','6 16 57 74 21',1,1),
  ('usr-024-73','ONeill','Yoshio Steele','Honorato Sanchez','Aqszaqsz0#','ipsum.dolor@aol.org','6 36 84 07 69',1,2),
  ('usr-024-74','Garza','Cassady Calderon','Vanna Lowe','Aqszaqsz0#','arcu.sed@protonmail.com','6 58 08 77 41',1,2),
  ('usr-024-75','Anderson','Jesse Callahan','Adria Patel','Aqszaqsz0#','tempor.erat@hotmail.net','6 79 21 77 39',1,1),
  ('usr-024-76','Calderon','Erin Drake','Rhona Weiss','Aqszaqsz0#','placerat@protonmail.org','6 26 87 75 18',1,1),
  ('usr-024-77','Navarro','Xenos Russo','Luke Clarke','Aqszaqsz0#','vivamus.sit.amet@aol.com','6 31 95 38 31',1,2),
  ('usr-024-78','Schmidt','Judah Jensen','Amela Burns','Aqszaqsz0#','mauris.erat@icloud.couk','6 52 14 44 84',1,2),
  ('usr-024-79','Melton','Zia Newman','Stone Clements','Aqszaqsz0#','urna.ut@yahoo.com','6 58 75 69 52',1,1),
  ('usr-024-80','Bridges','Tashya Joyner','Olympia Lucas','Aqszaqsz0#','gravida.praesent@hotmail.net','6 03 34 19 31',1,1),
  ('usr-024-81','Nash','Jelani Farmer','Beatrice Woodard','Aqszaqsz0#','ante.ipsum@yahoo.edu','6 08 62 47 25',1,2),
  ('usr-024-82','Hartman','Meredith Howe','Linus Watts','Aqszaqsz0#','proin.vel@hotmail.com','6 72 26 36 23',1,2),
  ('usr-024-83','Best','Slade Joseph','Sean Finley','Aqszaqsz0#','arcu@protonmail.net','6 84 86 82 22',1,1),
  ('usr-024-84','Mayer','Cassady Walker','Martha Ryan','Aqszaqsz0#','dolor.fusce@google.couk','6 15 61 83 83',1,1),
  ('usr-024-85','Cook','Chancellor Berg','Minerva Blevins','Aqszaqsz0#','neque.sed@outlook.ca','6 51 21 97 36',1,2),
  ('usr-024-86','Beard','Zelenia Serrano','Wynne West','Aqszaqsz0#','egestas.aliquam@google.couk','6 66 23 13 78',1,2),
  ('usr-024-87','Allen','Bevis Goodwin','Olympia Castro','Aqszaqsz0#','egestas@outlook.ca','6 24 28 27 38',1,1),
  ('usr-024-88','Lott','Ulla Wright','Alice Moss','Aqszaqsz0#','arcu@protonmail.couk','6 83 09 35 26',1,1),
  ('usr-024-89','Munoz','Maile Forbes','Briar Kemp','Aqszaqsz0#','vulputate.eu@protonmail.ca','6 65 13 25 63',1,2),
  ('usr-024-90','Cole','Serena Compton','Ishmael Sampson','Aqszaqsz0#','sodales.mauris@protonmail.ca','6 56 63 59 46',1,2),
  ('usr-024-91','Carson','Boris Curtis','Alec Jacobson','Aqszaqsz0#','est.ac.mattis@outlook.edu','6 49 12 67 07',1,1),
  ('usr-024-92','Gilliam','John Chambers','Keiko Crawford','Aqszaqsz0#','velit.dui@yahoo.couk','6 66 86 23 77',1,1),
  ('usr-024-93','Cunningham','Oren Petty','Steel Rivers','Aqszaqsz0#','enim.mauris@protonmail.net','6 50 42 34 68',1,2),
  ('usr-024-94','Gaines','Mari Peck','Ishmael Holland','Aqszaqsz0#','venenatis@hotmail.edu','6 19 58 84 39',1,2),
  ('usr-024-95','Knowles','Ryder Carlson','Flavia Rodriquez','Aqszaqsz0#','lobortis.ultrices@hotmail.org','6 34 62 82 17',1,1),
  ('usr-024-96','Walls','Cameron Bishop','Autumn Jennings','Aqszaqsz0#','elementum@icloud.org','6 41 43 67 53',1,1),
  ('usr-024-97','Clements','Alma Giles','Fallon Albert','Aqszaqsz0#','ridiculus.mus.donec@outlook.org','6 92 74 38 17',1,2),
  ('usr-024-98','Harrington','Drew Leblanc','Ashton Singleton','Aqszaqsz0#','velit@aol.com','6 38 17 15 33',1,2),
  ('usr-024-99','Barton','Audra Campos','Eugenia Ross','Aqszaqsz0#','ante.vivamus.non@hotmail.org','6 42 38 16 38',1,1),
  ('usr-024-100','Sharp','Charlotte Thompson','Addison Herrera','Aqszaqsz0#','volutpat.nulla@protonmail.ca','6 23 48 44 52',1,1),
  ('usr-024-101','Cabrera','Diana Burnett','Rooney Abbott','Aqszaqsz0#','in@hotmail.org','6 07 63 26 51',1,2),
  ('usr-024-102','Callahan','Addison Mckenzie','Harlan Moran','Aqszaqsz0#','blandit.enim@protonmail.edu','6 40 71 22 17',1,2);

