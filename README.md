# Proyecto de implementación de una red eléctrica utilizando el paradigma de la orientación a objetos con "algo" de TDD y SCRUM

Iremos marcando cada uno de los sprints, cada sprint representa una historia de usuario y es un producto mínimo viable, entregable al cliente según la metodología SCRUM.

## 01
 - Tenemos aparatos que se encienden y se apagan

## 02
 - Cada aparato tiene un consumo cuando esta encendido (apagado no
consume nada)
 - Una red tiene un conjunto de aparatos enchufados
 - Cada red puede proporcionar un máximo de energía
 - Una red puede tener distintos sistemas de seguridad

## 03 
 - Un sistema de seguridad, al activarse, ha de mirar si el consumo de la
red es mayor al soportado.
 Si es así, ha de apagar los aparatos necesarios para volver a los
limites de seguridad.
 - Puede haber distintas implementaciones de sistemas de seguridad
(que apaguen primero los mas potentes, que apaguen primero los
menos potentes, etc...)

## 04
 - El sistema no puede apagar aparatos críticos (un tipo especial de
aparato). Estos solo se pueden apagar manualmente.
 - El sistema de seguridad tiene una alarma.

## 05
 - Puede haber muchos tipos de alarma (que envían SMS, que hacen
sonar un aparato, etc...). Todos funcionan igual: se activan y se
desactivan.
 - Si el sistema de seguridad no puede bajar el consumo por debajo del
nivel soportado, ha de activar el sistema de alarma.
 - El sistema de alarma no se alimenta de la red (no tiene un consumo,
como los aparatos)

## Tests unitarios

En cada uno de los sprints crearemos una batería de tests unitarios suficiente para asegurar la calidad de las clases.
