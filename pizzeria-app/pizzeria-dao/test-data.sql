

CREATE TABLE 'pizza' (
  'id' int(11) NOT NULL,
  'categorie' varchar(255) DEFAULT NULL,
  'code' varchar(255) DEFAULT NULL,
  'nom' varchar(255) DEFAULT NULL,
  'prix' double NOT NULL,
  'url_image' varchar(255) DEFAULT NULL
)



INSERT INTO 'pizza' ('id', 'categorie', 'code', 'nom', 'prix', 'url_image') VALUES
(1, 'VIANDE', 'BBC', 'Margherita', 16, 'Pizza_Calzone.jpg'),
(3, 'VIANDE', 'VEG', 'Vegetarienne', 14, 'Pizza_4fromages.jpg'),
(8, 'VIANDE', 'PPP', 'ppp', 4, NULL),
(9, 'VIANDE', 'PPP', 'MLMLML', 12, NULL),
(11, 'VIANDE', 'OOA', 'nananan', 12.32, NULL),
(16, 'VIANDE', 'NNN', 'nananan', 12.32, NULL);

ALTER TABLE 'pizza'
  ADD PRIMARY KEY ('id');

ALTER TABLE 'pizza'
  MODIFY 'id' int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;