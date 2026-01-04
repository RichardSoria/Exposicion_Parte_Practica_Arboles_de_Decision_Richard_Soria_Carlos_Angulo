# Implementación Gráfica de Árboles de Decisión (ID3) en Java

Este proyecto es una implementación educativa del algoritmo **ID3 (Iterative Dichotomiser 3)** para la construcción y visualización dinámica de Árboles de Decisión. Desarrollado como parte de la asignatura de **Programación III** en la Universidad de las Américas (UDLA).

## 📋 Descripción

El aplicativo permite cargar conjuntos de datos (datasets) desde archivos CSV/Excel, procesarlos para calcular la **Entropía** y **Ganancia de Información**, y generar automáticamente un árbol de decisión interactivo.

El objetivo principal es demostrar la eficiencia de las estructuras jerárquicas (O(log n)) frente a las búsquedas lineales y aplicar patrones de diseño para la renderización gráfica recursiva.

### 🚀 Funcionalidades Principales
* **Motor de Inferencia ID3:** Cálculo automático de entropía para seleccionar el nodo raíz óptimo.
* **Visualización Recursiva:** Renderizado del árbol utilizando la librería `java.awt.Graphics2D`.
* **Exportación con Graphviz:** Generación de archivos `.dot` y conversión a imágenes JPG de alta calidad.
* **Interfaz Gráfica (Swing):** Panel de control para cargar archivos y visualizar resultados en tiempo real.

## 🛠️ Tecnologías y Requisitos

* **Lenguaje:** Java (JDK 21 recomendado).
* **Interfaz:** Java Swing.
* **Herramientas Externas:** [Graphviz](https://graphviz.org/) (Necesario para la exportación de diagramas).
* **IDE Recomendado:** IntelliJ IDEA / NetBeans.

## ⚙️ Instalación y Uso

1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com/RichardSoria/Exposicion_Parte_Practica_Arboles_de_Decision_Richard_Soria_Carlos_Angulo.git
    ```
2.  **Configurar Graphviz (Importante):**
    * Asegúrese de tener instalado Graphviz en su sistema.
    * Agregue la ruta `bin` de Graphviz a las **Variables de Entorno (PATH)** de su sistema operativo para permitir la generación de imágenes.
3.  **Ejecutar:**
    * Abra el proyecto en su IDE.
    * Ejecute la clase principal `Vista.java` (o `Main.java` según corresponda).
    * Cargue el archivo `farmaco.csv` o `suburbio.csv` incluido en la carpeta raíz para probar.

## 📂 Estructura del Proyecto

* `src/arbol/`: Lógica matemática (Nodos, Cálculo de Entropía).
* `src/vista/`: Interfaz gráfica y clase `Graficador` (Renderizado recursivo).
* `data/`: Archivos CSV de ejemplo para entrenamiento.

## ✒️ Autores y Créditos

### Desarrollo y Adaptación
Trabajo presentado para la materia de **Programación III**.
* **Richard Soria**
* **Carlos Angulo**

### Reconocimiento (Créditos Originales)
Este proyecto se basa en la lógica de implementación de árboles de decisión desarrollada por **Allen23(Luis Sarmiento)**, cuyo código fuente sirvió como base fundamental para el análisis del algoritmo ID3 y la lógica de graficación en Java. Agradecemos su aporte a la comunidad de código abierto que permitió el desarrollo de este estudio académico.

---
**Universidad de las Américas - Facultad de Ingeniería y Ciencias Aplicadas**
*Quito, Ecuador - 2024*
