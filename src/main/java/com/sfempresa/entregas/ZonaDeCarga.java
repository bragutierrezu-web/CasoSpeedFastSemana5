package com.sfempresa.entregas;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ZonaDeCarga {

    private BlockingQueue<Pedido> pedidosPendientes = new LinkedBlockingQueue<>();

    // Agregar pedidos:
    public synchronized void agregarPedido(Pedido p) {
        pedidosPendientes.add(p);
        System.out.println("Pedido #" + p.getId() + " agregado correctamente. \nDestino: " + p.getDireccionEntrega());
    }

    // Retirar pedidos:
    public synchronized Pedido retirarPedido() {
        return pedidosPendientes.poll();
    }

    public boolean estaVacia() {
        return pedidosPendientes.isEmpty();
    }
}
