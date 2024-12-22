
# Project Aadvanced Programming Topics

As a project I created a taxi service using microservices paradime.

## Shema

![image](https://github.com/user-attachments/assets/6bc8f141-649d-4983-b55a-fac40a8a83ee)

## routes

| **Entity** | **HTTP Method** | **Route**          | **Description**                |
|------------|-----------------|--------------------|--------------------------------|
| **Cars**   | `GET`           | `/cars`            | Retrieves all cars             |
|            | `GET`           | `/car/{id}`        | Retrieves a specific car by ID |
|            | `DELETE`        | `/car/{id}`        | Deletes a specific car by ID   |
|            | `PUT`           | `/car/{id}`        | Updates a specific car by ID   |
|            | `POST`          | `/car`             | Creates a new car              |
| **Tour**   | `GET`           | `/tour`            | Retrieves all tours            |
| **Driver** | `GET`           | `/driver`          | Retrieves all drivers          |
|            | `GET`           | `/driver/{id}`     | Retrieves a specific driver by ID | 

## Cars

![image](https://github.com/user-attachments/assets/845fee79-d5a8-4c9d-88fa-7bb08782e88d)

The un autherized egt request

![image](https://github.com/user-attachments/assets/1d72aac7-642e-44e6-be8d-3fd634f6c108)

Get by id

![image](https://github.com/user-attachments/assets/8ae1b4e8-82d0-4f15-9123-8da42738047c)
Proche post

![image](https://github.com/user-attachments/assets/83523d93-bf8f-493c-b821-6ee61de09add)
Mercedes delete

![image](https://github.com/user-attachments/assets/76f47bee-c2bb-4e7b-9cf7-d5e9d41d075b)
Bmw put to I series from m4

![image](https://github.com/user-attachments/assets/0d41ee42-57af-4484-a325-786f710a6dbe)
get na changes

## Tours

![image](https://github.com/user-attachments/assets/f9d1a6ec-80b9-4052-aa65-961ac9d85028)
Get Tours

[
    {
        "id": 1,
        "car": {
            "id": "676872a6ec2c6b76506df4d4",
            "plate": "ABC-123",
            "model": "I-series",
            "brand": "BMW",
            "odometer": 69
        },
        "driver": {
            "id": 1,
            "firstName": "Jan",
            "lastName": "Vertongen",
            "licenceNumber": "32178462",
            "profilePicture": "https://images.pexels.com/photos/1704488/pexels-photo-1704488.jpeg?cs=srgb&dl=pexels-sulimansallehi-1704488.jpg&fm=jpg"
        },
        "name": "Mol to Geel",
        "price": 24.24
    }
]

## Driver

![image](https://github.com/user-attachments/assets/d89060c9-785f-455b-bb84-7bea1702cf06)
Get drivers


[
    {
        "id": 1,
        "firstName": "Jan",
        "lastName": "Vertongen",
        "licenceNumber": "32178462",
        "profilePicture": "https://images.pexels.com/photos/1704488/pexels-photo-1704488.jpeg?cs=srgb&dl=pexels-sulimansallehi-1704488.jpg&fm=jpg"
    },
    {
        "id": 2,
        "firstName": "Jane",
        "lastName": "Tesla",
        "licenceNumber": "24324242",
        "profilePicture": "https://newprofilepic.photo-cdn.net//assets/images/article/profile.jpg?90af0c8"
    }
]
![image](https://github.com/user-attachments/assets/602c7f26-841a-4fa2-b7e6-0289d09fb1bf)
get driver by id
{
    "id": 2,
    "firstName": "Jane",
    "lastName": "Tesla",
    "licenceNumber": "24324242",
    "profilePicture": "https://newprofilepic.photo-cdn.net//assets/images/article/profile.jpg?90af0c8"
}

