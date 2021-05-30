# Demo de llamadas a un API REST con Spring

Cada 30" llama a un API, la interpreta como una clase del modelo e imprime por consola

- Usa un método con @Scheduled para ejecutar lo lógica cada cierto tiempo
- Usa WebClient (de Spring) para hacer la llamada a https://cat-fact.herokuapp.com/facts e interpretar el JSON de respuesta
- Imprime los objetos

El JSON de la respuesta es algo así:
```json
[
   {
      "status":{
         "verified":true,
         "sentCount":1
      },
      "type":"cat",
      "deleted":false,
      "_id":"58e008800aac31001185ed07",
      "user":"58e007480aac31001185ecef",
      "text":"Wikipedia has a recording of a cat meowing, because why not?",
      "__v":0,
      "source":"user",
      "updatedAt":"2020-08-23T20:20:01.611Z",
      "createdAt":"2018-03-06T21:20:03.505Z",
      "used":false
   },
   {
      "status":{
         "verified":true,
         "sentCount":1
      },
      "type":"cat",
      "deleted":false,
      "_id":"58e008630aac31001185ed01",
      "user":"58e007480aac31001185ecef",
      "text":"When cats grimace, they are usually \"taste-scenting.\" They have an extra organ that, with some breathing control, allows the cats to taste-sense the air.",
      "__v":0,
      "source":"user",
      "updatedAt":"2020-08-23T20:20:01.611Z",
      "createdAt":"2018-02-07T21:20:02.903Z",
      "used":false
   }
]
```


### Ejecucion
Tiene maven embebido en el projecto. Si no lo tenés instalado, sólo hay que ejecutar desde una consola `./mvnw spring-boot:run`