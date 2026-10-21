/*
 * P2A5 Ordenamiento (BS) - Estructuras de Datos y Algoritmos
 * Diego Kamil Olea Ruiz
 *
 * Ordena las temperaturas maximas registradas en Merida (septiembre 2026)
 * en orden ascendente y descendente usando Bubble Sort (ordenacion por
 * intercambio), siguiendo el algoritmo visto en clase: se usa una variable
 * "limite" que se reduce en cada pasada y una bandera "intercambio" que
 * termina el ciclo si en una pasada no hubo cambios.
 */
public class OrdenamientoBurbuja {

    // Cada registro guarda la temperatura y su fecha
    static class Registro {
        double temperatura;
        String fecha;

        Registro(double temperatura, String fecha) {
            this.temperatura = temperatura;
            this.fecha = fecha;
        }

        @Override
        public String toString() {
            return temperatura + ", " + fecha;
        }
    }

    // Bubble Sort: ascendente = true -> menor a mayor, false -> mayor a menor
    static void ordenamientoBurbuja(Registro[] datos, boolean ascendente) {
        int n = datos.length;
        int limite = n;
        boolean intercambio;

        while (limite > 1) {
            intercambio = false;

            for (int j = 0; j < limite - 1; j++) {
                boolean debeCambiar = ascendente
                        ? datos[j].temperatura > datos[j + 1].temperatura
                        : datos[j].temperatura < datos[j + 1].temperatura;

                if (debeCambiar) {
                    Registro temporal = datos[j];
                    datos[j] = datos[j + 1];
                    datos[j + 1] = temporal;
                    intercambio = true;
                }
            }

            // Si no hubo intercambios el arreglo ya esta ordenado
            if (!intercambio) {
                limite = 1;
            } else {
                limite = limite - 1;
            }
        }
    }

    static void imprimir(String titulo, Registro[] datos) {
        System.out.println(titulo);
        for (Registro r : datos) {
            System.out.println(r);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Temperaturas maximas en Merida, septiembre 2026 (°C)
        Registro[] temperaturas = {
            new Registro(39.0, "2 sep"),
            new Registro(39.0, "3 sep"),
            new Registro(35.0, "8 sep"),
            new Registro(35.0, "9 sep"),
            new Registro(35.0, "12 sep"),
            new Registro(37.0, "13 sep"),
            new Registro(35.0, "17 sep")
        };

        imprimir("Datos originales:", temperaturas);

        ordenamientoBurbuja(temperaturas, true);
        imprimir("Orden ascendente:", temperaturas);

        ordenamientoBurbuja(temperaturas, false);
        imprimir("Orden descendente:", temperaturas);
    }
}
