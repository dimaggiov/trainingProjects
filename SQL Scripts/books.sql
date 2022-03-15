DROP DATABASE IF EXISTS books;
CREATE DATABASE books;
USE books;

CREATE TABLE author(
	authorId INT AUTO_INCREMENT NOT NULL,
    firstName VARCHAR(25),
    middleName VARCHAR(25),
    lastName VARCHAR(50) NOT NULL,
    gender VARCHAR(1),
    dateOfBirth DATETIME NOT NULL,
    dateOfDeath DATETIME,
    CONSTRAINT pk_author
		PRIMARY KEY (authorId)
);

CREATE TABLE formatTable(
	formatId INT AUTO_INCREMENT NOT NULL,
    formatName VARCHAR(12) NOT NULL,
    CONSTRAINT pk_format
		PRIMARY KEY (formatId)
);

CREATE TABLE genre(
	genreId INT AUTO_INCREMENT NOT NULL,
    genreName VARCHAR(25) NOT NULL,
    CONSTRAINT pk_genre
		PRIMARY KEY (genreId)
);

CREATE TABLE book(
	bookID INT AUTO_INCREMENT NOT NULL,
    title VARCHAR(100) NOT NULL,
    publicationDate DATETIME,
    CONSTRAINT pk_book
		PRIMARY KEY (bookId)
);

DROP TABLE IF EXISTS authorBook;
CREATE TABLE authorBook(
	authorId INT NOT NULL,
    bookId INT NOT NULL,
    CONSTRAINT fk_authorBook_author
		FOREIGN KEY (authorId)
        REFERENCES author(authorId),
	CONSTRAINT fk_authorBook_book
		FOREIGN KEY (bookId)
        REFERENCES book(bookId)
);

DROP TABLE IF EXISTS bookFormat;
CREATE TABLE bookFormat(
    bookId INT NOT NULL,
    formatId INT NOT NULL,
    price DOUBLE,
    quantityOnHand INT,
    CONSTRAINT fk_bookFormat_book
		FOREIGN KEY (bookId)
        REFERENCES book(bookId),
	CONSTRAINT fk_bookFormat_format
		FOREIGN KEY (formatId)
        REFERENCES formatTable(formatId)
);

DROP TABLE IF EXISTS bookGenre;
CREATE TABLE bookGenre(
	bookId INT NOT NULL,
    genreId INT NOT NULL,
    CONSTRAINT fk_bookGenre_book
		FOREIGN KEY (bookId)
        REFERENCES book(bookId),
	CONSTRAINT fk_bookGenre_genre
		FOREIGN KEY (genreId)
        REFERENCES genre(genreId)
);

