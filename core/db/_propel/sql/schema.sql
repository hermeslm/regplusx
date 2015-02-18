
# This is a fix for InnoDB in MySQL >= 4.1.x
# It "suspends judgement" for fkey relationships until are tables are set.
SET FOREIGN_KEY_CHECKS = 0;

-- ---------------------------------------------------------------------
-- province
-- ---------------------------------------------------------------------

DROP TABLE IF EXISTS `province`;

CREATE TABLE `province`
(
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(250) NOT NULL COMMENT 'Nombre de la Provincia',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='Tabla que almacena los datos de las instituciones';

-- ---------------------------------------------------------------------
-- canton
-- ---------------------------------------------------------------------

DROP TABLE IF EXISTS `canton`;

CREATE TABLE `canton`
(
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(250) NOT NULL COMMENT 'Nombre del Canton',
    `province_id` INTEGER NOT NULL COMMENT 'Provincia',
    PRIMARY KEY (`id`),
    INDEX `canton_FI_1` (`province_id`),
    CONSTRAINT `canton_FK_1`
        FOREIGN KEY (`province_id`)
        REFERENCES `province` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE
) ENGINE=InnoDB COMMENT='Tabla que almacena los datos de los Cantones';

-- ---------------------------------------------------------------------
-- parroquia
-- ---------------------------------------------------------------------

DROP TABLE IF EXISTS `parroquia`;

CREATE TABLE `parroquia`
(
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(250) NOT NULL COMMENT 'Nombre del Canton',
    `canton_id` INTEGER NOT NULL COMMENT 'Canton',
    PRIMARY KEY (`id`),
    INDEX `parroquia_FI_1` (`canton_id`),
    CONSTRAINT `parroquia_FK_1`
        FOREIGN KEY (`canton_id`)
        REFERENCES `canton` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE
) ENGINE=InnoDB COMMENT='Tabla que almacena las Parroquias';

-- ---------------------------------------------------------------------
-- client
-- ---------------------------------------------------------------------

DROP TABLE IF EXISTS `client`;

CREATE TABLE `client`
(
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(250) NOT NULL COMMENT 'Nombre del cliente',
    `last_name` VARCHAR(250) NOT NULL COMMENT 'Apellidos del cliente',
    `address` VARCHAR(512) NOT NULL COMMENT 'Direccion del cliente',
    `province_id` INTEGER NOT NULL COMMENT 'Provincia',
    `canton_id` INTEGER NOT NULL COMMENT 'Canton',
    `parroquia_id` INTEGER NOT NULL COMMENT 'Parroquia',
    PRIMARY KEY (`id`),
    INDEX `client_FI_1` (`province_id`),
    INDEX `client_FI_2` (`canton_id`),
    INDEX `client_FI_3` (`parroquia_id`),
    CONSTRAINT `client_FK_1`
        FOREIGN KEY (`province_id`)
        REFERENCES `province` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT `client_FK_2`
        FOREIGN KEY (`canton_id`)
        REFERENCES `canton` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT `client_FK_3`
        FOREIGN KEY (`parroquia_id`)
        REFERENCES `parroquia` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE
) ENGINE=InnoDB COMMENT='Tabla que almacena los Clientes';

-- ---------------------------------------------------------------------
-- area
-- ---------------------------------------------------------------------

DROP TABLE IF EXISTS `area`;

CREATE TABLE `area`
(
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(250) NOT NULL COMMENT 'Nombre del Area',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='Tabla que almacena las Areas';

-- ---------------------------------------------------------------------
-- book_type
-- ---------------------------------------------------------------------

DROP TABLE IF EXISTS `book_type`;

CREATE TABLE `book_type`
(
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(250) NOT NULL COMMENT 'Tipo de Libro',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='Tabla que almacena los tipos de libros';

-- ---------------------------------------------------------------------
-- book
-- ---------------------------------------------------------------------

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book`
(
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(250) NOT NULL COMMENT 'Descripcion del Libro',
    `type_id` INTEGER NOT NULL COMMENT 'Tipo del Libro',
    PRIMARY KEY (`id`),
    INDEX `book_FI_1` (`type_id`),
    CONSTRAINT `book_FK_1`
        FOREIGN KEY (`type_id`)
        REFERENCES `book_type` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE
) ENGINE=InnoDB COMMENT='Tabla que almacena los libros de registros';

-- ---------------------------------------------------------------------
-- volume
-- ---------------------------------------------------------------------

DROP TABLE IF EXISTS `volume`;

CREATE TABLE `volume`
(
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(250) NOT NULL COMMENT 'Descripcion del Tomo',
    `start_folio` INTEGER NOT NULL COMMENT 'Folio de Inicio',
    `end_folio` INTEGER NOT NULL COMMENT 'Folio de Fin',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='Tabla que almacena los Tomos de Libros';

-- ---------------------------------------------------------------------
-- state
-- ---------------------------------------------------------------------

DROP TABLE IF EXISTS `state`;

CREATE TABLE `state`
(
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(250) NOT NULL COMMENT 'Nombre del Estado',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='Tabla que almacena los Estados';

-- ---------------------------------------------------------------------
-- record_type
-- ---------------------------------------------------------------------

DROP TABLE IF EXISTS `record_type`;

CREATE TABLE `record_type`
(
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `description` VARCHAR(250) COMMENT 'Descripcion del tipo de Registro',
    `value` FLOAT COMMENT 'Valor del Registro',
    `percent` FLOAT NOT NULL COMMENT 'Porciento del Registro',
    `book_id` INTEGER NOT NULL COMMENT 'Libro',
    PRIMARY KEY (`id`),
    INDEX `record_type_FI_1` (`book_id`),
    CONSTRAINT `record_type_FK_1`
        FOREIGN KEY (`book_id`)
        REFERENCES `book` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE
) ENGINE=InnoDB COMMENT='Tabla que almacena los Tipos de Registros';

-- ---------------------------------------------------------------------
-- record
-- ---------------------------------------------------------------------

DROP TABLE IF EXISTS `record`;

CREATE TABLE `record`
(
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `year` INTEGER NOT NULL COMMENT 'Ano de Registro',
    `repertory` INTEGER NOT NULL COMMENT 'Repertorio del Registro',
    `record` INTEGER NOT NULL COMMENT 'Registro',
    `record_date` DATE COMMENT 'Fecha del Registro',
    `afecta1` VARCHAR(20) COMMENT 'Afecta1 de Registro',
    `afecta2` VARCHAR(20) COMMENT 'Afecta2 de Registro',
    `notary_office` VARCHAR(250) NOT NULL COMMENT 'Notaria o Jusgado del Registro',
    `details` VARCHAR(512) NOT NULL COMMENT 'Detalles de Registro',
    `notarize_date` DATE COMMENT 'Fecha del Registro Notariado',
    `book_id` INTEGER NOT NULL COMMENT 'Libro',
    `volume_id` INTEGER NOT NULL COMMENT 'Tomo',
    `folio` INTEGER NOT NULL COMMENT 'Folio',
    `observations` VARCHAR(512) NOT NULL COMMENT 'Observaciones de Registro',
    `state_id` INTEGER NOT NULL COMMENT 'Estado',
    PRIMARY KEY (`id`),
    INDEX `record_FI_1` (`book_id`),
    INDEX `record_FI_2` (`volume_id`),
    INDEX `record_FI_3` (`state_id`),
    CONSTRAINT `record_FK_1`
        FOREIGN KEY (`book_id`)
        REFERENCES `book` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT `record_FK_2`
        FOREIGN KEY (`volume_id`)
        REFERENCES `volume` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT `record_FK_3`
        FOREIGN KEY (`state_id`)
        REFERENCES `state` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE
) ENGINE=InnoDB COMMENT='Tabla que almacena los Registros';

-- ---------------------------------------------------------------------
-- repertory
-- ---------------------------------------------------------------------

DROP TABLE IF EXISTS `repertory`;

CREATE TABLE `repertory`
(
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `day` VARCHAR(10) NOT NULL COMMENT 'Dia del Repertorio',
    `year` INTEGER NOT NULL COMMENT 'Repertorio',
    `repertory` INTEGER NOT NULL COMMENT 'Repertorio del Registro',
    `client_id` INTEGER NOT NULL COMMENT 'Cliente',
    `reason_act` VARCHAR(15) NOT NULL COMMENT 'Acto de Razon',
    `name_act` VARCHAR(15) COMMENT 'Acto Nombre',
    `record_id` INTEGER NOT NULL COMMENT 'Duracion de la compania',
    `observations` VARCHAR(512) COMMENT 'Observaciones',
    `invoice` INTEGER NOT NULL COMMENT 'Factura',
    PRIMARY KEY (`id`),
    INDEX `repertory_FI_1` (`client_id`),
    INDEX `repertory_FI_2` (`record_id`),
    CONSTRAINT `repertory_FK_1`
        FOREIGN KEY (`client_id`)
        REFERENCES `client` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT `repertory_FK_2`
        FOREIGN KEY (`record_id`)
        REFERENCES `record` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE
) ENGINE=InnoDB COMMENT='Tabla que almacena los Repertorios';

-- ---------------------------------------------------------------------
-- company
-- ---------------------------------------------------------------------

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company`
(
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `repertory` INTEGER NOT NULL COMMENT 'Repertorio de la Empresa',
    `record_id` INTEGER NOT NULL COMMENT 'Registro',
    `year` INTEGER NOT NULL COMMENT 'Ano de Registro',
    `name` VARCHAR(250) NOT NULL COMMENT 'Nombre de la Compania',
    `agent` VARCHAR(250) NOT NULL COMMENT 'Representante legal',
    `opening_date` DATE COMMENT 'Fecha de apertura',
    `duration` VARCHAR(250) NOT NULL COMMENT 'Duracion de la compania',
    `resolution` VARCHAR(250) COMMENT 'Resolucion',
    `ruc` VARCHAR(15) NOT NULL COMMENT 'RUC de la compania',
    PRIMARY KEY (`id`),
    INDEX `company_FI_1` (`record_id`),
    CONSTRAINT `company_FK_1`
        FOREIGN KEY (`record_id`)
        REFERENCES `record` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE
) ENGINE=InnoDB COMMENT='Tabla que almacena las companias';

-- ---------------------------------------------------------------------
-- property
-- ---------------------------------------------------------------------

DROP TABLE IF EXISTS `property`;

CREATE TABLE `property`
(
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `year` INTEGER NOT NULL COMMENT 'Ano de Registro',
    `repertory` INTEGER NOT NULL COMMENT 'Repertorio de la Empresa',
    `record_id` INTEGER NOT NULL COMMENT 'Registro',
    `key` VARCHAR(20) NOT NULL COMMENT 'Clave de la Propiedad',
    `property_number` VARCHAR(20) NOT NULL COMMENT 'Numero de la Propiedad',
    `block_number` VARCHAR(10) COMMENT 'Numero de la Manzana',
    `cooperative` VARCHAR(20) NOT NULL COMMENT 'Cooperativa',
    `surface` VARCHAR(10) COMMENT 'Superficie de la Propiedad',
    `parroquia_id` INTEGER NOT NULL COMMENT 'Parroquia',
    `north` VARCHAR(20) COMMENT 'Norte de la Propiedad',
    `south` VARCHAR(20) COMMENT 'Sur de la Propiedad',
    `east` VARCHAR(20) COMMENT 'Este de la Propiedad',
    `west` VARCHAR(20) COMMENT 'Oeste de la Propiedad',
    `state_id` INTEGER NOT NULL COMMENT 'Estado',
    `amount` FLOAT COMMENT 'Cuantia de la Propiedad',
    `book_id` INTEGER NOT NULL COMMENT 'Libro',
    `sales_people` VARCHAR(1024) COMMENT 'Vendedores de la Propiedad',
    `cancellation_date` DATE COMMENT 'Fecha de cancelacion de la Propiedad',
    PRIMARY KEY (`id`),
    INDEX `property_FI_1` (`record_id`),
    INDEX `property_FI_2` (`parroquia_id`),
    INDEX `property_FI_3` (`state_id`),
    INDEX `property_FI_4` (`book_id`),
    CONSTRAINT `property_FK_1`
        FOREIGN KEY (`record_id`)
        REFERENCES `record` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT `property_FK_2`
        FOREIGN KEY (`parroquia_id`)
        REFERENCES `parroquia` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT `property_FK_3`
        FOREIGN KEY (`state_id`)
        REFERENCES `state` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT `property_FK_4`
        FOREIGN KEY (`book_id`)
        REFERENCES `book` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE
) ENGINE=InnoDB COMMENT='Tabla que almacena las Propiedades';

-- ---------------------------------------------------------------------
-- client_property
-- ---------------------------------------------------------------------

DROP TABLE IF EXISTS `client_property`;

CREATE TABLE `client_property`
(
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `year` INTEGER NOT NULL COMMENT 'Ano de Registro',
    `repertory` INTEGER NOT NULL COMMENT 'Repertorio de la Empresa',
    `record_id` INTEGER NOT NULL COMMENT 'Registro',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='Tabla que almacena las Propiedades';

-- ---------------------------------------------------------------------
-- agreement_type
-- ---------------------------------------------------------------------

DROP TABLE IF EXISTS `agreement_type`;

CREATE TABLE `agreement_type`
(
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(250) NOT NULL COMMENT 'Nombre del tipo de Contrato',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='Tabla que almacena los tipos de Contratos';

-- ---------------------------------------------------------------------
-- purchaser_type
-- ---------------------------------------------------------------------

DROP TABLE IF EXISTS `purchaser_type`;

CREATE TABLE `purchaser_type`
(
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(250) NOT NULL COMMENT 'Nombre del tipo de Compra',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='Tabla que almacena los tipos de Compras';

-- ---------------------------------------------------------------------
-- trade_property
-- ---------------------------------------------------------------------

DROP TABLE IF EXISTS `trade_property`;

CREATE TABLE `trade_property`
(
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `inscription_date` DATE COMMENT 'Fecha de inscripcion de la Propiedad Mercantil',
    `inscription_number` VARCHAR(20) NOT NULL COMMENT 'Numero de inscripcion de la Propiedad Mercantil',
    `agreement_type_id` INTEGER NOT NULL COMMENT 'Tipo de Contrato de la Propiedad Mercantil',
    `business_name` VARCHAR(256) NOT NULL COMMENT 'Razon Social de la Propiedad Mercantil',
    `purchaser_type_id` INTEGER NOT NULL COMMENT 'Tipo de Comprador de la Propiedad Mercantil',
    `chassis` VARCHAR(20) NOT NULL COMMENT 'Chasis/Serie de la de la Propiedad Mercantil',
    `motor` VARCHAR(20) NOT NULL COMMENT 'Motor de la Propiedad Mercantil',
    `brand` VARCHAR(20) COMMENT 'Marca de la Propiedad Mercantil',
    `model` VARCHAR(20) NOT NULL COMMENT 'Modelo de la Propiedad Mercantil',
    `manufacture_date` VARCHAR(10) COMMENT 'Fecha de Fabricacion de la Propiedad Mercantil',
    `registration_number` VARCHAR(10) NOT NULL COMMENT 'Placa de la Propiedad Mercantil',
    `location` VARCHAR(250) COMMENT 'Ubicacion de la Propiedad Mercantil',
    `last_modification_date` DATE COMMENT 'Fecha de ultima modificacion de la Propiedad Mercantil',
    `identification` VARCHAR(20) COMMENT 'Identificacion de la Propiedad Mercantil',
    `state_id` INTEGER NOT NULL COMMENT 'Estado',
    `judged_letter` VARCHAR(20) COMMENT 'Carta del Juzgado de la Propiedad Mercantil',
    `agent` VARCHAR(1024) COMMENT 'Representante Legal de la Propiedad Mercantil',
    `contract_date` DATE COMMENT 'Fecha de contratacion de la Propiedad Mercantil',
    `cancellation_date` DATE COMMENT 'Fecha de cancelacion de la Propiedad Mercantil',
    PRIMARY KEY (`id`),
    INDEX `trade_property_FI_1` (`agreement_type_id`),
    INDEX `trade_property_FI_2` (`purchaser_type_id`),
    INDEX `trade_property_FI_3` (`state_id`),
    CONSTRAINT `trade_property_FK_1`
        FOREIGN KEY (`agreement_type_id`)
        REFERENCES `agreement_type` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT `trade_property_FK_2`
        FOREIGN KEY (`purchaser_type_id`)
        REFERENCES `purchaser_type` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT `trade_property_FK_3`
        FOREIGN KEY (`state_id`)
        REFERENCES `state` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE
) ENGINE=InnoDB COMMENT='Tabla que almacena las Propiedades Mercantiles';

-- ---------------------------------------------------------------------
-- company_type
-- ---------------------------------------------------------------------

DROP TABLE IF EXISTS `company_type`;

CREATE TABLE `company_type`
(
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(250) NOT NULL COMMENT 'Nombre del tipo de Compañia',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='Tabla que almacena las especies de la compañia';

-- ---------------------------------------------------------------------
-- appearing_type
-- ---------------------------------------------------------------------

DROP TABLE IF EXISTS `appearing_type`;

CREATE TABLE `appearing_type`
(
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(250) NOT NULL COMMENT 'Nombre del tipo de Compareciente',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='Tabla que almacena los tipos de comparecientes';

-- ---------------------------------------------------------------------
-- society_trade_property
-- ---------------------------------------------------------------------

DROP TABLE IF EXISTS `society_trade_property`;

CREATE TABLE `society_trade_property`
(
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `company_name` VARCHAR(250) NOT NULL COMMENT 'Nombre de la Compañia de la Propiedad Mercantil en Sociedad',
    `identification_number` VARCHAR(20) NOT NULL COMMENT 'Numero de identificacion de la Propiedad Mercantil en Sociedad',
    `cedula` VARCHAR(15) NOT NULL COMMENT 'Cedula de la Propiedad Mercantil en Sociedad',
    `position` VARCHAR(255) NOT NULL COMMENT 'Cargo de la Propiedad Mercantil en Sociedad',
    `appearing_type_id` INTEGER NOT NULL COMMENT 'Tipo de Compareciente',
    `disposition` VARCHAR(255) NOT NULL COMMENT 'Disposicion de la Propiedad Mercantil en Sociedad',
    `data_issuing_authority` VARCHAR(250) NOT NULL COMMENT 'Autoridad emisora de datos de la Propiedad Mercantil en Sociedad',
    `disposition_date` DATE COMMENT 'Fecha de disposicion de la Propiedad Mercantil en Sociedad',
    `disposition_number` VARCHAR(50) COMMENT 'Numero de disposicion de la Propiedad Mercantil en Sociedad',
    `inscription_date` DATE COMMENT 'Fecha de inscripcion de la Propiedad Mercantil en Sociedad',
    `judged_letter` VARCHAR(20) COMMENT 'Nota del Juzgado de la Propiedad Mercantil en Sociedad',
    `processing_type` VARCHAR(50) COMMENT 'Tipo de Tramite de la Propiedad Mercantil en Sociedad',
    `location` VARCHAR(250) COMMENT 'Ubicacion de la Propiedad Mercantil en Sociedad',
    `last_modification_source` VARCHAR(250) COMMENT 'Ultima fuente de modificacion de la Propiedad Mercantil en Sociedad',
    `remote_sistem_identification` VARCHAR(250) COMMENT 'Sistema de identificacion remoto de la Propiedad Mercantil en Sociedad',
    `cancellation_date` DATE COMMENT 'Fecha de cancelacion de la Propiedad Mercantil en Sociedad',
    `state_id` INTEGER NOT NULL COMMENT 'Estado',
    PRIMARY KEY (`id`),
    INDEX `society_trade_property_FI_1` (`appearing_type_id`),
    INDEX `society_trade_property_FI_2` (`state_id`),
    CONSTRAINT `society_trade_property_FK_1`
        FOREIGN KEY (`appearing_type_id`)
        REFERENCES `appearing_type` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT `society_trade_property_FK_2`
        FOREIGN KEY (`state_id`)
        REFERENCES `state` (`id`)
        ON UPDATE CASCADE
        ON DELETE CASCADE
) ENGINE=InnoDB COMMENT='Tabla que almacena las Propiedades Mercantiles en Sociedad';

# This restores the fkey checks, after having unset them earlier
SET FOREIGN_KEY_CHECKS = 1;
