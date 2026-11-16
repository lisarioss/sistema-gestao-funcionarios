package br.com.gestaofuncionarios.repository;

import java.util.concurrent.atomic.AtomicLong;

public class GeradorId {

    private final AtomicLong sequencia = new AtomicLong(0);

    public Long gerar() {
        return sequencia.incrementAndGet();
    }
}
