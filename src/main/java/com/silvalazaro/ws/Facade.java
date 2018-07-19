package com.silvalazaro.ws;

import com.silvalazaro.modelo.Modelo;
import com.silvalazaro.modelo.busca.Busca;
import com.silvalazaro.modelo.busca.Filtro;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
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
     * Remove todos os objetos
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
     * Busca objetos
     *
     * @param busca Objeto que contem os parametros da busca
     * @return
     * @throws com.silvalazaro.ws.Excecao
     */
    @GET
    @Path("/")
    public Response buscar(Busca busca) throws Excecao {
        CriteriaBuilder cb = EM.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery(classe);
        Root root = query.from(classe);

        for (Filtro filtro : busca.getE()) {
            switch (filtro.getComparacao()) {
                case "=":
                    break;
                default:
                    throw new Excecao();
            }
        }
        return Response.ok().build();
    }

    @PUT
    public Response atualizar() {
        return Response.ok().build();
    }

}
