import java.util.Scanner;

public class ArbolBinarioMarvel {

    // ==========================================
    // CLASE NODO
    // ==========================================

    static class Nodo {

        int valor;
        String nombre;

        Nodo izquierdo;
        Nodo derecho;

        // Constructor para el arbol numerico
        Nodo(int valor) {
            this.valor = valor;
            this.nombre = null;
            this.izquierdo = null;
            this.derecho = null;
        }

        // Constructor para el arbol de nombres
        Nodo(String nombre) {
            this.nombre = nombre;
            this.izquierdo = null;
            this.derecho = null;
        }
    }

    // ==========================================
    // ARBOLES DEL PROGRAMA
    // ==========================================

    // Arbol de Yggdrasil
    static Nodo raizYggdrasil = null;

    // Arbol binario de busqueda
    static Nodo raiz = null;

    // Copia de seguridad del arbol BST
    static Nodo copia = null;


    // ==========================================
    // 1. ARBOL DE YGGDRASIL
    // ==========================================

    public static void crearYggdrasil(Scanner entrada) {

        System.out.println("\n--- CREAR ARBOL DE YGGDRASIL ---");

        System.out.print("Ingrese la raiz: ");
        String nombreRaiz = entrada.next();

        System.out.print("Ingrese el hijo izquierdo: ");
        String nombreIzquierdo = entrada.next();

        System.out.print("Ingrese el hijo derecho: ");
        String nombreDerecho = entrada.next();

        raizYggdrasil = new Nodo(nombreRaiz);

        raizYggdrasil.izquierdo =
                new Nodo(nombreIzquierdo);

        raizYggdrasil.derecho =
                new Nodo(nombreDerecho);

        System.out.println("\nARBOL CREADO:");

        System.out.println("       " + raizYggdrasil.nombre);
        System.out.println("       /       \\");
        System.out.println("   " + raizYggdrasil.izquierdo.nombre
                + "       " + raizYggdrasil.derecho.nombre);
    }


    // ==========================================
    // 2. INSERTAR EN EL ARBOL BST
    // ==========================================

    public static Nodo insertar(Nodo actual, int valor) {

        if (actual == null) {
            return new Nodo(valor);
        }

        if (valor < actual.valor) {

            actual.izquierdo =
                    insertar(actual.izquierdo, valor);

        } else if (valor > actual.valor) {

            actual.derecho =
                    insertar(actual.derecho, valor);

        } else {

            System.out.println("El valor ya existe.");
        }

        return actual;
    }


    // ==========================================
    // 3. BUSQUEDA BINARIA - HEIMDALL
    // ==========================================

    public static boolean buscar(Nodo actual, int valor) {

        if (actual == null) {
            return false;
        }

        if (actual.valor == valor) {
            return true;
        }

        if (valor < actual.valor) {

            return buscar(actual.izquierdo, valor);

        } else {

            return buscar(actual.derecho, valor);
        }
    }


    // ==========================================
    // 4. RECORRIDO INORDEN - STARK
    // IZQUIERDA - RAIZ - DERECHA
    // ==========================================

    public static void inOrden(Nodo actual) {

        if (actual != null) {

            inOrden(actual.izquierdo);

            System.out.print(actual.valor + " ");

            inOrden(actual.derecho);
        }
    }


    // ==========================================
    // 5. RESPALDO DE VISION - PREORDEN
    // CREAR UNA COPIA EXACTA DEL ARBOL
    // ==========================================

    public static Nodo clonarPreOrden(Nodo actual) {

        if (actual == null) {
            return null;
        }

        // Primero se copia la raiz
        Nodo nuevo = new Nodo(actual.valor);

        // Despues se copia el lado izquierdo
        nuevo.izquierdo =
                clonarPreOrden(actual.izquierdo);

        // Finalmente se copia el lado derecho
        nuevo.derecho =
                clonarPreOrden(actual.derecho);

        return nuevo;
    }


    // Recorrido PreOrden para mostrar la copia
    // RAIZ - IZQUIERDA - DERECHA

    public static void preOrden(Nodo actual) {

        if (actual != null) {

            System.out.print(actual.valor + " ");

            preOrden(actual.izquierdo);

            preOrden(actual.derecho);
        }
    }


    // ==========================================
    // 6. EXPLOSION DE SOKOVIA - POSTORDEN
    // DESTRUIR COMPLETAMENTE EL ARBOL
    // ==========================================

