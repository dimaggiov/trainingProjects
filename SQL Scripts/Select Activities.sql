USE PersonalTrainer;
Select * FROM Exercise;

SELECT * FROM Client;

SELECT * FROM Client WHERE City = "Metairie";

SELECT * FROM Client WHERE ClientId = "818u7faf-7b4b-48a2-bf12-7a26c92de20c";

SELECT * FROM Goal;

SELECT Name, LevelId FROM Workout;

SELECT Name, LevelId, Notes FROM Workout WHERE LevelId = 2;

SELECT FirstName, LastName, City FROM Client WHERE City = "Metairie" OR City = "Kenner" OR City = "Gretna";

SELECT FirstName, LastName, BirthDate FROM Client WHERE YEAR(BirthDate) BETWEEN "1980" AND "1989";

SELECT * FROM Login WHERE SUBSTRING(EmailAddress, -3) = "gov";

SELECT * FROM Login WHERE SUBSTRING(EmailAddress, -3) != "com";

SELECT FirstName, LastName From Client WHERE BirthDate IS NULL;

SELECT Name FROM ExerciseCategory WHERE ParentCategoryId IS NOT NULL;

SELECT Name, Notes FROM Workout WHERE LevelID = 3 AND Notes LIKE "%you%";

SELECT FirstName, LastName, City FROM Client WHERE (SUBSTRING(LastName, 1) = "L" OR SUBSTRING(LastName, 1)  = "M" OR SUBSTRING(LastName, 1))  = "N" AND City = "LaPlace";

SELECT InvoiceId, Description, Price, Quantity, ServiceDate, Price*Quantity AS Item_Line_Total FROM InvoiceLineItem WHERE Price*Quantity BETWEEN 15 AND 25; 

SELECT Client.* , Login.* FROM Client INNER JOIN Login ON Client.ClientID = Login.ClientId WHERE FirstName = "Estrella" AND LastName = "Bazely";

SELECT Workout.WorkoutId, WorkoutGoal.GoalID, Goal.Name 
FROM Workout
INNER JOIN WorkoutGoal ON WorkoutGoal.WorkoutID = Workout.WorkoutID
INNER JOIN Goal ON Goal.GoalID = WorkoutGoal.GoalID
WHERE Workout.Name = "This Is Parkour";