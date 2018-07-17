package com.silvalazaro.ws;

import com.silvalazaro.modelo.Modelo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Representa uma fachada de um recurso do Web Service
 *
 * @author Lazaro Silva
 * @param <T>
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Facade<T extends Modelo> {

    protected Class<T> classe;
    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("Lami");
    private EntityManager EM;

    public Facade(Class<T> classe) {
        this.classe = classe;
    }

    /**
     * Salvar uma entidade
     *
     * @param modelo Objeto que extenda Modelo
     * @return Response
     */
    public T salvar(T modelo) {

        EntityManager EMG = EMF.createEntityManager();
        EMG.getTransaction().begin();
        EMG.persist(modelo);
        EMG.getTransaction().commit();
        return modelo;
    }

    @GET
    @Path("{id}")
    public Response selecionar(@PathParam("id") String id) {
        return Response.ok().build();
    }

    @POST
    public Response criar(T modelo) {
        modelo = salvar(modelo);
        return Response.status(Response.Status.CREATED).entity(modelo).build();
    }

    @DELETE
    @Path("{id}")
    public Response remover(@PathParam("id") String id) {
        return Response.ok().build();
    }

    @DELETE
    public Response remover() {

        EntityManager EMG = EMF.createEntityManager();
        EMG.getTransaction().begin();
        CriteriaBuilder cb = EMG.getCriteriaBuilder();
        CriteriaDelete del = cb.createCriteriaDelete(classe);
        Root root = del.from(classe);
        Query query = EMG.createQuery(del);
        query.executeUpdate();
        EMG.getTransaction().commit();
        return Response.ok().build();
    }

    @GET
    @Path("/")
    public Response listar() {
        return Response.ok().build();
    }

    @PUT
    @Path("")
    public Response atualizar() {
        return Response.ok().build();
    }

}