    public static Nodo destruirPostOrden(Nodo actual) {

        if (actual == null) {
            return null;
        }

        // Primero destruir el lado izquierdo
        actual.izquierdo =
                destruirPostOrden(actual.izquierdo);

        // Despues destruir el lado derecho
        actual.derecho =
                destruirPostOrden(actual.derecho);

        // Finalmente eliminar la raiz
        System.out.println(
                "Nodo eliminado: " + actual.valor);

        return null;
    }


    // ==========================================
    // 7. CONTAR NODOS - MULTIVERSO
    // ==========================================

    public static int contarNodos(Nodo actual) {

        if (actual == null) {
            return 0;
        }

        return 1
                + contarNodos(actual.izquierdo)
                + contarNodos(actual.derecho);
    }


    // ==========================================
    // 8. BUSCAR MENOR Y MAYOR - GEMAS
    // ==========================================

    public static int encontrarMenor(Nodo actual) {

        if (actual.izquierdo == null) {
            return actual.valor;
        }

        return encontrarMenor(actual.izquierdo);
    }


    public static int encontrarMayor(Nodo actual) {

        if (actual.derecho == null) {
            return actual.valor;
        }

        return encontrarMayor(actual.derecho);
    }


    // ==========================================
    // 9. CALCULAR ALTURA - TORRE STARK
    // ==========================================

    public static int calcularAltura(Nodo actual) {

        if (actual == null) {
            return 0;
        }

        int alturaIzquierda =
                calcularAltura(actual.izquierdo);

        int alturaDerecha =
                calcularAltura(actual.derecho);

        return 1 + Math.max(
                alturaIzquierda,
                alturaDerecha
        );
    }


    // ==========================================
    // 10. ELIMINAR NODO - CHASQUIDO
    // ==========================================

    public static Nodo eliminar(Nodo actual, int valor) {

        if (actual == null) {
            return null;
        }

        if (valor < actual.valor) {

            actual.izquierdo =
                    eliminar(actual.izquierdo, valor);

        } else if (valor > actual.valor) {

            actual.derecho =
                    eliminar(actual.derecho, valor);

        } else {

            // CASO 1: NODO SIN HIJOS

            if (actual.izquierdo == null &&
                    actual.derecho == null) {

                return null;
            }

            // CASO 2: NODO CON UN SOLO HIJO

            if (actual.izquierdo == null) {
                return actual.derecho;
            }

            if (actual.derecho == null) {
                return actual.izquierdo;
            }

            // CASO 3: NODO CON DOS HIJOS

            // Buscar el sucesor inorden
            int sucesor =
                    encontrarMenor(actual.derecho);

            actual.valor = sucesor;

            actual.derecho =
                    eliminar(actual.derecho, sucesor);
        }

        return actual;
    }


    // ==========================================
    // METODO PARA VERIFICAR SI EL BST ESTA VACIO
    // ==========================================

    public static boolean arbolVacio() {

        return raiz == null;
    }


    // ==========================================
    // PROGRAMA PRINCIPAL
    // ==========================================

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int opcion;
        int valor;

