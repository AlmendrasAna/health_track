# 🩺 Resumen caso HealthTrack – Plataforma de Monitoreo de Peso

**HealthTrack** es una plataforma web que permite a los usuarios registrar y actualizar su peso corporal cada 48 horas. 

---
## 📊 Análisis del Estado Actual de la Plataforma

### 🐞 Descripción del Error en la Lógica del Código

La plataforma presentaba un error crítico en el método encargado de actualizar el peso del usuario:  
cada vez que se registraba un nuevo peso, el sistema **restaba automáticamente 1 kg** al valor ingresado, en lugar de almacenarlo exactamente como fue proporcionado.

### ⚠️ Impacto del Error en la Experiencia del Usuario

- Los usuarios veían un **peso incorrecto** reflejado en su historial.
- Generaba **confusión y desconfianza** en la plataforma.
- Podía afectar negativamente el seguimiento de metas de salud y generar **informes inexactos**.

### 🔍 Falta de Procesos de Validación y Pruebas

- No se contaba con pruebas automatizadas:
  -  Pruebas unitarias
  -  Pruebas de integración
  -  Pruebas funcionales
  -  Pruebas de regresión
  -  Pruebas de rendimiento
-  Falta de un pipeline de Integración y Entrega Continua (CI/CD).
- La ausencia de estas prácticas provocó que el error llegara a producción sin ser detectado a tiempo.

---

## 🎯 Objetivos del Proyecto

- ✅ Corregir el error de actualización de peso.
- 🧪 Implementar una estrategia de pruebas automatizadas:
  - Unitarias
  - De integración
  - Funcionales
  - De regresión
  - De rendimiento
- 🚀 Establecer un pipeline CI/CD que:
  - Ejecute pruebas automáticamente con cada cambio.
  - Asegure la calidad antes del despliegue.
- 🧑‍💻 Fomentar buenas prácticas de desarrollo.

---

## 🛠️ Herramientas Utilizadas

| Propósito                     | Herramienta                        |
|------------------------------|------------------------------------|
| Automatización de pruebas    | JUnit, Selenium, JMeter            |
| Control de versiones         | Git + GitHub                       |
| Gestión de dependencias      | Maven                              |
| CI/CD                        | GitHub Actions                     |
| Análisis de calidad          | SonarQube                          |

---
## 🧪 Pruebas unitarias: `UsuarioTest`

Esta clase contiene pruebas unitarias para verificar el comportamiento básico del modelo `Usuario`. Las pruebas aseguran que los métodos principales de la clase funcionen correctamente y que los datos del usuario se manejen como se espera.

### ✅ Métodos probados

| Método             | Propósito                                                                 |
|--------------------|--------------------------------------------------------------------------|
| `getPeso()`        | Verifica que el peso inicial del usuario se obtenga correctamente.       |
| `getNombre()`      | Verifica que el nombre del usuario se obtenga correctamente.             |
| `actualizarPeso()` | Asegura que el método actualiza correctamente el peso del usuario.       |

### 🧪 Detalles de cada test

- **`testGetPeso`**  
  Comprueba que el método `getPeso()` devuelve el peso inicial (`150`) correctamente.

- **`testGetNombre`**  
  Verifica que el método `getNombre()` devuelve el nombre `"Maria"` como se espera.

- **`testActualizarPeso`**  
  Asegura que el método `actualizarPeso(130)` actualiza el peso del usuario a `130`.  
  Este test también actúa como una prueba de regresión para evitar errores anteriores en la lógica de actualización.

### 🛠️ Cómo ejecutar los tests

```bash
mvn test
```

- Consulta el archivo `monitoreo-peso/src/test/java/com/ejemplo/TestActualizarPeso.java` para más detalles.
---
## 🧪 Pruebas de Regresión: `testActualizarPeso`

Esta prueba verifica que el método `actualizarPeso(double nuevoPeso)` actualiza correctamente el peso del usuario.  
Anteriormente, existía un error en el que el nuevo peso reemplazaba incorrectamente el valor anterior **restando un kilogramo**, en lugar de asignar el nuevo valor directamente.

Este test asegura que el peso se actualiza con precisión al nuevo valor proporcionado.

### 📌 Comportamiento esperado

- Al llamar a `usuario.actualizarPeso(130)`, el peso del usuario debe actualizarse exactamente a **130**.

### ✅ Validación

java
assertEquals(130, newPeso);

### 🛠️ Cómo ejecutar los tests

```bash
mvn test
```

- Consulta el archivo `monitoreo-peso/src/test/java/com/ejemplo/TestActualizarPeso.java` para más detalles.

> Una **prueba de regresión** tiene como objetivo verificar que una nueva funcionalidad o corrección no haya afectado negativamente las funcionalidades existentes del sistema.
---
## 🚀 Pruebas funcional: `FlujoUsuario` (Selenium en Firefox)

