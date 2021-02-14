INSERT INTO pet_type values(1, "cat");
INSERT INTO pet_type values(2, "bird");
INSERT INTO pet_type values(3, "lizard");
INSERT INTO pet_type values(4, "hamster");
INSERT INTO pet_type values(5, "snake");
INSERT INTO pet_type values(6, "dog");

INSERT INTO vet VALUES(1, "James Carter");
INSERT INTO vet VALUES(2, "Helen Leary");
INSERT INTO vet VALUES(3, "Linda Douglas");
INSERT INTO vet VALUES(4, "Rafael Ortega");
INSERT INTO vet VALUES(5, "Henry Stevens");
INSERT INTO vet VALUES(6, "Sharon Jenkins");

INSERT INTO speciality VALUES(1, "radiology");
INSERT INTO speciality VALUES(2, "dentistry");
INSERT INTO speciality VALUES(3, "surgery");

INSERT INTO vet_speciality VALUES(1, 1, 2);
INSERT INTO vet_speciality VALUES(2, 2, 3);
INSERT INTO vet_speciality VALUES(3, 3, 3);
INSERT INTO vet_speciality VALUES(4, 3, 4);
INSERT INTO vet_speciality VALUES(5, 1, 5);