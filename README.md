# contacts-REST-API

## ENDPOINTS 

The swagger is running under
<pre>
http://localhost:8080/swagger-ui.html
<pre>

1) Add a new person: POST/person

Request body:
```
{ 
	"firstName": "Janek",
	"lastName": "Nowakowski", 
	"gender": "M", 
	"birthDate": "1990-01-01",
	"pesel" : 90010122220 
}
```

2) Get person: GET/person/{personId}

3) Delete person: DELETE/person/{personId}

4) Update person details: PUT/person/{personId}

Request body:
```
{ 
	"firstName": "Janek",
	"lastName": "Nowak", 
	"gender": "M", 
	"birthDate": "1990-01-01",
	"pesel" : 90010122220 
}
```

5) Add contact to person: POST/contact/{personId}

RequestBody:
```
{
	"phoneNumbers": [
		"123 456 789",
		"987 654 321"
		],
	"emailAddresses": [
		"sample@mail.com",
		"test@mail.com"
		],
	"addresses":[
		{
			"street": "Warszawska 10",
			"postalCode": "20-500",
			"city": "Lublin"
		},
		{
			"street": "Lubelska 101",
			"postalCode": "01-500",
			"city": "Warszawa"
		}
		]
}
```

6) Get person contact: GET/person/{personId}

7) Update contact for person PUT/update/{personId}

Request Body:
```
{ 
	"phoneNumbers": [ 
		"123 456 789", 
		"000 000 000" 
		], 
	"emailAddresses": [ 
		"sample@mail.com", 
		"thirdMail@mail.com" ], 
	"addresses":[ 
		{ 
			"street": "Warszawska 101", 
			"postalCode": "20-500", 
			"city": "Lublin" 
			
		},
		{ 
			"street": "Lubelska 101", 
			"postalCode": "01-500", 
			"city": "Warszawa" 
			
		} 
		] 
	
}
```

8) Delete contact for person DELETE/delete/{personId}

9) Delete contact details PUT/delete/{personId}/details

Request body:
```
{ 
	"phoneNumbers": [ 
		"123 456 789", 
		"000 000 000" 
		], 
	"emailAddresses": [ 
		"sample@mail.com", 
		"thirdMail@mail.com" ], 
	"addresses":[ 
		{ 
			"street": "Warszawska 101", 
			"postalCode": "20-500", 
			"city": "Lublin" 
			
		},
		{ 
			"street": "Lubelska 101", 
			"postalCode": "01-500", 
			"city": "Warszawa" 
			
		} 
		] 
	
}
```




