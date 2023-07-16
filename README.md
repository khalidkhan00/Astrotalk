# Astrotalk
You have to just clone this this code in your desktop using github deskptop or use the command and open the the mysql workbench create data base (mydb) because I have that name only and run thi application ..All the end point are working properly If you have any doubt please contact me

I have build up the application so that User Can Sign up and Sign In and all the end point are secured  like adding  new patient ,discharging new patient ,fetch all the admitted patient I mean only the authorized person can play with all the end point 
For NewUser you have to use this end point in your postman for signUp(http://localhost:8080/sample/signup)use POST for this endpoint  in your postman
{
   "user":"piu",
   "password":"piu",
   "roles":"STAFF"
}
If you are a existing user you have to use this end point(http://localhost:8080/sample/login)use POST for this endpoint  in your postman
{
   "username":"piu",
   "password":"piu"
}
If you  want to add new patient you have first signIn so that you can have authorzation for adding new patient you have to use this end point(http://localhost:8080/patient/newPatient) use POST for this endpoint  in your postman
{
   
       "name": "rahul",
       "age": 35,
       "room": "A101",
       "doctorName": "Dr King",
       "admitDate": "2023-07-16",
       "expenses": 2000.0,
       "status": "admitted"
}
If you want to see all the admitted patient you have to use this end point(http://localhost:8080/patient/admitPatient) used GET for this end point in your postman
If you want to discharge the patient you have to use this end point(http://localhost:8080/patient/{id}/discharge) used DELETE for this end point  in your postman
