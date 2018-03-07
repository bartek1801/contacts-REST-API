# contacts-REST-API

ENDPOINTS
1) Add a new person: PUT/person
Request body:
{
    "firstName": "Janek",
    "lastName": "Nowak",
    "gender": "M",
    "birthDate": "1990-01-01",
    "pesel" : 90010122221
}

2) Get person: GET/person/{personId}

3) Delete person: DELETE/person/{personId}

4) Update person details: DELETE/person/update
Request body:
{
    "firstName": "Jan",
    "lastName": "Nowak",
    "gender": "M",
    "birthDate": "1990-01-01",
    "pesel" : 90010122222
}

5) Add contact to person: PUT/contact/{personId}
RequestBody:
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

6) Get person contact: GET/person/{personId}
