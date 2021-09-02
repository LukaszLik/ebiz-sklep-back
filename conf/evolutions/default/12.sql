# --- !Ups
INSERT INTO category ('name', description)
VALUES  ('Warzywa i owoce', 'Smaczne i zdrowe'),
        ('Artykuły spożywcze', 'Na codzień'),
        ('Artykuły gospodarstwa domowego', 'Wszystko dla twojego domu'),
        ('Alkohol', 'whiskys, wódka, wino, piwo'),
        ('Inne', 'inne'),
        ('Dom', 'dodatki do domu');

INSERT INTO product ('name', description, categoryId, price, weight, height, width)
VALUES  ('Ziemniaki', '1kg z południowego stoku idealne na obiad', 1, 1.17, 1, 30.0, 30.0),
        ('Marchewki', '1kg, dobre pomarańczowe', 1, 2.5, 1, 30.0, 30.0),
        ('Jabłka', '1kg polskiej antonówki', 1, 3.5, 1, 30.0, 30.0),
        ('Banany', '1kg, prosto z Afryki', 1, 4.62, 1, 30.0, 30.0),
        ('Cebule', '1kg, najlepsze do rosołu', 1, 2.80, 1., 30.0, 30.0),
        ('Kapusta', '1 główka', 1, 2.90, 10000.0, 30.0, 30.0);

INSERT INTO product ('name', description, categoryId, price, weight, height, width)
VALUES ('Lody na patyku', '250g, różne smaki', 2, 5, 0.25, 0.0, 0.0),
       ('Sok owocowy', '1L, Ekologiczny', 2, 4.70, 1.1, 0.0, 0.0),
       ('Nudle', '1 szt. dla studentów i nie tylko', 2, 0.98, 0.050, 0.0, 0.0),
       ('Parówki', '1 opakowanie, dla studentów i nie tylko', 2, 5.22, 0.250, 0.0, 0.0),
       ('Jogurt', '250ml, wysoka zawartość białka i wapna', 2, 3.80, 0.300, 0.0, 0.0),
       ('Mleko', '1L, 3.2% bez laktozy', 2, 2.20, 1.0, 0.0, 0.0);

INSERT INTO product ('name', description, categoryId, price, weight, height, width)
VALUES ('Chusteczki higieniczne', '1 opakowanie 250 chusteczek', 3, 4.20, 0.0, 0.0, 0.0),
       ('Papier toaletowy', '8 rolek', 3, 6.90, 0.0, 0.0, 0.0),
       ('Ściereczki kuchenne', '3 szt. mikrofibra', 3, 3.89, 0.0, 0.0, 0.0),
       ('Płyn do mycia naczyń', '1L, dobry, miętowy', 3, 6.66, 0.0, 0.0, 0.0);

INSERT INTO user2 (providerId, providerKey, email, 'role', firstName, lastName)
VALUES  ('credentials', 'admin@admin.com', 'admin@admin.com', 'ADMIN', 'Admin', 'Admin'),
        ('credentials', 'a@a.com', 'a@a.com', 'ADMIN', 'Admin2', 'Admin2'),
        ('credentials', 'adam@adam.com', 'adam@adam.com', 'USER', 'Adam', 'Czymsz');

INSERT INTO passwordInfo (providerId, providerKey, hasher, password, salt)
VALUES ('credentials', 'admin@admin.com', 'bcrypt-sha256', '$2a$10$CCM/jSUIAR4.I0hy/V51ZerhzZhgRQoUwAxLGuQCHGagryKTl76bq', null),
       ('credentials', 'a@a.com', 'bcrypt-sha256', '$2a$10$ZumxW1dcdarwfqpFihGe7OrZPGxRqTDjPAHxnME1Uz9GUOkkbtpvm', null),
       ('credentials', 'adam@adam.com', 'bcrypt-sha256', '$2a$10$tXKUwHCpYRqVfKqysEQeYe6wEbrkUDKNICxsVIVunyGbruJ0zhtbO', null);

INSERT INTO authToken (userId)
VALUES (1), (2), (3);
# --- !Downs