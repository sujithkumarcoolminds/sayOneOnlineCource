# sayOneOnlineCource
# Sayone Online Learning Portal
It is an online learning portal that will offer pocket friendly, advanced courses to students powerd by sayOne

## REST API Endpoints

```
  GET sayone/online-courses/{country_code}/courses/{course_id} - View courses details by id
    eg:  http://localhost:9091/sayone/online-courses/IND/courses/1
  
  Sample Response :
 {
   "status": 200,
   "message": "SUCCESS",
   "data": {
     "courseId": 1,
     "courseName": "Angular",
     "course_description": "Beginers guide to angular",
     "total_price": 159,
     "price_strategies": [
       {
         "strategyID": 1,
         "name": "subscription",
         "duration": 6
       },
       {
         "strategyID": 2,
         "name": "one_time_payment",
         "duration": 6
       }
     ],
     "price_components": [
       {
         "id": 1,
         "name": "tax",
         "value": 18.25
       },
       {
         "id": 2,
         "name": "base_price",
         "value": 140.75
       }
     ]
   }
 }

```
## How to  Run

  1. Install [MySQL]
  2. Configure datasource in `application.properties`.
  3. Import tables and mock data into database by executing `sql\sayone_online_cource.sql`.
  4. Run `mvn install`.
  5. Run `mvn spring-boot:run`.
  6. The server is running on [localhost:9091]().
  7. Run http://localhost:9091/swagger-ui.html
    eg:
        - Go to http://localhost:9091/swagger-ui.html#!/online-cource-controller/getCourseDetailsUsingGET
        - pass course_id & country_code in Parameters area of swagger-ui and click on Try it out button.
  8. pass course_id & country_code in Parameters area of swagger-ui
  9. Click on Try it out button.

  Or

  7. Run `curl http://localhost:9091/sayone/online-courses/IND/courses/1`

  
  ## Assumptions
  
  1. Every price components are fixed value.
  2. Course details are already validated and saved on database
  3. Duration of courses stored in no. of months.
