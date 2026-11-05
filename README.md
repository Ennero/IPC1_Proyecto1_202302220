# Gestión de pacientes, doctores y citas en Java Swing

Aplicación académica de gestión clínica con interfaces para pacientes, doctores y administración, registro de productos y consulta de citas. Usa Swing y gráficas JFreeChart.

## Requisitos

JDK 21 y Maven. Se conserva la estructura NetBeans original; el pom.xml permite resolver JFreeChart/JCommon sin depender de la carpeta Downloads de una computadora.

## Ejecución

Los comandos parten de la raíz del repositorio, salvo donde se indica otra terminal.

```bash
cd Proyecto1
mvn compile
mvn exec:java
```

## Recorrido de demostración

La clase principal proyecto1.Proyecto1 abre Inicio. Usar los formularios de registro y los paneles para consultar doctores, productos y citas. Los datos de esta entrega se mantienen en las estructuras de la aplicación.

## Organización

Carpetas de la entrega: [`Proyecto1/`](Proyecto1/).

## Alcance y límites

Es una demostración académica con almacenamiento en memoria; no es un sistema clínico para uso con datos reales. No implementa un juego 2D. El tema visual JTattoo es opcional: Swing conserva un tema disponible si no está instalado.

## Contexto y licencia

Trabajo académico o de aprendizaje conservado en el portafolio de [Enner Mendizabal](https://github.com/Ennero). Los créditos de los trabajos en grupo se conservan en sus entregas y manuales.

Consultar [LICENSE](LICENSE) para la licencia de la raíz. Las dependencias y los componentes con avisos o licencias propios conservan sus condiciones.

Para usar el proyecto Ant/NetBeans original, ejecutar primero `mvn dependency:copy-dependencies` desde Proyecto1. Las referencias de bibliotecas ahora apuntan a target/dependency, sin rutas de Downloads. El flujo principal de esta guía usa Maven.
