# User API Spec

## Register User

Endpoint : POST /api/users

Request Body :

```json
{
  "kd_user" : "puttam",
  "password" : "pututampan",
  "name" : "Putu Tampan"
}
```

Response Body (Success) :

```json
{
  "data" : "OK"
}
```

Response Body (Failed) :

```json
{
  "errors" : "Kode User tidak boleh kosong, ???"
}
```

## Login User

Endpoint : POST /api/auth/login

Request Body :

```json
{
  "kd_user" : "puttam",
  "password" : "rahasia" 
}
```

Response Body (Success) :

```json
{
  "data" : {
    "token" : "TOKEN",
    "expiredAt" : 2342342423423 // milliseconds
  }
}
```

Response Body (Failed, 401) :

```json
{
  "errors" : "Kode User or password wrong"
}
```

## Get User

Endpoint : GET /api/users/current

Request Header :

- X-API-TOKEN : Token (Mandatory) 

Response Body (Success) :

```json
{
  "data" : {
    "kd_user" : "puttam",
    "name" : "Putu Tampan"
  }
}
```

Response Body (Failed, 401) :

```json
{
  "errors" : "Unauthorized"
}
```

## Update User

Endpoint : PATCH /api/users/current

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body : 

```json
{
  "name" : "Putu Tampan", // put if only want to update name
  "password" : "new password" // put if only want to update password
}
```

Response Body (Success) :

```json
{
  "data" : {
    "kd_user" : "puttam",
    "name" : "Putu Tampan"
  }
}
```

Response Body (Failed, 401) :

```json
{
  "errors" : "Unauthorized"
}
```

## Logout User

Endpoint : DELETE /api/auth/logout

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data" : "OK"
}
```
