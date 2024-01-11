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
	`session` VARCHAR(20) NOT NULL,
	`user` VARCHAR(20) NOT NULL,
	`amount` int NOT NULL,
	`session_sold` VARCHAR(20) NOT NULL,
	`status` INT DEFAULT 1 NOT NULL,
	`is_actif`  int NOT NULL DEFAULT 1,
	FOREIGN KEY (`session`) REFERENCES `session`(`id`),
	FOREIGN KEY (`session_sold`) REFERENCES `session`(`id`)
);

CREATE TABLE `contribution`(
	`id` VARCHAR(20) PRIMARY KEY,
	`session` VARCHAR(20) NOT NULL,
	`user` VARCHAR(20) NOT NULL,
	`session_contributed` VARCHAR(20) NOT NULL,
	FOREIGN KEY (`user`) REFERENCES `user`(`id`),
	FOREIGN KEY (`session`) REFERENCES `session`(`id`),
	FOREIGN KEY (`session_contributed`) REFERENCES `session`(`id`)
);

CREATE TABLE `sanction`(
	`id` VARCHAR(20) PRIMARY KEY,
	`infraction_payment` int NOT NULL,
	`user` VARCHAR(20) NOT NULL,
	`session_start` VARCHAR(20) NOT NULL,
	`session_sold` VARCHAR(20) DEFAULT NULL,
	`status` INT DELAULT 0 NOT NULL,
	FOREIGN KEY (`user`) REFERENCES `user`(`id`),
	FOREIGN KEY (`session_start`) REFERENCES `session`(`id`),
	FOREIGN KEY (`session_sold`) REFERENCES `session`(`id`)
);

CREATE TABLE `setting`(
	`number_session` INT NOT NULL,
	`fequency` INT NOT NULL,
	`type_date` INT NOT NULL,
	`amount_tontine` INT NOT NULL,
	`type_payment_loan` INT NOT NULL,
	`amount_payment_loan` INT NOT NULL,
	`type_payment_infraction` INT NOT NULL,
	`amount_payment_infraction` INT NOT NULL,
	`amount_cotisation` INT NOT NULL,
	`start_date` Date NOT NULL
);

/* Enregistrement*/

/* Table utilisateur*/
INSERT INTO `user` (`id`, `login`, `firstname`, `lastname`, `password`, `mail`, `phone`, `role`, `nb_person`) VALUES 
  ('usr-023-001', 'luffy', 'Luffy', 'Monkey D', '12345678', 'luffy@gmail.com', '6 90 18 53 35', 1, 3),
  ('usr-024-002', 'perona', 'Sama', 'Perona', 'Aqszaqsz0', 'perona@queen.com', '6 90 28 47 16', 1, 1),
  ('usr-024-003','Lyons','Lewis Ware','Brynn Oconnor','Aqszaqsz0#','mattis.cras@aol.ca','6 28 66 84 88',1,1),
  ('usr-024-004','Fisher','Baxter Cantu','William Mckenzie','Aqszaqsz0#','urna.nunc.quis@outlook.ca','6 33 22 58 82',1,1),
  ('usr-024-005','Oneal','Mira Cooper','Hayfa Brown','Aqszaqsz0#','in.dolor@outlook.com','6 11 87 73 69',1,2),
  ('usr-024-006','Welch','Ira Barrett','Miranda Armstrong','Aqszaqsz0#','lobortis.quis@yahoo.org','6 40 48 20 27',1,2),
  ('usr-024-007','Valenzuela','Amity Farley','Calista Alvarez','Aqszaqsz0#','nunc.interdum@google.ca','6 75 95 49 13',1,1),
  ('usr-024-008','Horton','Galvin Combs','Kato Petersen','Aqszaqsz0#','varius.ultrices@yahoo.couk','6 28 74 59 66',1,1),
  ('usr-024-009','Jackson','Scarlett Carlson','Jackson Mason','Aqszaqsz0#','id.blandit@aol.org','6 12 34 36 86',1,2),
  ('usr-024-010','Gordon','Marvin Kline','Fuller Rojas','Aqszaqsz0#','arcu.vivamus@protonmail.couk','6 79 27 28 21',1,2);
  
  
  
 INSERT INTO `setting` (`number_session`, `fequency`, `type_date`, `amount_tontine`, `type_payment_loan`, `amount_payment_loan`, `type_payment_infraction`, `amount_payment_infraction`, `amount_cotisation`, `start_date`) VALUES 
  ('18', '0', '0', '0', '0', '10', '0', '0', '0', '2024-01-11'); 
  
 