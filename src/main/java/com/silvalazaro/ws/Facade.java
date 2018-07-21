package com.silvalazaro.ws;

import com.silvalazaro.modelo.Modelo;
import com.silvalazaro.modelo.busca.Busca;
import com.silvalazaro.modelo.busca.Filtro;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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
public abstract class Facade<T extends Modelo> {

    protected Class<T> classe;
    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("Lami");
    private EntityManager EM;

    public Facade(Class<T> classe) {
        this.classe = classe;
        EM = EMF.createEntityManager();
    }

    /**
     * Persiste um objeto no banco de dados
     *
     * @param modelo Objeto que extenda Modelo
     * @return Response
     */
    public T salvar(T modelo) {

        EntityManager EM = EMF.createEntityManager();
        EM.getTransaction().begin();
        EM.persist(modelo);
        EM.getTransaction().commit();
        return modelo;
    }

    /**
     * Busca um objeto pela sua chave primaria
     *
     * @param id Chave primária do objeto
     * @return
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response selecionar(@PathParam("id") String id) {
        CriteriaBuilder cb = EM.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery(classe);
        Root root = query.from(classe);
        query.where(cb.equal(root.get("id"), id));
        T modelo = (T) EM.createQuery(query).getSingleResult();
        return Response.ok().entity(modelo).build();
    }

    @POST
    public Response criar(T modelo) {
        modelo = salvar(modelo);
        return Response.status(Response.Status.CREATED).entity(modelo).build();
    }

    /**
     * Remove um objeto do banco de dados
     *
     * @param id Chave primária do objeto
     * @return
     */
    @DELETE
    @Path("{id}")
    public Response remover(@PathParam("id") String id) {
        EM.getTransaction().begin();
        CriteriaBuilder cb = EM.getCriteriaBuilder();
        CriteriaDelete del = cb.createCriteriaDelete(classe);
        Root root = del.from(classe);
        del.where(cb.equal(root.get("id"), id));
        EM.createQuery(del).executeUpdate();
        EM.getTransaction().commit();
        return Response.ok().build();
    }

    /**
     * Método que remove todos os objetos
     *
     * @return
     */
    @DELETE
    public Response remover() {
        EM.getTransaction().begin();
        CriteriaBuilder cb = EM.getCriteriaBuilder();
        CriteriaDelete del = cb.createCriteriaDelete(classe);
        Root root = del.from(classe);
        Query query = EM.createQuery(del);
        query.executeUpdate();
        EM.getTransaction().commit();
        return Response.ok().build();
    }

    /**
     * Método que realiza busca de objetos
     *
     * @param busca Objeto que contem os parametros da busca
     * @return
     * @throws com.silvalazaro.ws.Excecao
     */
    @POST
    @Path("busca")
    public Response buscar(Busca busca) throws Excecao {
        CriteriaBuilder cb = EM.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery(classe);
        Root root = query.from(classe);
        Predicate where = filtroToPredicate(busca.getFiltro(), cb, root);
        query.where(where);
        return Response.ok().build();
    }

    private Filtro filtro(Filtro filtro) {
        return filtro;
    }

    private Predicate filtroToPredicate(Filtro filtro, CriteriaBuilder cb, Root root) throws Excecao {
        Predicate conjunto;
        Predicate temp = null;
        Predicate and = null;
        Predicate or = null;
        // obtem AND
        if (filtro.getE() != null & filtro.getE().size() > 0) {
            Predicate[] es = new Predicate[filtro.getE().size()];
            for (int i = 0; i < filtro.getE().size(); i++) {
                es[i] = filtroToPredicate(filtro.getE().get(i), cb, root);
            }
            and = cb.and(es);
        }
        // obtem OR
        if (filtro.getOu() != null && filtro.getOu().size() > 0) {
            Predicate[] os = new Predicate[filtro.getE().size()];
            for (int i = 0; i < filtro.getOu().size(); i++) {
                os[i] = filtroToPredicate(filtro.getE().get(i), cb, root);
            }
            and = cb.or(os);
        }
        switch (filtro.getOperador()) {
            case "%":
                temp = cb.like(root.get(filtro.getPropriedade()), filtro.getValor());
                break;
            default:
                throw new Excecao(Response.Status.BAD_REQUEST, "Operador condicional inválido");
        }
        if(and != null){
            conjunto = cb.and(temp, and);
            if(or != null){
                conjunto = cb.or(conjunto, or);
            }
        }else if(or != null){
            conjunto = cb.or(temp, or);
        }else{
            conjunto = temp;
        }
        return conjunto;
    }

    @PUT
    public Response atualizar() {
        return Response.ok().build();
    }

}
