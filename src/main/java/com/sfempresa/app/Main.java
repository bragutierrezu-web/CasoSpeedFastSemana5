package com.sfempresa.app;

import com.sfempresa.entregas.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n==SERVICIO DE ENTREGAS SPEEDFAST==\n");
        System.out.println("[Zona de carga inicializada]\n");

        ZonaDeCarga zona = new ZonaDeCarga();


        zona.agregarPedido(new Pedido(1, "Santiago Centro"));
        zona.agregarPedido(new Pedido(2, "San Bernardo"));
        zona.agregarPedido(new Pedido(3, "El bosque"));
        zona.agregarPedido(new Pedido(4, "La Pintana"));
        zona.agregarPedido(new Pedido(5, "Las Condes"));


        Repartidor braulio = new Repartidor("Braulio", zona);
        Repartidor cecilia = new Repartidor("Cecilia", zona);
        Repartidor benjamin = new Repartidor("Benjamin", zona);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(braulio);
        executor.execute(cecilia);
        executor.execute(benjamin);

        executor.shutdown();

        while (!executor.isTerminated()) {

        }

        System.out.println("\n---Resultado Final---\n");
        System.out.println("Todos los pedidos han sido entregados exitosamente, gracias por su espera!!");
    }
}
