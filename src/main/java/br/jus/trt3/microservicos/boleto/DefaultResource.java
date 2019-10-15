package br.jus.trt3.microservicos.boleto;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/valor-reajustado")
public class DefaultResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String valorReajustado(@QueryParam("valorOriginal") double valorOriginal,
            @QueryParam("dataPagamento") Date dataPagamento) {

        // http://localhost:8080/valor-reajustado?valorOriginal=100&dataPagamento=15/09/2019

        System.out.println("valorOriginal: " + valorOriginal);
        System.out.println("dataPagamento: " + dataPagamento);

        double valor;

        long dias = (dataPagamento.getTime() - new Date().getTime()) / 1000 / 60 / 60 / 24;
        System.out.println("dias: " + dias);

        if (dias > 0) {
            valor = valorOriginal * (1 + (0.1 * dias) / 100);
        } else {
            valor = valorOriginal;
        }

        return "{valorReajustado:" + valor + "}";

    }
}