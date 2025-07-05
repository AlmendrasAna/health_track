# 🩺 Resumen caso HealthTrack – Plataforma de Monitoreo de Peso

**HealthTrack** es una plataforma web que permite a los usuarios registrar y actualizar su peso corporal cada 48 horas. 

---

## 🛠 Problemas Detectados

- ❌ Error en la lógica de actualización de peso, el sistema descuenta automáticamente **1 kg** del valor ingresado.
- ⚠️ Ausencia de pruebas automatizadas:
  - Pruebas unitarias
  - Pruebas de integración
  - Pruebas de regresión
  - Pruebas de rendimiento
- 🔄 Falta de un pipeline de Integración y Entrega Continua (CI/CD).

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

# 🧪 Prueba de Regresión – HealthTrack

Una **prueba de regresión** tiene como objetivo verificar que una nueva funcionalidad o corrección no haya afectado negativamente las funcionalidades existentes del sistema.

### 🎯 Objetivos

- Validar que el peso ingresado por el usuario se almacene sin alteraciones.
- Confirmar que las funcionalidades principales del sistema siguen operando correctamente:
  - Registro de usuario
  - Inicio de sesión
  - Registro de peso
  - Visualización del historial de peso

### 🧪 Test de Regresión: `testActualizarPeso`

- Comando para correr el test
```
mvn test
```

Este test verifica que el método `actualizarPeso(double nuevoPeso)` actualiza correctamente el peso del usuario.  
Anteriormente, existía un error en el que el nuevo peso reemplazaba incorrectamente el valor anterior **restando un kilogramo**, en lugar de asignar el nuevo valor directamente.

Este test asegura que el peso se actualiza con precisión al nuevo valor proporcionado.

### 📌 Comportamiento esperado

- Al llamar a `usuario.actualizarPeso(130)`, el peso del usuario debe actualizarse exactamente a **130**.

### ✅ Validación

java
assertEquals(130, newPeso);
---
Consulta el archivo `monitoreo-peso/src/test/java/com/ejemplo/TestActualizarPeso.java` para más detalles.
