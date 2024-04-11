CREATE DATABASE IF NOT EXISTS `transacoustic`;
-- -----------------------------------------------------
-- Table `transacoustic`.`constructions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transacoustic`.`constructions` (
`id` INT NOT NULL AUTO_INCREMENT,
`title` VARCHAR(65) NULL DEFAULT NULL,
PRIMARY KEY (`id`));
-- -----------------------------------------------------
-- Table `transacoustic`.`constructs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transacoustic`.`constructs` (
`Id` INT NOT NULL AUTO_INCREMENT COMMENT ' Id типа.Первичный синтетический ключ таблицы.',
`Type` VARCHAR(255) NOT NULL COMMENT ' Описание типа',

PRIMARY KEY (`Id`))
DEFAULT CHARACTER SET = utf8mb3;
-- -----------------------------------------------------
-- Table `transacoustic`.`units`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transacoustic`.`units` (
`id` INT NOT NULL AUTO_INCREMENT,
`unit` VARCHAR(35) NULL DEFAULT NULL,
PRIMARY KEY (`id`))
COMMENT = 'единицы измерения';
-- -----------------------------------------------------
-- Table `transacoustic`.`types_one`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transacoustic`.`types_one` (
`id` INT NOT NULL AUTO_INCREMENT,
`type_name` VARCHAR(25) NULL DEFAULT NULL,
PRIMARY KEY (`id`));
-- -----------------------------------------------------
-- Table `transacoustic`.`item_change`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transacoustic`.`item_change` (
`Id` INT NOT NULL AUTO_INCREMENT,
`Users_Id` INT NOT NULL,
`Items_Id` BIGINT NOT NULL COMMENT '\n',
PRIMARY KEY (`Id`),
INDEX `fk_item_change_items1_idx` (`Items_Id` ASC) VISIBLE,
CONSTRAINT `fk_item_change_items1`

FOREIGN KEY (`Items_Id`)
REFERENCES `transacoustic`.`items` (`Id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION)
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Таблица связи многие ко многим для таблиц Пользователи и Сенсоры. Отображает, в
какие сенсоры админ вносил изменения\n';
-- -----------------------------------------------------
-- Table `transacoustic`.`materials`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transacoustic`.`materials` (
`Id` INT NOT NULL AUTO_INCREMENT COMMENT ' Id юнита.Первичный синтетический ключ
таблицы.',
`Unit` VARCHAR(241) NULL DEFAULT NULL,
`Source` VARCHAR(300) NULL DEFAULT NULL,
`Url` VARCHAR(300) NULL DEFAULT NULL,
PRIMARY KEY (`Id`))
DEFAULT CHARACTER SET = utf8mb3;
-- -----------------------------------------------------
-- Table `transacoustic`.`items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transacoustic`.`items` (
`Id` BIGINT NOT NULL AUTO_INCREMENT COMMENT ' Id cлоя-\"сенсора\".Первичный синтетический
ключ таблицы.',
`Name` VARCHAR(250) NOT NULL,
`Thickness` DECIMAL(6,2) NULL DEFAULT NULL,
`Density` DECIMAL(10,3) NULL DEFAULT NULL,
`Si63` DECIMAL NULL DEFAULT NULL COMMENT 'одно поле для одного значения звукоизоляции

отсортированы в настоящее время, чтобы удобно было вводить прямо в базу',
`Si125` DECIMAL NULL DEFAULT NULL,
`Si250` DECIMAL NULL DEFAULT NULL,
`Si500` DECIMAL NULL DEFAULT NULL,
`Si1000` DECIMAL NULL DEFAULT NULL,
`Si2000` DECIMAL NULL DEFAULT NULL,
`Si4000` DECIMAL NULL DEFAULT NULL,
`Si8000` DECIMAL NULL DEFAULT NULL,
`Si50` DECIMAL NULL DEFAULT NULL,
`Si80` DECIMAL NULL DEFAULT NULL,
`Si100` DECIMAL NULL DEFAULT NULL,
`Si160` DECIMAL NULL DEFAULT NULL,
`Si200` DECIMAL NULL DEFAULT NULL,
`Si315` DECIMAL NULL DEFAULT NULL,
`Si400` DECIMAL NULL DEFAULT NULL,
`Si630` DECIMAL NULL DEFAULT NULL,
`Si800` DECIMAL NULL DEFAULT NULL,
`Si1250` DECIMAL NULL DEFAULT NULL,
`Si1600` DECIMAL NULL DEFAULT NULL,
`Sound_Insulations` VARCHAR(60) NULL DEFAULT NULL COMMENT 'дублирование значений
Sound_Insulations в виде строки ',
`Constructs_Id` INT NULL DEFAULT NULL COMMENT ' Внешний ключ таблицы для связи с таблицей
Constructions',
`AveragedSoundInsulation` DECIMAL NULL DEFAULT NULL,
`Constructions_Id` INT NULL DEFAULT NULL,
`Characteristics_Id` INT NULL DEFAULT NULL COMMENT 'наименования колонок Sound_Insulations
нужно, если воодить сразу строку',
`Types_one_Id` INT NULL DEFAULT NULL COMMENT 'Generic',

`Materials_ID` INT NULL DEFAULT NULL COMMENT 'источник, откуда вводятся данные',
`Units_Id` INT NULL DEFAULT NULL COMMENT 'комментарий для информации, которую не
понятно, куда добавлять',
`Image` BLOB NULL DEFAULT NULL COMMENT 'рисунок или комментарий',
PRIMARY KEY (`Id`),
INDEX `fk_items_units1_idx` (`Units_Id` ASC) VISIBLE,
INDEX `fk_items_types_one1_idx` (`Types_one_Id` ASC) VISIBLE,
INDEX `fk_items_constructs1_idx` (`Constructs_Id` ASC) VISIBLE,
INDEX `fk_items_constructions1_idx` (`Constructions_Id` ASC) VISIBLE,
INDEX `fk_items_materials1_idx` (`Materials_ID` ASC) VISIBLE,
CONSTRAINT `fk_items_units1`
FOREIGN KEY (`Units_Id`)
REFERENCES `transacoustic`.`units` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT `fk_items_types_one1`
FOREIGN KEY (`Types_one_Id`)
REFERENCES `transacoustic`.`types_one` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT `fk_items_constructs1`
FOREIGN KEY (`Constructs_Id`)
REFERENCES `transacoustic`.`constructs` (`Id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT `fk_items_constructions1`
FOREIGN KEY (`Constructions_Id`)

