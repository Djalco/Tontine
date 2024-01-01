CREATE TABLE `user`(
	`id` 			VARCHAR(20) PRIMARY KEY,
	`login`			VARCHAR(100) NOT NULL,
	`firstname`		VARCHAR(100) NOT NULL,
	`lastname` 		VARCHAR(100) NOT NULL,
	`password` 		VARCHAR(100) NOT NULL,
	`mail` 			VARCHAR(100) NOT NULL,
	`phone` 		VARCHAR(100) NOT NULL,
	`role` 			VARCHAR(100) NOT NULL,
	`nbPerson` 		VARCHAR(100) NOT NULL,
	`is_actif`  	int NOT NULL DEFAULT 1
);

CREATE TABLE `session`(
	`id` 			VARCHAR(20) PRIMARY KEY,
	`numSession` 	INT NOT NULL,
	`dateSession` 	DATETIME NOT NULL,
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
	`sessionSold` VARCHAR(20) NOT NULL,
	FOREIGN KEY (`id`) REFERENCES `ManagePayment`(`id`),
	FOREIGN KEY (`sessionSold`) REFERENCES `session`(`id`)
);

CREATE TABLE `contribution`(
	`id` VARCHAR(20) PRIMARY KEY,
	`sessionContributed` VARCHAR(20) NOT NULL,
	FOREIGN KEY (`id`) REFERENCES `ManagePayment`(`id`),
	FOREIGN KEY (`sessionContributed`) REFERENCES `session`(`id`)
);

CREATE TABLE `sanction`(
	`id` VARCHAR(20) PRIMARY KEY,
	`infractionPayment` int NOT NULL,
	`sessionStart` VARCHAR(20) NOT NULL,
	`sessionSold` VARCHAR(20) DEFAULT NULL,
	FOREIGN KEY (`sessionStart`) REFERENCES `session`(`id`),
	FOREIGN KEY (`sessionSold`) REFERENCES `session`(`id`)
);

CREATE TABLE `setting`(
	`amount_cotisation` int,
	`type_payment_loan` VARCHAR(20),
	`amount_payment_loan` VARCHAR(20),
	`type_payment_infraction` VARCHAR(20),
	`amount_payment_infraction` VARCHAR(20)
);
