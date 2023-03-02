### Para compilar usamos esto:

idlj -fall SMTS.idlj
javac SMTS/*.java Server.java AccountImpl.java Client.java
javac SMTS/*.


### Encender el servidor y el puerto
tnameserver -ORBInitialPort 1050
start java Server -ORBInitialPort 1050 -ORBInitialHost localhost

### Iniciar el cliente

**get balance /// '1111' is the user id
 java Client -ORBInitialPort 1050 -ORBInitialHost localhost balance 1111

**deposit
 java Client -ORBInitialPort 1050 -ORBInitialHost localhost deposit 100
 
**withdraw
 java Client -ORBInitialPort 1050 -ORBInitialHost localhost withdraw 400

** Para ver todos los comandos
 java Client -ORBInitialPort 1050 -ORBInitialHost localhost help 
** Para pagar los intereses
 java Client -ORBInitialPort 1050 -ORBInitialHost localhost payinterest
** Para pedir un prestamo
 java Client -ORBInitialPort 1050 -ORBInitialHost localhost giveloan
 
*** check the balance again
java Client -ORBInitialPort 1050 -ORBInitialHost localhost balance 1111

*** Apagar el servidor
java Client -ORBInitialPort 1050 -ORBInitialHost localhost shutdown
