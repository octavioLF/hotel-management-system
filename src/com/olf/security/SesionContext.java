
package com.olf.security;

import com.olf.model.Usuario;
import java.time.LocalDateTime;

/**
 *
 * @author OctavioLF
 */
public class SesionContext {

    private static SesionContext instancia;

    private Usuario usuarioActual;
    private String rol;
    private LocalDateTime horaInicioSesion;

    
    public SesionContext() {
    }
    
    public static synchronized SesionContext getInstancia(){
        if (instancia == null){
            instancia = new SesionContext();
        }
        return instancia;
    }

    public Usuario getUsuarioActutal() {
        return usuarioActual;
    }

   public void setUsuarioActual (Usuario usuario){
       this.usuarioActual = usuario;
       if(usuario != null ){
           this.rol = usuario.getRol();
           this.horaInicioSesion = LocalDateTime.now();
       }else{
           this.rol = null;
           this.horaInicioSesion = null;
       }
   }
    
   public String getRol(){
       return rol;
   }
    
   public LocalDateTime getHoraInicioSesion(){
       return horaInicioSesion;
   }
   
   public void cerrarSesion(){
       this.usuarioActual = null;
       this.rol = null;
       this.horaInicioSesion = null;
   }
}
