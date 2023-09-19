# TEST FABRICK

### Ivan Napolitano

Il progetto è stato sviluppato utilizzando la versione 3.1.3 di Spring Boot

La versione di Java supportata è la 17

## INFO PROGETTO

Il progetto contiene un Controller Rest che esponse tre API:
    
    * /fabrick/getAccountBalance
    * /fabrick/createMoneyTransfer
    * /fabrick/getAccountTransactions

## Guida Avvio

* Settare la versione corretta di Java (SDK 17)
* Verificare il corretto import di tutte le dipendenze presenti nel **pom.xml**
* Lanciare il metodo main contenuto in **TestFabrickApplication.java**

## Test API

### /fabrick/getAccountBalance (GET)
#### Request

Query params

| Param | Value    | 
|-------|----------|
| accountID | 14537780 |

### /fabrick/createMoneyTransfer (POST)
#### Request

Body JSON

```json
{
    "accountId": 14537780,  
    "creditor": {
        "name": "John Doe",
        "account": {
            "accountCode": "IT23A0336844430152923804660"
        }
    },
    "executionDate": "2023-12-25",
    "description": "Test Money Transfer",
    "amount": 800,
    "currency": "EUR" 
}
```

### /fabrick/getAccountTransactions (GET)
#### Request

Query params

| Param | Value    | 
|-------|----------|
| accountID | 14537780 |
| fromAccountingDate | 2019-01-01 |
| toAccountingDate | 2019-12-01 |
