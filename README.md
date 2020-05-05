# vinita_rms
#1. insert/save Employee
POST: http://localhost:8082/addUser
input json
----------
{
"firstName":"prabin",
"lastName":"pattanaik",
"mobile":"702477200",
"email":"prabin1@gmail.com",
"empId":"E-1025",
"grade":"C",
"alternateMobile":"",
"userType":{
           "userType":"ADMIN"
         },

"projectList":[
			{
           "projectName":"Medical",
		    "startDate":"2018-01-27",
			 "endDate":"2020-05-27",
			  "technologies":"Spring,microservice"
        	 }
         ]

}

#2. edit Employee/resource
PUT: http://localhost:8082/editUser
input json:
----------
{
"firstName":"Amit",
"lastName":"Gupta",
"mobile":"9999955461",
"empId" : "E-1024",
"email":"amit@gmail.com",
"grade":"C",
"alternateMobile":"",
"isRolledOff":true,
"userType":{
           "userType":"ADMIN"
         },

"projectList":[{
           "projectName":"DALMIA",
		    "startDate":"2019-12-27",
			 "endDate":"2020-12-27",
			  "technologies":"Spring,microservice"
         }
         ]

}

#3. Get employee By id
GET: http://localhost:8082/getByEmpId/E-1024

#4. Get All employee list
GET: http://localhost:8082/getAllEmp

