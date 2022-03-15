USE vinylrecordshop;

INSERT INTO album 
VALUES (1,'Imagine','Apple','1971-9-9',9.99);

INSERT INTO album (albumTitle, releaseDate, price, label)
VALUES ('2525 (Exordium & Terminus)', '1969-7-1', 25.99, 'RCA');

INSERT INTO album (albumTitle, releaseDate, price, label)
VALUES 
	ROW ("No One's Gonna Change Our World", '1969-12-12', 39.95,'Regal Starline'), 
	ROW ('Moondance Studio Album', '1969-8-1',14.99,'Warner Bros'),
    ROW ('Clouds', '1969-5-1',9.99,'Reprise'),
    ROW ('Sounds of Silence Studio Album', '1966-1-17',9.99,'Columbia'),
    ROW ('Abbey Road', '1969-1-10',12.99,'Apple'),
    ROW ('Smiley Smile', '1967-9-18',5.99,'Capitol');
    
DELETE FROM album
WHERE albumID = 5;

INSERT INTO album (albumTitle, releaseDate, price, label)
VALUES ("Clouds", '1969-5-1', 9.99,'Reprise'); 

USE vinylrecordstore;
UPDATE album 
	SET albumId = 5
WHERE albumTitle = 'Clouds';

USE vinylrecordstore;
UPDATE album 
	SET albumId = 9
WHERE albumTitle = 'Smiley Smile';