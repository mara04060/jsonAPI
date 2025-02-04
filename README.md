2. API частина - MSTest / NUnit + NewtonsoftJSON.
<br />
Переменные связанные с окружением вынести в файл конфигурации, не используя хард код внутри тестов.
<br />
<br />method: POST
<br />base URL:  https://test.lan
<br />Endpoint: /client
<br />Request headers:
<br />{
<br />  "Content-Type": "application/json"
<br />}
<br />Body request:
<br />{
<br />  "name": "string",
<br />  "email": "string",
<br />  "balance": 0  // int
<br />}
<br />
<br />--------
<br />Status code:
<br />200
<br />Response body:
<br />{
<br />  "id": 0, // int
<br />  "name": "string",
<br />  "email": "string",
 <br /> "balance": 0 // int
<br />}

<b />- Написати тестові функції для умовної точки API.</b>