        do {

            System.out.println("\n");
            System.out.println("======================================");
            System.out.println("       ARBOL BINARIO MARVEL");
            System.out.println("======================================");

            System.out.println("1. Crear arbol de Yggdrasil");
            System.out.println("2. Insertar nivel de seguridad");
            System.out.println("3. Buscar amenaza");
            System.out.println("4. Recorrido InOrden");
            System.out.println("5. Respaldo de Vision (Clonar)");
            System.out.println("6. Destruir arbol (PostOrden)");
            System.out.println("7. Contar nodos");
            System.out.println("8. Encontrar menor y mayor");
            System.out.println("9. Calcular altura");
            System.out.println("10. Eliminar un nodo");
            System.out.println("0. Salir");

            System.out.println("======================================");

            System.out.print("Seleccione una opcion: ");

            opcion = entrada.nextInt();


            switch (opcion) {

                // --------------------------------
                // PUNTO 1
                // --------------------------------

                case 1:

                    crearYggdrasil(entrada);

                    break;


                // --------------------------------
                // PUNTO 2
                // --------------------------------

                case 2:

                    System.out.print(
                            "Ingrese el nivel de seguridad: ");

                    valor = entrada.nextInt();

                    if (buscar(raiz, valor)) {

                        System.out.println(
                                "El valor ya existe.");

                    } else {

                        raiz = insertar(raiz, valor);

                        System.out.println(
                                "Nivel insertado correctamente.");
                    }

                    break;


                // --------------------------------
                // PUNTO 3
                // --------------------------------

                case 3:

                    System.out.print(
                            "Ingrese la amenaza que desea buscar: ");

                    valor = entrada.nextInt();

                    if (buscar(raiz, valor)) {

                        System.out.println(
                                "La amenaza SI esta registrada.");

                    } else {

                        System.out.println(
                                "La amenaza NO esta registrada.");
                    }

                    break;


                // --------------------------------
                // PUNTO 4
                // --------------------------------

                case 4:

                    if (arbolVacio()) {

                        System.out.println(
                                "Primero debe insertar valores.");

                    } else {

                        System.out.println(
                                "Recorrido InOrden:");

                        inOrden(raiz);

                        System.out.println();
                    }

                    break;


                // --------------------------------
                // PUNTO 5
                // --------------------------------

                case 5:

                    if (arbolVacio()) {

                        System.out.println(
                                "No hay arbol para copiar.");

                    } else {

                        copia = clonarPreOrden(raiz);

                        System.out.println(
                                "Copia exacta creada correctamente.");

                        System.out.println(
                                "Recorrido PreOrden de la copia:");

                        preOrden(copia);

                        System.out.println();
                    }

                    break;


                // --------------------------------
                // PUNTO 6
                // --------------------------------

                case 6:

                    if (arbolVacio()) {

                        System.out.println(
                                "El arbol ya esta vacio.");

                    } else {

                        System.out.println(
                                "\nDestruyendo arbol mediante PostOrden:");

                        raiz = destruirPostOrden(raiz);

                        // Tambien se elimina la copia
                        if (copia != null) {

                            System.out.println(
                                    "\nEliminando copia de seguridad:");

                            copia = destruirPostOrden(copia);
                        }

                        System.out.println(
                                "\nEl arbol ha sido destruido.");

                        System.out.println(
                                "Cantidad de nodos restantes: "
                                        + contarNodos(raiz));
                    }

                    break;


                // --------------------------------
                // PUNTO 7
                // --------------------------------

                case 7:

                    System.out.println(
                            "\nNodos del arbol numerico: "
                                    + contarNodos(raiz));

                    System.out.println(
                            "Nodos del arbol Yggdrasil: "
                                    + contarNodos(raizYggdrasil));

                    System.out.println(
                            "Total de nodos en memoria del programa: "
                                    + (contarNodos(raiz)
                                    + contarNodos(raizYggdrasil)
                                    + contarNodos(copia)));

                    break;


                // --------------------------------
                // PUNTO 8
                // --------------------------------

                case 8:

                    if (arbolVacio()) {

                        System.out.println(
                                "El arbol numerico esta vacio.");

                    } else {

                        System.out.println(
                                "Gema de menor valor: "
                                        + encontrarMenor(raiz));

                        System.out.println(
                                "Gema de mayor valor: "
                                        + encontrarMayor(raiz));
                    }

                    break;


                // --------------------------------
                // PUNTO 9
                // --------------------------------

                case 9:

                    System.out.println(
                            "\n¿De cual arbol desea calcular la altura?");

                    System.out.println("1. Yggdrasil (nombres)");
                    System.out.println("2. Arbol BST (numerico)");

                    System.out.print("Seleccione: ");

                    int tipoArbol = entrada.nextInt();

                    if (tipoArbol == 1) {

                        if (raizYggdrasil == null) {

                            System.out.println(
                                    "Primero debe crear Yggdrasil.");

                        } else {

                            System.out.println(
                                    "Altura de Yggdrasil: "
                                            + calcularAltura(raizYggdrasil));
                        }

                    } else if (tipoArbol == 2) {

                        if (raiz == null) {

                            System.out.println(
                                    "Primero debe insertar valores.");

                        } else {

                            System.out.println(
                                    "Altura del arbol BST: "
                                            + calcularAltura(raiz));
                        }

                    } else {

                        System.out.println(
                                "Opcion de arbol incorrecta.");
                    }

                    break;


                // --------------------------------
                // PUNTO 10
                // --------------------------------

                case 10:

                    if (arbolVacio()) {

                        System.out.println(
                                "El arbol esta vacio.");

                    } else {

                        System.out.print(
                                "Ingrese el valor que desea eliminar: ");

                        valor = entrada.nextInt();

                        if (buscar(raiz, valor)) {

                            raiz = eliminar(raiz, valor);

                            System.out.println(
                                    "Nodo eliminado correctamente.");

                        } else {

                            System.out.println(
                                    "El valor no existe en el arbol.");
                        }
                    }

                    break;


                // --------------------------------
                // SALIR
                // --------------------------------

                case 0:

                    System.out.println(
                            "Programa finalizado correctamente.");

                    break;


                default:

                    System.out.println(
                            "Opcion incorrecta. Intente nuevamente.");
            }

        } while (opcion != 0);

        entrada.close();
    }
}