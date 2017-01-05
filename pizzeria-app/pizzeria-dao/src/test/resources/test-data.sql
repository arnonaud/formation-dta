CREATE TABLE pizza (
  id int(11) auto_increment NOT NULL,
  categorie varchar(255),
  code varchar(255),
  nom varchar(255),
  prix double,
  url_image varchar(255)
);

INSERT INTO pizza (id, categorie, code, nom, prix, url_image) VALUES
(1, 'VIANDE', 'BBC', 'Margherita', 16, 'Pizza_Calzone.jpg');
INSERT INTO pizza (id, categorie, code, nom, prix, url_image) VALUES
(2, 'VIANDE', 'VEG', 'Vegetarienne', 14, 'Pizza_4fromages.jpg');
INSERT INTO pizza (id, categorie, code, nom, prix, url_image) VALUES
(3, 'VIANDE', 'PPP', 'ppp', 4, NULL);
INSERT INTO pizza (id, categorie, code, nom, prix, url_image) VALUES
(4, 'POISSON', 'TTT', 'MLMLML', 12, NULL);
