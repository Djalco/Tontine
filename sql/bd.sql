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
('usr-023-001', 'luffy', 'Monkey D', 'Luffy', '12345678', 'luffy@gmail.com', '6 90 18 53 35', 1, 3);
