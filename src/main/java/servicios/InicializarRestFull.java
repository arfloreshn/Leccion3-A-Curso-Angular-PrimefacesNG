/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.Set;

/**
 * @author Allan Ramiro Flores Murillo
 * Esta clase tiene como objetivo levantar los servicios JAX-RESTFUL
 * Levanta o prepara todo el ambiente de servicios de los webservices creados con restful
 */
@javax.ws.rs.ApplicationPath("api")  //  "el api es un alias que usuaremos en nuestra web"
public class InicializarRestFull extends javax.ws.rs.core.Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(servicios.ActoresFacadeREST.class);
        resources.add(servicios.ActoresInterpretacionFacadeREST.class);
        resources.add(servicios.CafeteriaFacadeREST.class);
        resources.add(servicios.CanalVentaFacadeREST.class);
        resources.add(servicios.CrossOriginResourceSharingFilter.class);
        resources.add(servicios.EmpleadosFacadeREST.class);
        resources.add(servicios.FacturasFacadeREST.class);
        resources.add(servicios.FacturasPagosFacadeREST.class);
        resources.add(servicios.FormasPagoFacadeREST.class);
        resources.add(servicios.FuncionesFacadeREST.class);
        resources.add(servicios.InventarioDocFacadeREST.class);
        resources.add(servicios.InventarioFacadeREST.class);
        resources.add(servicios.MedioProyeccionFacadeREST.class);
        resources.add(servicios.MotivosCortesiaFacadeREST.class);
        resources.add(servicios.PaisesFacadeREST.class);
        resources.add(servicios.PasesFacadeREST.class);
        resources.add(servicios.PeliculasCategoriasFacadeREST.class);
        resources.add(servicios.PeliculasFacadeREST.class);
        resources.add(servicios.PreciosVtaFacadeREST.class);
        resources.add(servicios.PromocionesFacadeREST.class);
        resources.add(servicios.ProyectoresFacadeREST.class);
        resources.add(servicios.SalasFacadeREST.class);
        resources.add(servicios.SalasInventarioFacadeREST.class);
        resources.add(servicios.SalasPeliculasFacadeREST.class);
        resources.add(servicios.SalasProyectorFacadeREST.class);
        resources.add(servicios.SociedadFacadeREST.class);
        resources.add(servicios.SucursalFacadeREST.class);
        resources.add(servicios.UsuarioFacadeREST.class);
    }
    
}
