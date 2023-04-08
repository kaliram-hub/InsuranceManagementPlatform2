# InsuranceManagementPlatform2 [check master branch]
Technology Used: SpringBoot, Spring Data JPA, H2 InMemory DB, Starter Security, Starter Test, Validation, lombok
Here is the Insurance Management Platform where we can do the CRUD functions for the Client , Insurance Policy and Claims.
Implemented CRUD functions for Entities: Client , Insurance Policy and Claims Where All the entities interlink to eachother..
Implemented Global Exception Handling  and validation to ensure proper API usage and data
integrity.
Implemented Unit Test with Mockito for service layer.
Implemented Basic Auth Spring Security (5.4 ) without the WebSecurityConfigurerAdapter .
By the help of SecurityFilterChain Implemented basic Authentication and Authorization to secure the  REST APIs endpoints.
All the API's developed as per the requirement Please go through it. Thanks.
🚗How to Run It Locally?
You can download the Project and can run it locally . 
The API's are secure , so you can find the user name and password form SecurityConfig.java class.

Here is one Demonstration 🐞:
[
    {
        "clientId": 3,
        "name": "kaliram",
        "dob": "1992-12-21T00:00:00.000+00:00",
        "address": "spice garden layout",
        "contact": 700895623,
        "insurancePolicy": [
            {
                "policyId": 4,
                "policyNumber": 30456,
                "type": "general",
                "coverageAmount": 500000,
                "premium": "premium",
                "startDate": "2023-04-04T00:00:00.000+00:00",
                "endDate": "2033-04-03T00:00:00.000+00:00",
                "claim": {
                    "claimId": 2,
                    "claimNumber": 245567861,
                    "description": "process is under active",
                    "claimDate": "2022-05-16T00:00:00.000+00:00",
                    "claimStatus": "active"
                }
            },
            {
                "policyId": 5,
                "policyNumber": 30556,
                "type": "health",
                "coverageAmount": 700000,
                "premium": "platinum",
                "startDate": "2023-04-04T00:00:00.000+00:00",
                "endDate": "2033-04-03T00:00:00.000+00:00",
                "claim": {
                    "claimId": 3,
                    "claimNumber": 245567862,
                    "description": "process is under maintainance",
                    "claimDate": "2022-05-16T00:00:00.000+00:00",
                    "claimStatus": "deactive"
                }
            }
        ]
    },
    {
        "clientId": 4,
        "name": "sandeep",
        "dob": "1992-12-21T00:00:00.000+00:00",
        "address": "spice garden layout",
        "contact": 700895623,
        "insurancePolicy": [
            {
                "policyId": 6,
                "policyNumber": 30345,
                "type": "health",
                "coverageAmount": 500000,
                "premium": "premium",
                "startDate": "2023-04-04T00:00:00.000+00:00",
                "endDate": "2033-04-03T00:00:00.000+00:00",
                "claim": {
                    "claimId": 4,
                    "claimNumber": 25896524,
                    "description": "process is under active",
                    "claimDate": "2022-05-16T00:00:00.000+00:00",
                    "claimStatus": "active"
                }
            }
        ]
    }
]
