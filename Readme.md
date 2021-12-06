#Command to get and run AirService from DockerHub
curl -L https://github.com/AndriyGu/AirServiceTask/archive/refs/tags/v1.tar.gz | tar xz && cd AirServiceTask-1 && docker compose up --build

# Project launch:Linc to swagger
http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config/

#Contains Postman Collection
# in project directory
AirCompanyTest.postman_collection.json

#Number in Postman collection match to number in task.pdf

2) Endpoint to move airplanes between companies (simple endpoint to reassign airplane to
   another company).
3) Endpoint to find all Air Company Flights by status (use company name for identification
   of Air Company).
4) Endpoint to find all Flights in ACTIVE status and started more than 24 hours ago.
5) Endpoint to add new Airplane (Could be assign to a company immediately or moved
   later).
6) Endpoint to add new Flight (set status to PENDING)
7) Endpoint to change Flight status:
   if status to change is DELAYED – set delay started at
   if status to change is ACTIVE – set started at
   if status to change is COMPLETED set ended at
8) (Optional) Endpoint to find all Flights in COMPLETED status and difference between
   started and ended time is bigger than estimated flight time.

### Access is made from the local server to the following addresses:
* #####   Backend:      http://localhost:8080/
  
### Adminer setting for databases access:
#####  - MySQL
      Server:	mysql
      User:	    geouser
      Password:	1234
      Database:	airservice_db