REFERENCES `transacoustic`.`constructions` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT `fk_items_item_change1`
FOREIGN KEY (`Id`)
REFERENCES `transacoustic`.`item_change` (`Items_Id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT `fk_items_materials1`
FOREIGN KEY (`Materials_ID`)
REFERENCES `transacoustic`.`materials` (`Id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION)
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Таблица пополнения базы данных. Основной элемент системы заполнения. ';
-- -----------------------------------------------------
-- Table `transacoustic`.`layers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transacoustic`.`layers` (
`Id` INT NOT NULL AUTO_INCREMENT,
`Layer_title` VARCHAR(25) NULL DEFAULT NULL,
PRIMARY KEY (`Id`));
-- -----------------------------------------------------
-- Table `transacoustic`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transacoustic`.`roles` (
`Id` INT NOT NULL AUTO_INCREMENT COMMENT ' Id роли.Первичный синтетический ключ

таблицы.',
`Role` VARCHAR(20) NOT NULL COMMENT ' Тип роли.',
PRIMARY KEY (`Id`))
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Таблица ролей пользователя. Администратор, обычный пользователь';
-- -----------------------------------------------------
-- Table `transacoustic`.`types_two`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transacoustic`.`types_two` (
`id` INT NOT NULL AUTO_INCREMENT,
`SI` VARCHAR(60) NULL DEFAULT NULL,
`Characteristics_Id` INT NULL DEFAULT NULL,
PRIMARY KEY (`id`));
-- -----------------------------------------------------
-- Table `transacoustic`.`characteristics`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transacoustic`.`characteristics` (
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(60) NULL DEFAULT NULL,
`id_unit` INT NULL DEFAULT NULL,
PRIMARY KEY (`id`),
INDEX `characteristics_units__fk` (`id_unit` ASC) VISIBLE,
CONSTRAINT `characteristics_units__fk`
FOREIGN KEY (`id_unit`)
REFERENCES `transacoustic`.`units` (`id`));
-- -----------------------------------------------------
-- Table `transacoustic`.`users`

-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `transacoustic`.`users` (
`Id` INT NOT NULL AUTO_INCREMENT COMMENT ' Поле id пользователя.Первичный синтетический
ключ таблицы.',
`Login` VARCHAR(41) NOT NULL COMMENT ' Логин пользователя для входа в систему.Также является
альтернативным ключом или уникальным индексом.',
`Password` VARCHAR(32) NOT NULL COMMENT 'Пароль пользователя для входа в систему.',
`First_Name` VARCHAR(15) NOT NULL COMMENT ' Имя пользователя.',
`Last_Name` VARCHAR(15) NOT NULL COMMENT ' Фамилия пользователя.',
`Roles_Id` INT NOT NULL DEFAULT 2,
PRIMARY KEY (`Id`, `Roles_Id`),
UNIQUE INDEX `Login_UNIQUE` (`Login` ASC) VISIBLE,
INDEX `fk_users_roles1` (`Roles_Id` ASC) VISIBLE,
CONSTRAINT `fk_users_roles1`
FOREIGN KEY (`Roles_Id`)
REFERENCES `transacoustic`.`roles` (`Id`)#,
#CONSTRAINT `fk_users_item_change1`
#FOREIGN KEY (`Id`)
#REFERENCES `transacoustic`.`item_change` (`Users_Id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION)
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Таблица Пользователей. Содержит информацию о пользователе. Дополнительный
уникальный индекс - поле Login.';