Esta prueba automatizada simula el flujo completo de interacción de un usuario con el formulario web de la aplicación. Utiliza **Selenium WebDriver** con Firefox para validar que el proceso de ingreso y envío de datos funcione correctamente desde el navegador.

### 🔍 ¿Qué verifica?

- Acceso correcto al formulario web (`/formulario`)
- Ingreso de nombre y peso en los campos correspondientes
- Envío exitoso del formulario
- Visualización de un mensaje de confirmación que contiene la palabra `"Gracias"`

### 🧪 Pasos simulados

1. Abrir el navegador Firefox
2. Navegar a `http://localhost:8080/formulario`
3. Ingresar `"Juan Pérez"` en el campo de nombre
4. Ingresar `"70"` en el campo de peso
5. Hacer clic en el botón de envío
6. Verificar que el mensaje de éxito sea visible y contenga `"Gracias"`

### ✅ Resultado esperado

Si el flujo es exitoso, se imprime en consola:

- ✅ Prueba exitosa: Datos enviados correctamente.

En caso de error o comportamiento inesperado, se imprime un mensaje de error con detalles.

### ⚙️ Requisitos

- Tener [geckodriver](https://github.com/mozilla/geckodriver/releases) instalado y accesible desde el `PATH`
- Tener Firefox instalado
- La aplicación debe estar corriendo localmente en `http://localhost:8080`

### 🛠️ Cómo ejecutar los test

Compila y ejecuta la clase `FlujoUsuario` desde tu entorno de desarrollo o línea de comandos:

```bash
mvn test
```
- Consulta el archivo `monitoreo-peso/src/test/java/com/ejemplo/FlujoUsuarioSelenium` para más detalles.
---

## 🚀 Pruebas de Rendimiento: Envío de Peso con JMeter

Este Pruebas de rendimiento, simula múltiples usuarios enviando su peso corporal a la API de HealthTrack para evaluar la capacidad del sistema para manejar múltiples solicitudes concurrentes de actualización de peso sin pérdida de rendimiento ni errores en la respuesta.

### 🧪 Configuración del Pruebas

- **Usuarios simulados:** 10 usuarios concurrentes.
- **Ramp-up time:** 5 segundos (tiempo en que los 10 usuarios inician gradualmente).
- **Petición simulada:** `POST /api/peso`
- **Payload:** 
  ```json
  {
    "nombre": "usuario1",
    "peso": 72.5
  }
  ```

### 📈 Qué mide esta prueba

- Capacidad del backend para procesar múltiples registros de peso al mismo tiempo.

- Tiempo de respuesta por solicitud.

- Tasa de éxito o errores HTTP bajo carga simultánea.

- Validación de estabilidad del endpoint /peso frente a tráfico concurrente.

- Esta prueba ayuda a garantizar que la plataforma es escalable y que los usuarios pueden reportar su peso sin interrupciones, incluso bajo condiciones de uso intensivo.

### 🛠️ Cómo ejecutar los test
```bash
mvn verify
```
- Consulta el archivo `monitoreo-peso/src/test/java/com/ejemplo/testRendimientoJmeter.jmx` para más detalles.
---
# 🔧 CI Pipeline - Maven + Selenium + JMeter + SonarQube

## 🟢 Activadores del Pipeline

Este pipeline se ejecuta automáticamente en los siguientes eventos:

- Push sobre la rama `main`
- Pull Request hacia la rama `main`

---

## 🔄 Fases principales del pipeline (`build-test`)

- Sistema operativo: `ubuntu-latest`

---

## 🔤 Pasos del Pipeline

### 1. Checkout del código fuente
Clona el repositorio para acceder al código y ejecutarlo.

### 2. Configuración de entorno
- Instala **Java 17 (Temurin)**.
- Instala el navegador **Mozilla Firefox** (requerido para pruebas con Selenium).

### 3. Cache de dependencias Maven
- Utiliza cache para optimizar y acelerar la instalación de dependencias Maven.

### 4. Compilación del proyecto (sin tests)
```bash
mvn clean install -DskipTests
```
### 5. Ejecución de pruebas unitarias y pruebas funcionales 

```bash
mvn clean test
```

### 6. Instalación de JMeter

Descarga y configura Apache JMeter 5.6.3 para pruebas de rendimiento.

### 7. Ejecución de pruebas de rendimiento con JMeter

Ejecuta las pruebas definidas en el pom.xml:

mvn verify

### 8. (Comentado) Análisis con SonarQube

El análisis de calidad de código está configurado pero actualmente comentado.

mvn sonar:sonar  # Requiere configuración previa y token de SonarQube

### 9. Publicación de resultados

Se publican los siguientes reportes:

    📄 Reporte de JMeter:
    target/reporte/

    📄 Reportes de pruebas Surefire (JUnit):
    target/surefire-reports/
